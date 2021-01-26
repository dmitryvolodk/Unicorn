package com.sg.dvdlibraryspringdi.ui;

import com.sg.dvdlibraryspringdi.dto.DVD;
import java.util.List;

public class DVDLibraryView {

    UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD Titles");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Create Many New DVDs in one session");
        io.print("7. Remove Many DVDs in one session");
        io.print("8. Edit Many DVDs in one session");
        io.print("9. Exit");

        return io.readInt("Please select from the" + " above choices.", 1, 9);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter Release Date");
        String MPAARating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter User Rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD(s) successfully created.  Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + ": "
                    + currentDVD.getReleaseDate() + " "
                    + currentDVD.getMPAARating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate() + " " + dvd.getMPAARating());
            io.print(dvd.getDirectorName() + " " + dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD(s) successfully removed. Please hit enter to continue.");
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditSuccessBanner() {
        io.readString("DVD(s) successfully edited.  Please hit enter to continue");
    }
    
    public void displayCreateManyDVDsBanner() {
        io.print("=== Create Many DVDs ===");
    }
    
    public int readNumberOfDVDs() {
        return io.readInt("Please enter the number of DVDs.");
    }
    
    public void displayCreateAnotherDVD() {
        io.print("Create (another) DVD:");
    }
    
    public void displayRemoveManyDVDsBanner() {
        io.print("=== Remove Many DVDs ===");
    }
    
    public void displayRemoveAnotherDVD() {
        io.print("Remove (another) DVD:");
    }
    
    public void displayEditManyDVDsBanner() {
        io.print("=== Edit Many DVDs ===");
    }
    
    public void displayEditAnotherDVD() {
        io.print("Edit (another) DVD:");
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
