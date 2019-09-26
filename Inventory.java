import java.util.ArrayList;

/**
 * This class satisfies the Project 1 requirements for CPSC 240.
 * @author Kelly Donaghey
 * @version 2019/09/21
 */

public class Inventory {
    private ArrayList<BikePart> partsList;

    /**
     * Constructor for objects of class Inventory.
     */
    public Inventory(){
        partsList = new ArrayList<>();
}

    /**
     * Method adds a BikePart object to partsList.
     * Note: may not need this and regular ArrayList method could suffice.
     * @param bikeItem
     */
    public void addPart(BikePart bikeItem){partsList.add(bikeItem);}

    /**
     * This method verifies if the BikePart object is already in partsList. If not, it adds the item to the list.
     * @param bikeItem
     */
    public void checkPart(BikePart bikeItem){
        if (partsList.contains(bikeItem.getPartNum())){
            int addNum = bikeItem.getQuantity(); //get qty of new part
            int index = partsList.indexOf(bikeItem.getPartNum());
            int number = partsList.get(index).getQuantity();
            int newQty = addNum + number;
            partsList.get(index).setQuantity(newQty);
            //set the qty already in the list
        }
        else{
            partsList.add(bikeItem);
        }
    }

    /**
     * This method prints the requested BikePart item to the screen.
     * @param bikeItem
     */
    public void displayPart(BikePart bikeItem){
        String name = bikeItem.getPartName();
        int num = bikeItem.getPartNum();
        double price = 0.0;
        if (bikeItem.isOnSale()){
            price = bikeItem.getSalesPrice();
        }
        else {
            price = bikeItem.getPrice();
        }
        int qty = bikeItem.getQuantity();

        System.out.println(name + " " + num + " " + price + " " + qty);
    }

    /**
     * This method decrements the BikePart quantity field in partsList for the specified BikePart object.
     * @param bikeItem
     */
    public void sellPart(BikePart bikeItem){
        int qty = bikeItem.getQuantity();
        bikeItem.setQuantity(qty - 1);
    }

}
