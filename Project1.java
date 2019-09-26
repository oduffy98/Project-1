import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Boolean;
import java.io.*;

public class Project1 {
    public static void main(String[] args) throws IOException{
        Inventory parts = new Inventory();
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
        sc.close();

        Scanner input = new Scanner(System.in);
        String user = input.next();
        while(!(user.equals("quit") || user.equals("Quit") || user.equals("QUIT"))){
            System.out.println("Please select your option from the following menu:");
            System.out.println("Read: Read an inventory delivery file");
            System.out.println("Enter: Enter a part");
            System.out.println("Display: Display a part");
            System.out.println("SortName: Sort parts by part name");
            System.out.println("SortNumber: Sort parts by part number");
            System.out.println("Quit");
            System.out.println("Enter your choice: ");
            if((user.equals("Read"))|| (user.equals("read"))){
                System.out.println("Please enter the name of the delivery file: ");
                Scanner fileRead = new Scanner(System.in);
                File readFile = new File(String.valueOf(fileRead));
                while(fileRead.hasNextLine()){
                    String newEntry = input.next();
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
                input.close();
            } else if ((userInput.equals("Sell") || userInput.equals("sell"))){
                System.out.println("Enter the part number: ");
                int number = input.nextInt();
                ArrayList <BikePart> array = parts.getInventory();
                for (BikePart part : array){
                    if (part.getPartNum().equals(number)){
                     parts.sellPart(part);
                     parts.displayPart(part);
                    }
                }
            }else if ((userInput.equals("Display") || userInput.equals("display"))){
                System.out.println("Enter the part number: ");
                int number = input.nextInt();
                ArrayList <BikePart> array = parts.getInventory();
                for (BikePart part : array){
                    if (part.getPartNum().equals(number)){
                        parts.displayPart(part);
                    }
                }
        }
    }
}
