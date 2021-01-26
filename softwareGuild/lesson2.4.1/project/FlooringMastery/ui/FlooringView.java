package com.sg.flooring.ui;

import com.sg.flooring.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlooringView {

    UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add an Order");
        io.print("2. View All Orders");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public Integer getOrderChoice() {
        Integer orderNumber = io.readInt("Please enter Order number");
        return orderNumber;
    }
    
    public LocalDate getDateChoice() {
        LocalDate date = io.readLocalDate("Please enter Date, e.g. 12-26-2020");
        return date;
    }

    public String getProceedChoice() {
        String proceedAnswer = io.readString("Would you like to proceed? (Y/N)");
        return proceedAnswer;
    }
    
    public Order getNewOrderInfo() {
        String customerName = io.readString("Please enter Customer Name");
        String state = io.readString("Please enter State Name abbriviation");
        String productType = io.readString("Please enter Product Type");
        BigDecimal area = io.readBigDecimal("Please enter Area");
        LocalDate orderDate = io.readLocalDate("Please enter Order Date");
        Order currentOrder = new Order();
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setProductType(productType);
        currentOrder.setArea(area);
        currentOrder.setOrderDate(orderDate);
        return currentOrder;
    }

    public Order getEditedOrderInfo(String customerName, String state, String productType, BigDecimal area) {
        String editedCustomerName = io.readString("Enter Customer Name (" + customerName + "):");
        String editedState = io.readString("Enter State Name abbriviation (" + state + "):");
        String editedProductType = io.readString("Enter Product Type (" + productType + "):");
        BigDecimal editedArea = io.readBigDecimal("Enter Area (" + area + "):");
            if (editedCustomerName.equals("")) {
                editedCustomerName = customerName;
            }
            if (editedState.equals("")) {
                editedState = state;
            }
            if (editedProductType.equals("")) {
                editedProductType = productType;
            }
            if (editedArea == null) {
                editedArea = area;
            }
        Order currentOrder = new Order();
        currentOrder.setCustomerName(editedCustomerName);
        currentOrder.setState(editedState);
        currentOrder.setProductType(editedProductType);
        currentOrder.setArea(editedArea);
        return currentOrder;
    }
    
    public void displayOrder(Order currentOrder) {
    // Specify the pattern of the incoming date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            io.print("Order Number: " + currentOrder.getOrderNumber() + "\n"
                    + "Customer Name: " + currentOrder.getCustomerName() + "\n"
                    + "State: " + currentOrder.getState() + "\n"
                    + "Tax rate: " + currentOrder.getTaxRate() + "\n"
                    + "Product type: " + currentOrder.getProductType() + "\n"
                    + "Area: " + currentOrder.getArea() + "\n"
                    + "Cost per square foot: " + currentOrder.getCostPerSquareFoot() + "\n"
                    + "Labor cost per square foot: " + currentOrder.getLaborCostPerSquareFoot() + "\n"
                    + "Material cost: " + currentOrder.getMaterialCost() + "\n"
                    + "Labor cost: " + currentOrder.getLaborCost() + "\n"
                    + "Tax amount: " + currentOrder.getTaxAmount() + "\n"
                    + "Total: " + currentOrder.getTotal() + "\n"
                    + "Order date: " + currentOrder.getOrderDate().format(formatter) + "\n");
    }
    
    public void displayDisplayOrderBanner() {
        io.print("=== Your Order: ===");
    }
    
    public void displayCreateOrderBanner() {
        io.print("=== Create Order ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Order successfully created. Please hit enter to continue");
    }

    public void displayOrderList(List<Order> orderList) {
    // Specify the pattern of the incoming date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        for (Order currentOrder : orderList) {
            io.print("Order Number: " + currentOrder.getOrderNumber() + "\n"
                    + "Customer Name: " + currentOrder.getCustomerName() + "\n"
                    + "State: " + currentOrder.getState() + "\n"
                    + "Tax rate: " + currentOrder.getTaxRate() + "\n"
                    + "Product type: " + currentOrder.getProductType() + "\n"
                    + "Area: " + currentOrder.getArea() + "\n"
                    + "Cost per square foot: " + currentOrder.getCostPerSquareFoot() + "\n"
                    + "Labor cost per square foot: " + currentOrder.getLaborCostPerSquareFoot() + "\n"
                    + "Material cost: " + currentOrder.getMaterialCost() + "\n"
                    + "Labor cost: " + currentOrder.getLaborCost() + "\n"
                    + "Tax amount: " + currentOrder.getTaxAmount() + "\n"
                    + "Total: " + currentOrder.getTotal() + "\n"
                    + "Order date: " + currentOrder.getOrderDate().format(formatter) + "\n");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Orders ===");
    }

    public void displayEditOrderBanner() {
        io.print("=== Edit Order ===");
    }

    public void displayEditSuccessBanner() {
        io.readString("Order(s) successfully edited.  Please hit enter to continue");
    }

    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please hit enter to continue.");
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
