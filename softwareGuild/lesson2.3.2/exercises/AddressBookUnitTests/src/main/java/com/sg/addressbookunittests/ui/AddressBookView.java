package com.sg.addressbookunittests.ui;

import com.sg.addressbookunittests.dto.Address;
import java.util.List;

public class AddressBookView {

    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("0. View address count");
        io.print("1. List persons Last Names");
        io.print("2. Create New Address");
        io.print("3. View an Address");
        io.print("4. Remove an Address");
        io.print("5. Exit");

        return io.readInt("Please select from the" + " above choices.", 0, 5);
    }

    public Address getNewAddressInfo() {
        String lastName = io.readString("Please enter Last Name");
        String firstName = io.readString("Please enter First Name");
        String streetAddress = io.readString("Please enter Street Address");
        String city = io.readString("Please enter City");
        String state = io.readString("Please enter State");
        String zipCode = io.readString("Please enter ZipCode");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setStreetAddress(streetAddress);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZipCode(zipCode);
        return currentAddress;
    }

    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Address successfully created.  Please hit enter to continue");
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getLastName() + ", "
                    + currentAddress.getFirstName() + "\n"
                    + currentAddress.getStreetAddress() + "\n"
                    + currentAddress.getCity() + ", "
                    + currentAddress.getState() + " "
                    + currentAddress.getZipCode());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }

    public void displayDisplayAddressBanner() {
        io.print("=== Display Address ===");
    }

    public String getLastNameChoice() {
        return io.readString("Please enter the Last Name.");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getLastName() + ", " + address.getFirstName());
            io.print(address.getStreetAddress());
            io.print(address.getCity() + ", " + address.getState() + " " + address.getZipCode());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveAddressBanner() {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Address successfully removed. Please hit enter to continue.");
    }

    public void displayAddressesCount(List<Address> addressList) {
        io.print(Integer.toString(addressList.size()));

        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayCountBanner() {
        io.print("Display Count:");
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
