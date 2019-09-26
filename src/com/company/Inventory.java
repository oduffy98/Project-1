package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class satisfies the Project 1 requirements for CPSC 240.
 *
 * @author Kelly Donaghey
 * @version 2019/09/21
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
     * Method adds a BikePart object to partsList.
     * Note: may not need this and regular ArrayList method could suffice.
     *
     * @param BikePart bikeItem
     */
    public void addPart(BikePart bikeItem) {
        partsList.add(bikeItem);
    }

    /**
     * This method verifies if the BikePart object is already in partsList. If not, it adds the item to the list.
     *
     * @param BikePart bikeItem
     */
    public String checkPart(BikePart bikeItem) {
        int counter = 0;
        String listContains = "false";
        while (counter < partsList.size()) {
            if (partsList.get(counter).getPartNum().equals(bikeItem.getPartNum()) ) {
                listContains = "true";
                int addNum = bikeItem.getQuantity(); //get qty of new part
                int addNum2 = partsList.get(counter).getQuantity();
                int finalNum = addNum + addNum2;
                partsList.get(counter).setQuantity(finalNum);
                //set the qty already in the list
            }
            ++counter;
        }
        return listContains;
    }

    /**
     * This method prints the requested BikePart item to the screen.
     *
     * @param BikePart bikeItem
     */
    public void displayPart(BikePart bikeItem) {
        String name = bikeItem.getPartName();
        int num = bikeItem.getPartNum();
        double price = 0.0;
        if (bikeItem.isOnSale()) {
            price = bikeItem.getSalesPrice();
        } else {
            price = bikeItem.getPrice();
        }
        int qty = bikeItem.getQuantity();

        System.out.println(name + " " + num + " " + price + " " + qty);
    }

    /**
     * This method decrements the BikePart quantity field in partsList for the specified BikePart object.
     *
     * @param BikePart bikeItem
     */
    public void sellPart(BikePart bikeItem) {
        int qty = bikeItem.getQuantity();
        bikeItem.setQuantity(qty - 1);
    }

    public ArrayList<BikePart> getInventory() {
        return partsList;
    }

    public void print() {
        int counter = 0;
        while (counter < partsList.size()) {
            System.out.println(partsList.get(counter).toString());
            ++counter;
        }
    }

    public void writeToFile(){
        int counter = 0;
        try {
            PrintWriter writer = new PrintWriter("WarehouseDB.txt");
            writer.println();
        }
        catch(FileNotFoundException e){

        }

    }

}
