package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineNoItemInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
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
