package com.sg.dvdlibraryspringdi.dao;

import com.sg.dvdlibraryspringdi.dto.DVD;
import java.util.List;

public interface DVDLibraryDao {

    /**
     * Adds the given DVD to the library and associates it with the given
     * title. If there is already a DVD associated with the given
     * title it will return that DVD object, otherwise it will return
     * null.
     *
     * @param title with which student is to be associated
     * @param DVD DVD to be added to the library
     * @return the DVD object previously associated with the given title
     * if it exists, null otherwise
     * @throws com.sg.dvdlibrary.dao.DVDLibraryDaoException
     */
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    /**
     * Returns a String array containing the titles of all DVDs in the
     * library.
     *
     * @return String array containing the titles of all the students in the library
     * @throws com.sg.dvdlibrary.dao.DVDLibraryDaoException
     */
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    /**
     * Returns the DVD object associated with the given title. Returns
     * null if no such DVD exists
     *
     * @param title title of the DVD to retrieve
     * @return the DVD object associated with the given title, null if
     * no such DVD exists
     * @throws com.sg.dvdlibrary.dao.DVDLibraryDaoException
     */
    DVD getDVD(String title) throws DVDLibraryDaoException;

    /**
     * Removes from the library the DVD associated with the given title. Returns
     * the DVD object that is being removed or null if there is no DVD
     * associated with the given title
     *
     * @param title title of DVD to be removed
     * @return DVD object that was removed or null if no DVD was
     * associated with the given title
     * @throws com.sg.dvdlibrary.dao.DVDLibraryDaoException
     */
    DVD removeDVD(String title) throws DVDLibraryDaoException;
    
    /**
     * Edits the given DVD in the library and associates it with the given
     * title. If there is already a DVD associated with the given
     * title it will return that DVD object, otherwise it will return
     * null.
     *
     * @param title with which student is to be associated
     * @param DVD DVD to be edited in the library
     * @return the DVD object previously associated with the given title
     * if it exists, null otherwise
     * @throws com.sg.dvdlibrary.dao.DVDLibraryDaoException
     */
    DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException;
}
