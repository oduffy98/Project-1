package com.company;

import java.util.*;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Boolean;
import java.io.*;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;


public class Main {
    public static void main(String[] args) throws IOException {
        Inventory parts = new Inventory();
        String userInput = "blah";
        File inFile = new File("WareHouseDB.txt");
        Scanner sc = new Scanner(inFile);
        Comparator<BikePart> sortbyName = comparing(BikePart::getPartName);
        Comparator<BikePart> sortbyNumber = comparing(BikePart::getPartNum);

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
        while ((!userInput.equals("Quit")) && ((!userInput.equals("quit"))) && (!userInput.equals("QUIT"))) {
            System.out.println("Please select your option from the following menu:");
            System.out.println("Read: Read an inventory delivery file");
            System.out.println("Enter: Enter a part");
            System.out.println("Display: Display a part");
            System.out.println("SortName: Sort parts by part name");
            System.out.println("SortNumber: Sort parts by part number");
            System.out.println("Quit");
            System.out.println("Enter your choice: ");

            userInput = input.next();

            if ((userInput.equals("Read")) || (userInput.equals("read"))) {
                System.out.println("Please enter the name of the delivery file: ");
                File file = new File(input.next());
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {
                    String newEntry = fileReader.next();
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
                fileReader.close();

            } else if ((userInput.equals("Enter")) || (userInput.equals("ENTER"))) {
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
                parts.print();
                System.out.println();
            } else if ((userInput.equals("SortName") || userInput.equals("sortname"))) {
                ArrayList<BikePart> sortList = parts.getInventory();
                sortList.sort(Comparator.comparing(BikePart::getPartName, String.CASE_INSENSITIVE_ORDER));
                parts.print();
            } else if ((userInput.equals("SortNumber")) || (userInput.equals("sortnumber") || (userInput.equals("sortNumber")))) {
                ArrayList<BikePart> sortList = parts.getInventory();
                sortList.sort(Comparator.comparing(BikePart::getPartNum));
                parts.print();
            }

        }
        FileWriter fileWriter = new FileWriter("WareHouseDB.txt", false);
        PrintWriter writer = new PrintWriter(fileWriter);
        int counter = 0;
        ArrayList<BikePart> partsToSave = parts.getInventory();
        while(counter < partsToSave.size()){
            writer.println(partsToSave.get(counter).toString());
            ++counter;
        }
        writer.close();

    }
}

