package com.sg.flooring.dao;

import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FlooringDaoFileImpl implements FlooringDao {

    private final String FLOORING_FILE;
    private final String PRODUCTS_FILE;
    private final String TAXES_FILE;
    private String orders_file;
    public static final String DELIMITER = ",";
    public static final String SECOND_DELIMITER = "-";
    public static int count = 0;

    public FlooringDaoFileImpl() {
        FLOORING_FILE = "flooring.txt";
        PRODUCTS_FILE = "products.txt";
        TAXES_FILE = "taxes.txt";
        orders_file = "";
    }

    public FlooringDaoFileImpl(String flooringTextFile, String productsTextFile, String taxesTextFile, String ordersTextFile) {
        FLOORING_FILE = flooringTextFile;
        PRODUCTS_FILE = productsTextFile;
        TAXES_FILE = taxesTextFile;
        orders_file = ordersTextFile;
    }

    // Specify the pattern of the incoming date
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    private Map<Integer, Order> orders = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Tax> taxes = new HashMap<>();

    @Override
    public Order addOrder(int orderNumber, Order order) throws FlooringPersistenceException {
        loadFlooring();
        Order newOrder = orders.put(orderNumber, order);
        writeFlooring();
        writeOrder();
        return newOrder;
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        loadFlooring();
        return new ArrayList<Order>(orders.values());
    }

    @Override
    public Order getOrder(Integer orderNumber) throws FlooringPersistenceException {
        loadFlooring();
        return orders.get(orderNumber);
    }

    @Override
    public Order editOrder(int orderNumber, Order order) throws FlooringPersistenceException {
        loadFlooring();
        Order editedOrder = orders.put(orderNumber, order);
        writeFlooring();
        writeOrder();
        return editedOrder;
    }

    @Override
    public Order removeOrder(int orderNumber) throws FlooringPersistenceException {
        loadFlooring();
        LocalDate date = getOrder(orderNumber).getOrderDate();
        Order removedOrder = orders.remove(orderNumber);
        writeFlooring();
        writeRemoveOrder(date);
        return removedOrder;
    }

    @Override
    public Product getProduct(String productType) throws FlooringPersistenceException {
        loadProductLibrary();
        return products.get(productType);
    }

    @Override
    public Tax getTax(String stateAbbreviation) throws FlooringPersistenceException {
        loadTaxLibrary();
        return taxes.get(stateAbbreviation);
    }

    public void loadProductLibrary() throws FlooringPersistenceException {
        Scanner scanner;
        count = 1;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load products data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // In our case we use , as our delimiter.  If
        // currentLine looks like this:
        // Tile,3.50,4.15
        // then currentTokens will be a string array that looks like this:
        // 
        // ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
        // ________________
        // |    |    |    | 
        // |Tile|3.50|4.15|
        // |    |    |    |   
        // ----------------
        //   [0]  [1]  [2]
        String[] currentTokens;
        // Go through PRODUCTS_FILE line by line, decoding each line into a 
        // Produtct object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            if (count >= 2) {
                // break up the line into tokens
                currentTokens = currentLine.split(DELIMITER);
                // Create a new Product object and put it into the map of products
                // We are going to use the product type
                // which is currentTokens[0] as the map key for our product object.
                // Note that we need to pass the productType into the product constructor
                Product currentProduct = new Product(currentTokens[0]);
                // Set the remaining values on currentProduct manually
                currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
                currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));

                // Put currentProduct into the map using productType as the key
                products.put(currentProduct.getProductType(), currentProduct);
            }
            count++;
        }
        // close scanner
        scanner.close();
    }

    public void loadTaxLibrary() throws FlooringPersistenceException {
        Scanner scanner;
        count = 1;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(TAXES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load taxes data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // In our case we use , as our delimiter.  If
        // currentLine looks like this:
        // CA,California,25.00
        // then currentTokens will be a string array that looks like this:
        // 
        // StateAbbreviation,StateName,TaxRate
        // _____________________
        // |  |          |     | 
        // |CA|California|25.00|
        // |  |          |     |   
        // ---------------------
        //  [0]    [1]     [2]
        String[] currentTokens;
        // Go through TAXES_FILE line by line, decoding each line into a 
        // Tax object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();

            if (count >= 2) {
                // break up the line into tokens
                currentTokens = currentLine.split(DELIMITER);
                // Create a new Tax object and put it into the map of taxes
                // We are going to use the state abbriviation
                // which is currentTokens[0] as the map key for our tax object.
                // Note that we need to pass the stateAbbreviation into the tax constructor
                Tax currentTax = new Tax(currentTokens[0]);
                // Set the remaining values on currentTax manually
                currentTax.setStateName(currentTokens[1]);
                currentTax.setTaxRate(new BigDecimal(currentTokens[2]));

                // Put currentTax into the map using stateAbbreviation as the key
                taxes.put(currentTax.getStateAbbreviation(), currentTax);
            }
            count++;
        }
        // close scanner
        scanner.close();
    }

    private void loadFlooring() throws FlooringPersistenceException {
        Scanner scanner;
        count = 1;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(FLOORING_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load flooring data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // In our case we use , as our delimiter.  If
        // currentLine looks like this:
        // 1,Ada Lovelace,CA,25.00,Tile,249.00,3.50,4.15,871.50,1033.35,476.21,2381.06,12-16-2020
        // then currentTokens will be a string array that looks like this:
        // 
        // OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate
        // ________________________________________________________________________________________
        // | |            |  |     |    |      |    |    |      |       |      |       |          |
        // |1|Ada Lovelace|CA|25.00|Tile|249.00|3.50|4.15|871.50|1033.35|476.21|2381.06|12-16-2020|
        // | |            |  |     |    |      |    |    |      |       |      |       |          |   
        // ----------------------------------------------------------------------------------------
        // [0]     [1]     [2]  [3]  [4]   [5]   [6]  [7]   [8]    [9]    [10]    [11]     [12]
        String[] currentTokens;
        // Go through FLOORING_FILE line by line, decoding each line into an 
        // Order object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {

            // get the next line in the file
            currentLine = scanner.nextLine();

            if (count >= 2) {
                // break up the line into tokens
                currentTokens = currentLine.split(DELIMITER);
                // Create a new Order object and put it into the map of orders
                // We are going to use the order number
                // which is currentTokens[0] as the map key for our order object.
                // Note that we don't need to pass the order number into the order constructor
                Order currentOrder = new Order();
                // Set all vlaues on currentStudent manually
                currentOrder.setOrderNumber(Integer.parseInt(currentTokens[0]));
                currentOrder.setCustomerName(currentTokens[1]);
                currentOrder.setState(currentTokens[2]);
                currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
                currentOrder.setProductType(currentTokens[4]);
                currentOrder.setArea(new BigDecimal(currentTokens[5]));
                currentOrder.setCostPerSquareFoot(new BigDecimal(currentTokens[6]));
                currentOrder.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[7]));
                currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
                currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
                currentOrder.setTaxAmount(new BigDecimal(currentTokens[10]));
                currentOrder.setTotal(new BigDecimal(currentTokens[11]));
                currentOrder.setOrderDate(LocalDate.parse(currentTokens[12], formatter));

                // Put currentOrder into the map using orderNumber as the key
                orders.put(currentOrder.getOrderNumber(), currentOrder);
            }
            count++;
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all orders in the flooring out to a FLOORING_FILE. See
     * loadFlooring for file format.
     *
     * @throws FlooringPersistenceException if an error occurs writing to the
     * file
     */
    private void writeFlooring() throws FlooringPersistenceException {
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(FLOORING_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save order data.", e);
        }

        // Write out the Order objects to the flooring file.
        // We could just grab the order map,
        // get the Collection of Orders and iterate over them but we've
        // already created a method that gets a List of Orders so
        // we'll reuse it.
        List<Order> orderList = this.getAllOrders();

        out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate");
        // force PrintWriter to write line to the file
        out.flush();

        // write the Item object to the file
        orderList.stream().forEach((currentOrder) -> {
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSquareFoot() + DELIMITER
                    + currentOrder.getLaborCostPerSquareFoot() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTaxAmount() + DELIMITER
                    + currentOrder.getTotal() + DELIMITER
                    + currentOrder.getOrderDate().format(formatter));
            // force PrintWriter to write line to the file
            out.flush();
        });

        // Clean up
        out.close();
    }

    /**
     * Writes a specific order out to an orders_file.
     *
     * @throws FlooringPersistenceException if an error occurs writing to the
     * file
     */
    private void writeOrder() throws FlooringPersistenceException {

        List<Order> orderList = this.getAllOrders();
        for (Order thisOrder : orderList) {
            orders_file = "Orders_";
            String[] monthDayYearTokens;
            monthDayYearTokens = thisOrder.getOrderDate().format(formatter).split(SECOND_DELIMITER);

            for (String currectDateElement : monthDayYearTokens) {
                orders_file = orders_file + currectDateElement;
            }
            orders_file = orders_file + ".txt";
            // The file format is the following:

            // OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate
            // ________________________________________________________________________________________
            // | |            |  |     |    |      |    |    |      |       |      |       |          |
            // |1|Ada Lovelace|CA|25.00|Tile|249.00|3.50|4.15|871.50|1033.35|476.21|2381.06|12-16-2020|
            // | |            |  |     |    |      |    |    |      |       |      |       |          |   
            // ----------------------------------------------------------------------------------------
            // [0]     [1]     [2]  [3]  [4]   [5]   [6]  [7]   [8]    [9]    [10]    [11]     [12]
            PrintWriter out;
            try {
                out = new PrintWriter(new FileWriter(orders_file));
            } catch (IOException e) {
                throw new FlooringPersistenceException("Could not save order data.", e);
            }

            out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
            // force PrintWriter to write line to the file
            out.flush();
            for (Order currentOrder : orderList) {
                if (thisOrder.getOrderDate().equals(currentOrder.getOrderDate())) {
                    // write the Order object to the file
                    out.println(currentOrder.getOrderNumber() + DELIMITER
                            + currentOrder.getCustomerName() + DELIMITER
                            + currentOrder.getState() + DELIMITER
                            + currentOrder.getTaxRate() + DELIMITER
                            + currentOrder.getProductType() + DELIMITER
                            + currentOrder.getArea() + DELIMITER
                            + currentOrder.getCostPerSquareFoot() + DELIMITER
                            + currentOrder.getLaborCostPerSquareFoot() + DELIMITER
                            + currentOrder.getMaterialCost() + DELIMITER
                            + currentOrder.getLaborCost() + DELIMITER
                            + currentOrder.getTaxAmount() + DELIMITER
                            + currentOrder.getTotal());
                    // force PrintWriter to write line to the file
                    out.flush();
                }
            }
            // Clean up
            out.close();
        }
    }

    /**
     * Removes a specific order from an orders_file.
     *
     * @throws FlooringPersistenceException if an error occurs writing to the
     * file
     */
    private void writeRemoveOrder(LocalDate date) throws FlooringPersistenceException {
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        // Write out the Order objects to the orders file.
        // We could just grab the order map,
        // get the Collection of Orders and iterate over them but we've
        // already created a method that gets a List of Orders so
        // we'll reuse it.
        List<Order> orderList = this.getAllOrders();
        
        String dateString = date.format(formatter);
        String[] monthDayYearTokens = dateString.split(SECOND_DELIMITER);

        orders_file = "Orders_";
        for (String currectDateElement : monthDayYearTokens) {
            orders_file = orders_file + currectDateElement;
        }
        orders_file = orders_file + ".txt";

        try {
            out = new PrintWriter(new FileWriter(orders_file));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save order data.", e);
        }

        out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
        // force PrintWriter to write line to the file
        out.flush();

        for (Order currentOrder : orderList) {
            if (date.equals(currentOrder.getOrderDate())) {
                // write the Order object to the file
                out.println(currentOrder.getOrderNumber() + DELIMITER
                        + currentOrder.getCustomerName() + DELIMITER
                        + currentOrder.getState() + DELIMITER
                        + currentOrder.getTaxRate() + DELIMITER
                        + currentOrder.getProductType() + DELIMITER
                        + currentOrder.getArea() + DELIMITER
                        + currentOrder.getCostPerSquareFoot() + DELIMITER
                        + currentOrder.getLaborCostPerSquareFoot() + DELIMITER
                        + currentOrder.getMaterialCost() + DELIMITER
                        + currentOrder.getLaborCost() + DELIMITER
                        + currentOrder.getTaxAmount() + DELIMITER
                        + currentOrder.getTotal());
                // force PrintWriter to write line to the file
                out.flush();
            }
        }
        // Clean up
        out.close();
    }
}
