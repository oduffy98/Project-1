package edu.project1;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Boolean;
import java.io.*;

public class Project1 {
    public static void main(String[] args) throws IOException{
        Inventory parts = new Inventory;
        File inFile = new File("warehouseDB.txt");
        Scanner sc = new Scanner(inFile);
        while(sc.hasNextLine()){
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
        fileIn.close();

        Scanner input = new Scanner(System.in);
        while((input != "quit") || (input != "Quit") || (input != "QUIT")){
            System.out.println("Please select your option from the following menu:");
            System.out.println("Read: Read an inventory delivery file");
            System.out.println("Enter: Enter a part");
            System.out.println("Display: Display a part");
            System.out.println("SortName: Sort parts by part name");
            System.out.println("SortNumber: Sort parts by part number");
            System.out.println("Quit");
            System.out.println("Enter your choice: ");
            input = in.next();
            if((input == "Read") || (input == "read")){
                System.out.println("Please enter the name of the delivery file: ")
                File readFile = new File(in.next());
                while(readFile.hasNextLine()){
                    String newEntry = readFile.next();
                    String[] newObj = newEntry.split(",");
                    String n = newObj[0];
                    int id = Integer.parseInt(newObj[1]);
                    double p = Double.parseDouble(newObj[2]);
                    double sp = Double.parseDouble(newObj[3]);
                    boolean s = Boolean.parseBoolean(newObj[4]);
                    int q = Integer.parseInt(newObj[5]);
                    BikePart bpName = new BikePart(n, id, p, sp, s, q);
                    parts.checkPart(bpName);
                }
                fileIn.close();
            }
        }
    }
}
