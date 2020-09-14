package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.AddressBookView;
import java.util.List;

public class AddressBookController {

    AddressBookView view;
    AddressBookDao dao;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 0:
                        showAddressesCount();
                        break;
                    case 1:
                        listAddresses();
                        break;
                    case 2:
                        createAddress();
                        break;
                    case 3:
                        viewAddress();
                        break;
                    case 4:
                        removeAddress();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createAddress() throws AddressBookDaoException {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAddresses() throws AddressBookDaoException {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }

    private void viewAddress() throws AddressBookDaoException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() throws AddressBookDaoException {
        view.displayRemoveAddressBanner();
        String lastname = view.getLastNameChoice();
        dao.removeAddress(lastname);
        view.displayRemoveSuccessBanner();
    }

    private void showAddressesCount() throws AddressBookDaoException {
        view.displayDisplayCountBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressesCount(addressList);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
