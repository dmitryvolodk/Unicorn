package com.sg.dvdlibrarystreams.ui;

import com.sg.dvdlibrarystreams.dto.DVD;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        io.print("10. Find all movies released in the last N years");
        io.print("11. Find all movies with a given MPAA rating");
        io.print("12. Find all movies by a given director");
        io.print("13. Find all movies released by a particular studio");
        io.print("14. Find the average age of movies in the collection");

        return io.readInt("Please select from the" + " above choices.", 1, 14);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter Release Date");
        String MPAARating = io.readString("Please enter MPAA Rating 1 to 10");
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

    public void displayDisplayNYearDVDsBanner() {
        io.print("=== Display DVDs Since Year N ===");
    }
    
    public int getYearChoice() {
        return io.readInt("Please enter the Year to list DVDs from.");
    }
    
    public void displayDVDListLastNYears(List<DVD> dvdList, int year) {
        List<DVD> lastNYears = dvdList.stream()
                .filter((d) -> Integer.parseInt(d.getReleaseDate()) >= year)
                .collect(Collectors.toList());
        displayDVDList(lastNYears);
    }
    
    public void displayDisplayMPAABanner() {
        io.print("=== Display DVDs of given MPAA rating ===");
    }
    
    public String getMPAAChoice() {
        return io.readString("Please enter the MPAA rating for DVDs.");
    }
    
    public void displayDVDListOfMPAARating(List<DVD> dvdList, String MPAA) {
        List<DVD> MPAADVDs = dvdList.stream()
                .filter((d) -> d.getMPAARating().equalsIgnoreCase(MPAA))
                .collect(Collectors.toList());
        displayDVDList(MPAADVDs);
    }
    
    public void displayDisplayDirectorBanner() {
        io.print("=== Display DVDs of given Director ===");
    }
    
    public String getDirectorChoice() {
        return io.readString("Please enter the director's name for DVDs.");
    }
    
    public void displayDVDListOfDirector(List<DVD> dvdList, String director) {
        List<DVD> directorDVDs = dvdList.stream()
                .filter((d) -> d.getDirectorName().equalsIgnoreCase(director))
                .collect(Collectors.toList());
        Map<String, List<DVD>> DVDsRatings = directorDVDs.stream()
                .collect(Collectors.groupingBy((d) -> d.getMPAARating()));
        displayDVDList(directorDVDs);
    }

    public void displayDisplayStudioBanner() {
        io.print("=== Display DVDs of given studio ===");
    }
    
    public String getStudioChoice() {
        return io.readString("Please enter the studio for DVDs.");
    }
    
    public void displayDVDListOfStudio(List<DVD> dvdList, String studio) {
        List<DVD> studioDVDs = dvdList.stream()
                .filter((d) -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
        displayDVDList(studioDVDs);
    }
    
    public void displayDisplayAverageAgeDVDsBanner() {
        io.print("=== Display average age of movies ===");
    }
    
    public void displayDVDListAverageAge(List<DVD> dvdList) {
        double averageAge = dvdList.stream().mapToDouble((d) -> d.getReleaseDateDouble()).average().getAsDouble();
        io.print(String.valueOf(averageAge));
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
