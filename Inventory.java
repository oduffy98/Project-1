package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class satisfies the Project 1 requirements for CPSC 240.
 *
 * @author Kelly Donaghey, Olivia Duffy, Keshyra Smith
 * @version 2019/09/27
 */

public class Inventory {
    private ArrayList<BikePart> partsList;

    /**
     * Constructor for objects of class Inventory.
     */
    public Inventory() {
        partsList = new ArrayList<>();
    }

    /**
     * Method adds a BikePart object to Inventory.
     *
     * @param bikeItem a BikePart object
     */
    public void addPart(BikePart bikeItem) {
        partsList.add(bikeItem);
    }

    /**
     * This method verifies if the BikePart object is already in partsList. If it is, It updates the Price, Sales Price, if it is on sale, and the quantity.
     *
     * @param bikeItem a BikePart object
     */
    public String checkPart(BikePart bikeItem) {
        int counter = 0;
        String listContains = "false";
        while (counter < partsList.size()) {
            if (partsList.get(counter).getPartNum().equals(bikeItem.getPartNum())) {
                listContains = "true";
                int newQuantity = bikeItem.getQuantity(); //get qty of new part
                int oldQuantity = partsList.get(counter).getQuantity();
                int finalQuantity = newQuantity + oldQuantity;
                partsList.get(counter).setQuantity(finalQuantity);
                partsList.get(counter).setPrice(bikeItem.getPrice());
                partsList.get(counter).setSalesPrice(bikeItem.getSalesPrice());
                partsList.get(counter).setOnSale(bikeItem.isOnSale());
                //set the qty already in the list
            }
            ++counter;
        }
        return listContains;
    }

    /**
     * This method prints the requested BikePart item to the screen when the user selects Display.
     *
     * @param bikeItem a BikePart object
     */
    public void displayPart(BikePart bikeItem) {
        String name = bikeItem.getPartName();
        double price = 0.0;
        if (bikeItem.isOnSale()) {
            price = bikeItem.getSalesPrice();
        } else {
            price = bikeItem.getPrice();
        }
        System.out.println("PartName: " + name + " " + "Price: " + price + " ");
    }

    /**
     * This method prints the BikePart item to the screen when the user selects Sell.
     *
     * @param bikeItem a BikePart object
     */
    public void sellDisplayPart(BikePart bikeItem) {
        String name = bikeItem.getPartName();
        double price = 0.0;
        Boolean onSale = bikeItem.isOnSale();
        LocalDateTime time = LocalDateTime.now();

        if (bikeItem.isOnSale()) {
            price = bikeItem.getSalesPrice();
        } else {
            price = bikeItem.getPrice();
        }
        int qty = bikeItem.getQuantity();

        System.out.println("PartName: " + name + " " + "OnSale: " + onSale + " " + "Price: " + price + " " + "Parts Remaining: " + qty + " " + "Time Sold: " + time);
    }

    /**
     * This method decrements the BikePart quantity field in partsList for the specified BikePart object.
     *
     * @param bikeItem a BikePart object
     */
    public void sellPart(BikePart bikeItem) {
        int qty = bikeItem.getQuantity();
        bikeItem.setQuantity(qty - 1);
    }

    /**
     * This method returns the contents of the program Inventory
     *
     * @return ArrayList<BikePart></BikePart>
     */
    public ArrayList<BikePart> getInventory() {
        return partsList;
    }

    /**
     * This method prints the content of the program Inventory
     */
    public void print() {
        int counter = 0;
        while (counter < partsList.size()) {
            System.out.println(partsList.get(counter).toString());
            ++counter;
        }
    }
}