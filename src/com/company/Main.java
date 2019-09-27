package com.company;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Inventory parts = new Inventory();
        File inFile = new File("warehouseDB.txt");
        Scanner sc = new Scanner(inFile);
        String user = "filler";

        while (sc.hasNextLine()) {
            String newEntry = sc.next();
            String[] newObj = newEntry.split(",");
            String n = newObj[0];
            int id = Integer.parseInt(newObj[1]);
            double p = Double.parseDouble(newObj[2]);
            double sp = Double.parseDouble(newObj[3]);
            boolean s = Boolean.parseBoolean(newObj[4]);
            int q = Integer.parseInt(newObj[5]);
            BikePart bpName = new BikePart(n, id, p, sp, s, q);
            parts.addPart(bpName);
        }
        sc.close();

        Scanner input = new Scanner(System.in);
        while ((!user.equals("Quit")) && ((!user.equals("quit"))) && (!user.equals("QUIT"))) {
            {
                System.out.println("Please select your option from the following menu:");
                System.out.println("Read: Read an inventory delivery file");
                System.out.println("Enter: Enter a part");
                System.out.println("Sell: Sell a part");
                System.out.println("Display: Display a part");
                System.out.println("SortName: Sort parts by part name");
                System.out.println("SortNumber: Sort parts by part number");
                System.out.println("Quit:");
                System.out.println("Enter your choice: ");
                user = input.next();
            }
            if (!(user.equals("Read") || user.equals("read") || user.equals("READ")
                    || user.equals("Enter") || user.equals("enter") || user.equals("ENTER")
                    || user.equals("Sell") || user.equals("SELL") || user.equals("sell")
                    || user.equals("Display") || user.equals("display") || user.equals("DISPLAY")
                    || user.equals("SortName") || user.equals("sortname") || user.equals("SORTNAME")
                    || user.equals("SortNumber") || user.equals("sortnumber") || user.equals("SORTNUMBER")
                    || user.equals("quit") || user.equals("Quit") || user.equals("QUIT"))) {

                System.out.println("Sorry. That's not a valid choice.");
            }

            if ((user.equals("Read")) || (user.equals("read")) || (user.equals("READ"))) {
                Boolean fileFound = false;
                while (!fileFound) {
                    try {
                        System.out.println("Please enter the name of the delivery file: ");
                        String fileName = input.next();
                        File readFile = new File(fileName);
                        Scanner fileRead = new Scanner(readFile);
                        fileFound = true;

                        while (fileRead.hasNextLine()) {
                            String newEntry = fileRead.nextLine();
                            String[] newObj = newEntry.split(",");
                            String n = newObj[0];
                            int id = Integer.parseInt(newObj[1]);
                            double p = Double.parseDouble(newObj[2]);
                            double sp = Double.parseDouble(newObj[3]);
                            boolean s = Boolean.parseBoolean(newObj[4]);
                            int q = Integer.parseInt(newObj[5]);
                            BikePart bpName = new BikePart(n, id, p, sp, s, q);
                            String listContains = parts.checkPart(bpName);
                            if (!listContains.equals("true")) {
                                parts.addPart(bpName);
                            }
                        }
                        fileRead.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not Found.");
                    }
                }

            } else if ((user.equals("Enter")) || (user.equals("ENTER") || (user.equals("enter")))) {
                System.out.println("Please enter the part name, part number, price, sales price, and if the item is on sale, and the quantity: ");
                input.useDelimiter(",|\r|\n");
                String partName = input.next();
                int partNumber = input.nextInt();
                double price = input.nextDouble();
                double salesPrice = input.nextDouble();
                boolean onSale = input.nextBoolean();
                int quantity = input.nextInt();
                BikePart bP = new BikePart(partName, partNumber, price, salesPrice, onSale, quantity);
                String add = parts.checkPart(bP);
                if (!add.equals("true")) {
                    parts.addPart(bP);
                }
            } else if ((user.equals("Sell") || (user.equals("sell") || (user.equals("SELL"))))) {
                System.out.println("Enter the part number: ");
                int number = input.nextInt();
                Boolean inStock = false;
                ArrayList<BikePart> array = parts.getInventory();
                for (BikePart part : array) {
                    if (part.getPartNum().equals(number)) {
                        parts.sellPart(part);
                        parts.sellDisplayPart(part);
                        inStock = true;
                    }
                }
                if (!inStock) {
                    System.out.println("This item is not currently in stock.");
                }

            } else if ((user.equals("Display") || user.equals("display"))) {
                System.out.println("Enter the part name: ");
                    String partName = input.next();
                    Boolean inStock = false;
                    ArrayList<BikePart> array = parts.getInventory();
                    for (BikePart part : array) {
                        if (part.getPartName().equals(partName)) {
                            parts.displayPart(part);
                            inStock = true;
                        }
                    }
                    if (!inStock) {
                        System.out.println("This item is not currently in stock.");
                    }
            } else if ((user.equals("SortName")) || (user.equals("sortname")) || (user.equals("SORTNAME"))) {
                ArrayList<BikePart> sortList = parts.getInventory();
                sortList.sort(Comparator.comparing(BikePart::getPartName, String.CASE_INSENSITIVE_ORDER));
                parts.print();

            } else if ((user.equals("SortNumber")) || (user.equals("sortnumber") || (user.equals("sortNumber")))) {
                ArrayList<BikePart> sortList = parts.getInventory();
                sortList.sort(Comparator.comparing(BikePart::getPartNum));
                parts.print();
            }
            System.out.println();

            FileWriter fileWriter = new FileWriter("WareHouseDB.txt", false);
            PrintWriter writer = new PrintWriter(fileWriter);
            ArrayList<BikePart> partsToSave = parts.getInventory();

            int counter = 0;
            while (counter < partsToSave.size() - 1) {
                writer.println(partsToSave.get(counter).toString());
                ++counter;
            }
            while (counter < partsToSave.size()) {
                writer.print(partsToSave.get(counter).toString());
                ++counter;
            }
            writer.close();
        }

        input.close();
    }

}


