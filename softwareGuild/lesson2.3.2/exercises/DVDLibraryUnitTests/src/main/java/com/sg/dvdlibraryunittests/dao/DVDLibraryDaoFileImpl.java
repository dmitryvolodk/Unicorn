package com.sg.dvdlibraryunittests.dao;

import com.sg.dvdlibraryunittests.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private final String LIBRARY_FILE;
    public static final String DELIMITER = "::";
    
    public DVDLibraryDaoFileImpl(){
        LIBRARY_FILE = "library.txt";
    }

    public DVDLibraryDaoFileImpl(String libraryTextFile){
        LIBRARY_FILE = libraryTextFile;
    }
    
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }
    
    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD editedDVD = dvds.put(title, dvd);
        writeLibrary();
        return editedDVD;
    }

    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // Best::2020::*****::Angelina Joly::Universal Studios::Very cool!
        // then currentTokens will be a string array that looks like this:
        //
        // ____________________________________________________________
        // |    |    |     |             |                 |          |
        // |Best|2020|*****|Angelina Joly|Universal Studios|Very cool!|
        // |    |    |     |             |                 |          |
        // ------------------------------------------------------------
        //  [0]  [1]   [2]        [3]             [4]          [5]
        String[] currentTokens;
        // Go through LIBRARY_FILE line by line, decoding each line into a 
        // DVD object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new DVD object and put it into the map of dvds
            // NOTE: We are going to use the title
            // which is currentTokens[0] as the map key for our DVD object.
            // We also have to pass the title into the DVD constructor
            DVD currentDVD = new DVD(currentTokens[0]);
            // Set the remaining vlaues on currentDVD manually
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setMPAARating(currentTokens[2]);
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setUserRating(currentTokens[5]);

            // Put currentDVD into the map using title as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all DVDs in the library out to a LIBRARY_FILE. See loadLibrary for
     * file format.
     *
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibraryDaoException {
        // NOTE: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save DVD data.", e);
        }

        // Write out the DVD objects to the library file.
        // NOTE: We could just grab the dvd map,
        // get the Collection of DVDs and iterate over them but we've
        // already created a method that gets a List of DVDs so
        // we'll reuse it.
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            // write the DVD object to the file
            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMPAARating() + DELIMITER
                    + currentDVD.getDirectorName() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserRating());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
