import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
 
public class ShoppingCart {
 
    /**
     * Jacob Schwartz and Owen Holman Semifinal Project for ICT12
     */
    public static void generateUI() {
        String lines = "|------------------------------------|";
        System.out.println(lines);
        System.out.println("|            JahCart main menu       |");
        System.out.println(lines);
        System.out.println("|1 Add an item to your JahCart       |");
        System.out.println("|2 Remove an item from your JahCart  |");
        System.out.println("|3 View the items in your JahCart    |");
        System.out.println("|4 View items, add Total and Checkout|");
        System.out.println("|5 Empty your JahCart                |");
        System.out.println("|6               Exit                |");
        System.out.println(lines);
        System.out.println("|     Please select a menu option    |");
        System.out.println(lines);
    }

    public static void generateSpacing() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static String getRandomPrice() {
        Random randomNumb = new Random();
        int price = randomNumb.nextInt(1000);
        price = price += 1;
        String stringPrice = Integer.toString(price);
        String finalPrice = "$"+stringPrice+".99";
        return finalPrice;
    }

    public static void main(String[] args) {
        // Initalize most datatypes
        ArrayList<String> shoppingCart = new ArrayList<String>();
        boolean stay = true;
        Scanner scan;
        Scanner prompt;
        String input;
        String item;
        int size;
        int choice = 0;
        int index = 0;
        int total = 0;
        String price = getRandomPrice();

        do
        {   
            scan = new Scanner(System.in);
            generateUI();
            //choice = scan.nextInt();
            while(!scan.hasNextInt()) {
                System.out.println("Input is not an integer. Please enter a valid input!");
                scan.next();
                generateSpacing();
                generateUI();
            }
            choice = scan.nextInt();
            scan.close();

            prompt = new Scanner(System.in);
            switch (choice)
            {
            case 1:
                // OPTION 1 - Add an Item
                System.out.print('\f');
                System.out.println("Enter an item:");
                input = prompt.nextLine();
                if (input.equals("cancel") || input.equals("exit")) {
                    System.out.println("Cancelling Operation...");
                }
                if (input.equals("Vatougios") || input.equals("Mr. Vatougios")) {
                    System.out.println("Sorry, John Vatougios cannot be purchased! He is too special! ¯\\_(ツ)_/¯");
                    System.out.println("Try to enter something less valuable!");
                    input = prompt.nextLine();
                }
                item = new String(input);
                shoppingCart.add(item);
                System.out.println(item + " has been added to the cart.");
                stay = true;
                generateSpacing();
                break;
            case 2:
                //OPTION 2 - Remove an Item
                System.out.print('\f');
                System.out.println("Enter an item to remove:");
                input = prompt.nextLine();
                item = new String(input);
                if (input.equals("cancel") || input.equals("exit")) {
                    System.out.println("Cancelling Operation...");
                }
                if (shoppingCart.contains(item))
                {
                    shoppingCart.remove(item);
                    System.out.println(item + " has been removed.");
                }
                else
                {
                    System.out.println(item + " was not found in your shopping JahCart.");
                }
                stay = true;
                generateSpacing();
                break;
            case 3:
                //OPTION 3 - View Items
                System.out.print('\f');
                if (shoppingCart.size() == 0) {
                    System.out.println("Your JahCart is Empty");
                } else {
                    System.out.println("Your JahCart consists of:");
                    for (String outputItem : shoppingCart) {
                        System.out.println("-   " + outputItem);
                    }
                    System.out.println("and costs a total of " + price);
                }
                stay = true;
                generateSpacing();
                break;
            case 4:
                //OPTION 4 - Checkout
                System.out.print('\f');
                System.out.println("Your JahCart consists of:");
                for (String outputItem : shoppingCart) {
                    System.out.println("-   " + outputItem);
                }
                if (shoppingCart.size() == 0) {
                    System.out.println("Your shopping cart is empty! Therefore, there is no need to pay!");
                } else {
                    System.out.println("The total price of your cart is " + price);
                    System.out.println("Enjoy express 2 day shipping to \'1044 Edgewood Rd, North Vancouver, BC V7R 1Y7\'");
                    System.out.println("Brought to you by the Vatougios-Post!");
                }
                System.out.println();
                System.out.println("Have a nice day!");
                stay = false;
                break;
            case 5:
                //Empty the list
                System.out.print('\f');
                shoppingCart.clear();
                System.out.println("JahCart Emptied!");
                stay = true;
                generateSpacing();
                break;
            case 6:
                //Exit
                System.out.print('\f');
                System.out.println("Thank you for visiting our digital shopping cart!");
                stay = false;
                break;
            default:
                System.out.print('\f');
                System.out.println("Sorry, your request was not between 1 and 6. Please enter a valid input.");
                stay = true;
                generateSpacing();
            }
        prompt.close();
        } while(stay);
    }
}