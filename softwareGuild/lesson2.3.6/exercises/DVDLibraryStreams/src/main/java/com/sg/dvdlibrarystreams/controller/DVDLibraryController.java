package com.sg.dvdlibrarystreams.controller;

import com.sg.dvdlibrarystreams.dao.DVDLibraryDao;
import com.sg.dvdlibrarystreams.dao.DVDLibraryDaoException;
import com.sg.dvdlibrarystreams.dto.DVD;
import com.sg.dvdlibrarystreams.ui.DVDLibraryView;
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
                    case 10:
                        listDVDsSinceYearN();
                        break;
                    case 11:
                        listDVDsOfMPAA();
                        break;
                    case 12:
                        listDVDsOfDirector();
                        break;
                    case 13:
                        listDVDsOfStudio();
                        break;
                    case 14:
                        listDVDsAverageAge();
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
    
    private void listDVDsSinceYearN() throws DVDLibraryDaoException {
        view.displayDisplayNYearDVDsBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        int year = view.getYearChoice();
        view.displayDVDListLastNYears(dvdList, year);
    }
    
    private void listDVDsOfMPAA() throws DVDLibraryDaoException {
        view.displayDisplayMPAABanner();
        List<DVD> dvdList = dao.getAllDVDs();
        String MPAA = view.getMPAAChoice();
        view.displayDVDListOfMPAARating(dvdList, MPAA);
    }

    private void listDVDsOfDirector() throws DVDLibraryDaoException {
        view.displayDisplayDirectorBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        String director = view.getDirectorChoice();
        view.displayDVDListOfDirector(dvdList, director);
    }
    
    private void listDVDsOfStudio() throws DVDLibraryDaoException {
        view.displayDisplayStudioBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        String studio = view.getStudioChoice();
        view.displayDVDListOfStudio(dvdList, studio);
    }
    
    private void listDVDsAverageAge() throws DVDLibraryDaoException {
        view.displayDisplayAverageAgeDVDsBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDListAverageAge(dvdList);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
