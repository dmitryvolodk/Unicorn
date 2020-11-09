package com.sg.addressbookunittests.dao;

import com.sg.addressbookunittests.dto.Address;
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

public class AddressBookDaoFileImpl implements AddressBookDao {

    public final String BOOK_FILE;
    public static final String DELIMITER = "::";
    
    public AddressBookDaoFileImpl(){
        BOOK_FILE = "book.txt";
    }
    // Overloaded constructor created for the test purposes
    public AddressBookDaoFileImpl(String bookTextFile){
        BOOK_FILE = bookTextFile;
    }

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookDaoException {
        Address newAddress = addresses.put(lastName, address);
        writeBook();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookDaoException {
        loadBook();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookDaoException {
        loadBook();
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookDaoException {
        Address removedAddress = addresses.remove(lastName);
        writeBook();
        return removedAddress;
    }

    @Override
    public int getAddressesCount() {
        ArrayList<Address> myList = new ArrayList<Address>(addresses.values());
        return myList.size();
    }

    private void loadBook() throws AddressBookDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a string array that looks like this:
        //
        // ________________________________________
        // |    |   |              |      |  |     |
        // |Volo|Dmi|105 Alstead St|Quincy|MA|02171|
        // |    |   |              |      |  |     |
        // ----------------------------------------
        //  [0]  [1]       [2]        [3]  [4] [5]
        String[] currentTokens;
        // Go through BOOK_FILE line by line, decoding each line into a 
        // Address object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Address object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the last name
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the last name into the Address constructor
            Address currentAddress = new Address(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreetAddress(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZipCode(currentTokens[5]);

            // Put currentAddress into the map using lastName as the key
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all addresses in the book out to a BOOK_FILE. See loadBook for
     * file format.
     *
     * @throws AddressBookDaoException if an error occurs writing to the file
     */
    private void writeBook() throws AddressBookDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(BOOK_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Address objects to the book file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Addresses so
        // we'll reuse it.
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // write the Address object to the file
            out.println(currentAddress.getLastName() + DELIMITER
                    + currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getStreetAddress() + DELIMITER
                    + currentAddress.getCity() + DELIMITER
                    + currentAddress.getState() + DELIMITER
                    + currentAddress.getZipCode());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
