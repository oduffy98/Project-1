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
        String user = "blah";
        LocalDateTime now = LocalDateTime.now();

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
                System.out.println("Display: Display a part");
                System.out.println("SortName: Sort parts by part name");
                System.out.println("SortNumber: Sort parts by part number");
                System.out.println("Quit");
                System.out.println("Enter your choice: ");
                user = input.next();
                if ((user.equals("Read")) || (user.equals("read"))) {
                    System.out.println("Please enter the name of the delivery file: ");
                    String fileName = input.next();
                    File readFile = new File(fileName);
                    Scanner fileRead = new Scanner(readFile);

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
                        String add = parts.checkPart(bpName);
                        if (!add.equals("true")) {
                            parts.addPart(bpName);
                        }
                    }
                } else if ((user.equals("Enter")) || (user.equals("ENTER"))) {
                    System.out.println("Please enter the part name, part number, price, sales price, and if the item is on sale, and the quantity");
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
                } else if ((user.equals("Sell") || (user.equals("sell")))) {
                    System.out.println("Enter the part number: ");
                    int number = input.nextInt();
                    ArrayList<BikePart> array = parts.getInventory();
                    for (BikePart part : array) {
                        if (part.getPartNum().equals(number)) {
                            parts.sellPart(part);
                            parts.sellDisplayPart(part);
                        }
                    }
                } else if ((user.equals("Display") || user.equals("display"))) {
                    System.out.println("Enter the part name: ");
                    String partName = input.next();
                    ArrayList<BikePart> array = parts.getInventory();
                    for (BikePart part : array) {
                        if (part.getPartName().equals(partName)) {
                            parts.displayPart(part);
                        }
                    }
                } else if ((user.equals("SortName") || user.equals("sortname"))) {
                    ArrayList<BikePart> sortList = parts.getInventory();
                    sortList.sort(Comparator.comparing(BikePart::getPartName, String.CASE_INSENSITIVE_ORDER));
                    parts.print();
                } else if ((user.equals("SortNumber")) || (user.equals("sortnumber") || (user.equals("sortNumber")))) {
                    ArrayList<BikePart> sortList = parts.getInventory();
                    sortList.sort(Comparator.comparing(BikePart::getPartNum));
                    parts.print();
                }
            }

            FileWriter fileWriter = new FileWriter("WareHouseDB.txt", false);
            PrintWriter writer = new PrintWriter(fileWriter);
            int counter = 0;
            ArrayList<BikePart> partsToSave = parts.getInventory();
            while (counter < partsToSave.size()) {
                writer.println(partsToSave.get(counter).toString());
                ++counter;
            }
            writer.close();

        }
    }


}

