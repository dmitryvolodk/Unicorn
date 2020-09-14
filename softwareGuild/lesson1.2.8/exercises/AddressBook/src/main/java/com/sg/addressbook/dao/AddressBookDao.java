package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;

public interface AddressBookDao {

    /**
     * Adds the given Address to the book and associates it with the given
     * person last name. If there is already a address associated with the given
     * person last name it will return that address object, otherwise it will return
     * null.
     *
     * @param lastName name with which address is to be associated
     * @param address address to be added to the book
     * @return the Address object previously associated with the given person
     * lastName if it exists, null otherwise
     * @throws com.sg.addressbook.dao.AddressBookDaoException 
     */
    Address addAddress(String lastName, Address address) throws AddressBookDaoException ;

    /**
     * Returns a String array containing the persons last names of all addresses in the
     * book.
     *
     * @return String array containing the last names of all the persons in the book
     * @throws com.sg.addressbook.dao.AddressBookDaoException  
     */
    List<Address> getAllAddresses() throws AddressBookDaoException ;

    /**
     * Returns the address object associated with the given last name. Returns
     * null if no such address exists
     *
     * @param lastName last name of the address to retrieve
     * @return the Address object associated with the given last name, null if
     * no such student exists
     * @throws com.sg.addressbook.dao.AddressBookDaoException  
     */
    Address getAddress(String lastName) throws AddressBookDaoException ;

    /**
     * Removes from the book the address associated with the given last name. Returns
     * the address object that is being removed or null if there is no address
     * associated with the given last name
     *
     * @param lastName last name of address to be removed
     * @return Address object that was removed or null if no address was
     * associated with the given last name
     * @throws com.sg.addressbook.dao.AddressBookDaoException  
     */
    Address removeAddress(String lastName) throws AddressBookDaoException ;
    
    /**
     * Returns a size of String array containing the persons last names of all addresses in the
     * book.
     *
     * @return a size of String array containing the last names of all the persons in the book
     * @throws com.sg.addressbook.dao.AddressBookDaoException  
     */
    int getAddressesCount() throws AddressBookDaoException ;
}
