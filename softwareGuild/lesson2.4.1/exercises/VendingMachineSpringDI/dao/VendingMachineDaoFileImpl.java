package com.sg.vendingmachinespringdi.dao;

import com.sg.vendingmachinespringdi.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private final String MACHINE_FILE;
    public static final String DELIMITER = "::";
    private Map<String, Item> items = new HashMap<>();

    public VendingMachineDaoFileImpl(){
        MACHINE_FILE = "machine.txt";
    }
    
    public VendingMachineDaoFileImpl(String machineTextFile){
        MACHINE_FILE = machineTextFile;
    }
    
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadMachine();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item updateItem(String name, Item item) throws VendingMachinePersistenceException {
        Item updatedItem = items.replace(name, item);
        writeMachine();
        return updatedItem;
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        loadMachine();
        return items.get(name);
    }

    private void loadMachine() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MACHINE_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load machine data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // Snickers Bar::5::1.39
        // then currentTokens will be a string array that looks like this:
        //
        // _____________________
        // |            | |    |                  
        // |Snickers Bar|5|1.39|
        // |            | |    |                  
        // ---------------------
        //       [0]    [1] [2]         
        String[] currentTokens;
        // Go through MACHINE_FILE line by line, decoding each line into an 
        // Item object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Item object and put it into the map of items
            // We are going to use the item name
            // which is currentTokens[0] as the map key for our item object.
            // We also have to pass the item name into the Item constructor
            Item currentItem = new Item(currentTokens[0]);
            // Set the remaining vlaues on currentItem manually
            currentItem.setItemsNumber(Integer.parseInt(currentTokens[1]));
            currentItem.setCost(new BigDecimal(currentTokens[2]));

            // Put currentItem into the map using item name as the key
            items.put(currentItem.getName(), currentItem);

            // Test:
            //Collection<Item> itemTest = items.values();
            //for (Item curItem : itemTest) {
            //    System.out.println(curItem.getName() + DELIMITER + curItem.getItemsNumber() + DELIMITER + curItem.getCost());
            //}
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all items in the machine out to a MACHINE_FILE. See loadRoster for
     * file format.
     *
     * @throws VendingMachinePersistenceException if an error occurs writing to
     * the file
     */
    private void writeMachine() throws VendingMachinePersistenceException {
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(MACHINE_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }

        // Write out the Item objects to the machine file.
        // We could just grab the item map,
        // get the Collection of Items and iterate over them. However, if we've
        // already created a method that gets a List of Items - then
        // reuse it. We also can use ForEach terminal operation here.
        Collection<Item> itemValues = items.values();

        // write the Item object to the file
        itemValues.stream().forEach((i) -> {
            out.println(i.getName() + DELIMITER
                    + i.getItemsNumber() + DELIMITER
                    + i.getCost());
            // force PrintWriter to write line to the file
            out.flush();
        });

        // Clean up
        out.close();
    }
}
