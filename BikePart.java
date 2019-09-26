/**
 * This class satisfies the Project 1 requirements for CPSC 240.
 * @author Kelly Donaghey
 * @version 2019/09/21
 */

public class BikePart {
    private String partName;
    private int partNum;
    private double price;
    private double salesPrice;
    private boolean onSale;
    private int quantity;

    /**
     * Constructor for objects of class BikePart
     */
    public BikePart(String partName, int partNum, double price, double salesPrice, boolean onSale, int quantity){
        this.partName = partName;
        this.partNum = partNum;
        this.price = price;
        this.salesPrice = salesPrice;
        this.onSale = onSale;
        this.quantity = quantity;
    }

    /**
     * Method returns the name of the part.
     * @return String
     */
    public String getPartName(){
        return this.partName;
    }

    /**
     * Method changes name of the object.
     * @param name
     */
    public void setPartName(String name){
        this.partName = name;
    }

    /**
     * Method returns the part's identification number.
     * @return int
     */
    public int getPartNum(){
        return this.partNum;
    }

    /**
     * Method changes the identification number.
     * @param newNum
     */
    public void setPartNum(int newNum) {
        this.partNum = newNum;
    }

    /**
     * Method returns the price of the part.
     * @return int;
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Method changes the price of the part.
     * @param newPrice
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Method returns the sales price.
     * @return int;
     */
    public double getSalesPrice(){
        return this.salesPrice;
    }

    /**
     * Method changes sales price.
     * @param newSalesPrice
     */
    public void setSalesPrice(double newSalesPrice) {
        this.salesPrice = newSalesPrice;
    }

    /**
     * Method checks if the part is on sale.
     * @return boolean;
     */
    public boolean isOnSale(){
        return this.onSale;
    }

    /**
     * Method changes sales status of object.
     * @param onSale
     */
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    /**
     * Method checks part quantity
     * @return int;
     */
    public int getQuantity(){return this.quantity;}

    /**
     * Method changes part quantity
     * @param quantity
     */
    public void setQuantity(int quantity){this.quantity = quantity;}
}
