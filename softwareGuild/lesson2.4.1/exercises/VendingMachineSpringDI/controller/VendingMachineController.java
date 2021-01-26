package com.sg.vendingmachinespringdi.controller;

import com.sg.vendingmachinespringdi.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinespringdi.dto.Change;
import com.sg.vendingmachinespringdi.dto.Item;
import com.sg.vendingmachinespringdi.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinespringdi.service.VendingMachineNoItemInventoryException;
import com.sg.vendingmachinespringdi.service.VendingMachineServiceLayer;
import com.sg.vendingmachinespringdi.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachineController {

    VendingMachineView view;
    private VendingMachineServiceLayer service;
    Change change;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view, Change change) {
        this.service = service;
        this.view = view;
        this.change = change;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            selectPurchase(keepGoing, menuSelection);
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() throws VendingMachinePersistenceException {
        List<Item> itemList = service.getAllItems();
        return view.printMenuAndGetSelection(itemList);
    }

    private void purchaseItem(String name) throws VendingMachinePersistenceException {
        view.displayPurchaseItemBanner();
        boolean hasErrors = false;
        BigDecimal money = view.getMoneyChoice();
        do {
            if (hasErrors == true) {
                return;
                //selectPurchase(keepGoing, menuSelection);
                //hasErrors = false;
            }
            try {
                service.updateItem(name, money);
                Item item = service.getItem(name);
                change.calculateChange(money, item.getCost());
                view.displayChange(change);
                view.displayPurchaseSuccessBanner();
            } catch (VendingMachineInsufficientFundsException | VendingMachineNoItemInventoryException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void selectPurchase(boolean keepGoing, int menuSelection) throws VendingMachinePersistenceException {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            if (menuSelection == 0) {
                keepGoing = false;
            } else {// Purchase e.g. SNICKERS BAR
                purchaseItem(service.getAllItems().get(menuSelection - 1).getName());
            }
        }
        exitMessage();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
