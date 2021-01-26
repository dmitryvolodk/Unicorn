package com.sg.vendingmachinespringdi.ui;

import com.sg.vendingmachinespringdi.dto.Change;
import com.sg.vendingmachinespringdi.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(List<Item> itemList) {
        io.print("Main Menu");
        io.print("0. Exit");
        // Snickers Bar::5::1.89
        // Clif Bar::5::1.89
        // Sun Chips::5::1.68
        // Granola Bar::5::1.19

        for(int maxChoice = 0; maxChoice < itemList.size(); maxChoice++){
            io.print((maxChoice + 1) + ". " + itemList.get(maxChoice).getName() + " - "
                    + itemList.get(maxChoice).getItemsNumber() + " count - "
                    + "$" + itemList.get(maxChoice).getCost().toString());
        }
        return io.readInt("Please select from the above choices.", 0, itemList.size());
    }

    public void displayPurchaseItemBanner() {
        io.print("=== Purchase Item ===");
    }

    public BigDecimal getMoneyChoice() {
        return io.readBigDecimal("Please put some amount of money.");
    }

    public void displayChange(Change change) {
        if (change != null) {
            io.print("Quarters: " + String.valueOf(change.getQuartersNumber()));
            io.print("Dimes: " + String.valueOf(change.getDimesNumber()));
            io.print("Nickels: " + String.valueOf(change.getNickelsNumber()));
            io.print("Pennies: " + String.valueOf(change.getPenniesNumber()));
            io.print("");
        } else {
            io.print("No change.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayPurchaseSuccessBanner() {
        io.readString("Item successfully purchased. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
