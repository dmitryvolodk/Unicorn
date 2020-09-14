package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryDao dao;
    private int numberOfDVDs;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
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
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        createManyDVDs();
                        break;
                    case 7:
                        removeManyDVDs();
                        break;
                    case 8:
                        editManyDVDs();
                        break;
                    case 9:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        DVD editedDVD = view.getNewDVDInfo();
        dao.editDVD(editedDVD.getTitle(), editedDVD);
        view.displayEditSuccessBanner();
    }

    private void createManyDVDs() throws DVDLibraryDaoException {
        view.displayCreateManyDVDsBanner();
        numberOfDVDs = view.readNumberOfDVDs();
        for (int i = 0; i < numberOfDVDs; i++) {
            view.displayCreateAnotherDVD();
            DVD newDVD = view.getNewDVDInfo();
            dao.addDVD(newDVD.getTitle(), newDVD);
        }
        view.displayCreateSuccessBanner();
    }

    private void removeManyDVDs() throws DVDLibraryDaoException {
        view.displayRemoveManyDVDsBanner();
        numberOfDVDs = view.readNumberOfDVDs();
        for (int i = 0; i < numberOfDVDs; i++) {
            view.displayRemoveAnotherDVD();
            String title = view.getTitleChoice();
            dao.removeDVD(title);
        }
        view.displayRemoveSuccessBanner();
    }

    private void editManyDVDs() throws DVDLibraryDaoException {
        view.displayEditManyDVDsBanner();
        numberOfDVDs = view.readNumberOfDVDs();
        for (int i = 0; i < numberOfDVDs; i++) {
            view.displayEditAnotherDVD();
            DVD editedDVD = view.getNewDVDInfo();
            dao.editDVD(editedDVD.getTitle(), editedDVD);
        }
        view.displayEditSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
