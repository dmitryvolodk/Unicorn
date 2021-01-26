package com.sg.flooring.controller;

import com.sg.flooring.dao.FlooringDao;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dao.FlooringDaoFileImpl;
import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import com.sg.flooring.service.FlooringDataValidationException;
import com.sg.flooring.service.FlooringServiceLayer;
import com.sg.flooring.service.IncorrectDateException;
import com.sg.flooring.service.InvalidAreaException;
import com.sg.flooring.service.NoSuchOrderException;
import com.sg.flooring.service.NoSuchProductTypeException;
import com.sg.flooring.service.NoSuchStateException;
import com.sg.flooring.ui.FlooringView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class FlooringController {

    FlooringView view;
    FlooringServiceLayer service;

    public FlooringController(FlooringServiceLayer service, FlooringView view) {
        this.service = service;
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
                        createOrder();
                        break;
                    case 2:
                        listOrders();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (FlooringPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createOrder() throws FlooringPersistenceException {
        int orderNumber = 0;
        view.displayCreateOrderBanner();
        boolean hasErrors = false;
        do {
            hasErrors = false;
            Order newOrder = view.getNewOrderInfo();
            try {
                List<Order> orderList = service.getAllOrders();
                if (orderList.size() == 0) {
                    orderNumber = 1;
                } else {
                    orderNumber = orderList.get(orderList.size() - 1).getOrderNumber() + 1;
                }
                newOrder.setOrderNumber(orderNumber);

                newOrder = service.calculate(newOrder);

                view.displayDisplayOrderBanner();
                view.displayOrder(newOrder);
                String answer = view.getProceedChoice();
                if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                    service.createOrder(newOrder);
                    view.displayCreateSuccessBanner();
                }
            } catch (IncorrectDateException | FlooringDataValidationException
                    | NoSuchStateException | NoSuchProductTypeException | InvalidAreaException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listOrders() throws FlooringPersistenceException {
        view.displayDisplayAllBanner();
        boolean hasErrors = false;
        do {
            hasErrors = false;
            LocalDate date = view.getDateChoice();
            try {
                List<Order> orderList = service.getAllOrders(date);
                view.displayOrderList(orderList);
            } catch (NoSuchOrderException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void editOrder() throws FlooringPersistenceException {
        view.displayEditOrderBanner();
        boolean hasErrors = false;
        do {
            hasErrors = false;
            int orderNumber = view.getOrderChoice();
            try {
                Order order = service.getOrder(orderNumber);
                LocalDate date = LocalDate.now();
                if (order != null) {
                    date = view.getDateChoice();
                }
                // Here where we can find if there is no such order
                if (order != null && order.getOrderDate().isEqual(date)) {
                    Order editedOrder = view.getEditedOrderInfo(order.getCustomerName(), order.getState(), order.getProductType(), order.getArea());
                    editedOrder.setOrderDate(date);
                    editedOrder.setOrderNumber(orderNumber);

                    editedOrder = service.calculate(editedOrder);

                    view.displayDisplayOrderBanner();
                    view.displayOrder(editedOrder);
                    String answer = view.getProceedChoice();
                    if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                        service.editOrder(editedOrder);
                        view.displayEditSuccessBanner();
                    }
                } else {
                    view.displayErrorMessage("ERROR: Order cannot be edited because it doesn't exist.");
                }
            } catch (FlooringDataValidationException | NoSuchStateException
                    | NoSuchProductTypeException | InvalidAreaException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void removeOrder() throws FlooringPersistenceException {
        view.displayRemoveOrderBanner();
        Integer orderNumber = view.getOrderChoice();
        LocalDate date = LocalDate.now();
        Order order = service.getOrder(orderNumber);

        if (order != null) {
            date = view.getDateChoice();
        }

        // Here where we see that there is no such order
        if (order != null && order.getOrderDate().isEqual(date)) {
            view.displayDisplayOrderBanner();
            view.displayOrder(order);
            String answer = view.getProceedChoice();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                service.removeOrder(orderNumber);
                view.displayRemoveSuccessBanner();
            }
        } else {
            view.displayErrorMessage("ERROR: Order cannot be removed because it doesn't exist.");
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
