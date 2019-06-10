import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
 
public class ShoppingCart {
 
    /**
     * Jacob Schwartz and Owen Holman Semifinal Project for ICT12
     */

    // method for generating the UI
    public static void generateUI() {
        String lines = "|------------------------------------|"; // lines string part 
        System.out.println(lines); // printing lines
        System.out.println("|          JahCart main menu         |"); // printing the menu
        System.out.println(lines); // printing lines
        System.out.println("|1 Add an item to your JahCart       |"); // printing the menu
        System.out.println("|2 Remove an item from your JahCart  |"); // printing the menu
        System.out.println("|3 View the items in your JahCart    |"); // printing the menu
        System.out.println("|4 View items, add Total and Checkout|"); // printing the menu
        System.out.println("|5 Empty your JahCart                |"); // printing the menu
        System.out.println("|6               Exit                |"); // printing the menu
        System.out.println(lines); // printing lines
        System.out.println("|     Please select a menu option    |"); // printing the menu
        System.out.println(lines); // printing lines
    }

    // method for generating spacing
    public static void generateSpacing() {
        System.out.println(); // white space
        System.out.println(); // white space
        System.out.println(); // white space
    }

    // method for generating final price
    public static String getRandomPrice() {
        Random randomNumb = new Random(); // intializing randomNumb to use later
        int price = randomNumb.nextInt(1000); // getting a random number as integer multiplying by 1000
        price = price += 1; // adding 1 to the number incase it is 0
        String stringPrice = Integer.toString(price); // converting the price integer to a string
        String finalPrice = "$"+stringPrice+".99"; // adding that price to a string with the dollar sign and .99 to make it more authentic
        return finalPrice; // return the variable
    }

    public static void main(String[] args) {
        // Initalize most datatypes
        ArrayList<String> shoppingCart = new ArrayList<String>(); // intializing our array list called shoppingCart
        boolean stay = true; // creating a boolean for the while loop
        Scanner scan; // intializing a scanner - scan
        Scanner prompt; // intializing a scanner - prompt
        String input; // creating a String called input
        String item; // creating a String called item
        int size; // creating an int called size
        int choice = 0; // creating an int called choice
        int index = 0; // creating an int called index
        int total = 0; // creating an int called total
        String price = getRandomPrice(); // creating a String called price where the value is a variable returned from the previous method

        do // start of do while loop
        {   
            scan = new Scanner(System.in); // initializing the scanner called scan
            generateUI();
            //choice = scan.nextInt();
            // while loop verfying that the input is an integer
            while(!scan.hasNextInt()) {
                System.out.println("Input is not an integer. Please enter a valid input!");
                scan.next(); // calling the scanner if not an int to try again
                generateSpacing(); // calling the method to give whitespace
                generateUI(); // calling the method to bring the UI
            }
            choice = scan.nextInt(); // calling the scanner to find a choice in the UI
            scan.close(); // closing the scanner to prevent errors

            prompt = new Scanner(System.in); // initializing the scanner called scan
            switch (choice) //switch
            {
            case 1:
                // OPTION 1 - Add an Item
                System.out.print('\f'); // clears the screen
                System.out.println("Enter an item:"); // before the scanner this message prompts you
                input = prompt.nextLine(); // the prompt
                // adding functionality - exit option
                if (input.equals("cancel") || input.equals("exit")) {
                    System.out.println("Cancelling Operation..."); // the print out
                }
                // adding functionality - Vatougios option
                if (input.equals("Vatougios") || input.equals("Mr. Vatougios")) {
                    // what prints in the event that you enter either options above
                    System.out.println("Sorry, John Vatougios cannot be purchased! He is too special! ¯\\_(ツ)_/¯");
                    System.out.println("Try to enter something less valuable!");
                    input = prompt.nextLine(); // the prompt retrying
                }
                item = new String(input); // putting that String into the variable item
                shoppingCart.add(item); // adding the variable item to the arraylist shopping cart
                System.out.println(item + " has been added to the cart."); // printing for UI
                stay = true; // re running the do while loop by keeping this boolean true
                generateSpacing(); // calling the method
                break; // the break to case 1
            case 2:
                //OPTION 2 - Remove an Item
                System.out.print('\f'); // clears the screen
                System.out.println("Enter an item to remove:"); // before the scanner this message prompts you
                input = prompt.nextLine(); // the prompt
                item = new String(input); // putting that String into the variable item
                // adding functionality - exit option
                if (input.equals("cancel") || input.equals("exit")) {
                    System.out.println("Cancelling Operation..."); // the print out
                }
                // if the shoppingCart has the input it proceeds to remote the input
                if (shoppingCart.contains(item))
                {
                    shoppingCart.remove(item);
                    System.out.println(item + " has been removed.");
                }
                else
                {
                    System.out.println(item + " was not found in your shopping JahCart.");
                }
                stay = true; // re running the do while loop by keeping this boolean true
                generateSpacing(); // calling the method
                break; // the break to case 2
            case 3:
                //OPTION 3 - View Items
                System.out.print('\f'); // clears the screen
                // if the cart is empty it gives this
                if (shoppingCart.size() == 0) {
                    System.out.println("Your JahCart is Empty");
                } 
                // if not it will proceed with this...
                else {
                    System.out.println("Your JahCart consists of:"); // printing in the cart
                    // for loop to print each item
                    for (String outputItem : shoppingCart) {
                        System.out.println("-   " + outputItem); // printing each item
                    }
                    System.out.println("and costs a total of " + price); // and then prints out the String
                }
                stay = true; // re running the do while loop by keeping this boolean true
                generateSpacing(); // calling the method
                break; // the break to case 3
            case 4:
                //OPTION 4 - Checkout
                System.out.print('\f'); // clears the screen
                System.out.println("Your JahCart consists of:"); // prints the String
                for (String outputItem : shoppingCart) {
                    // for loop to print each item
                    System.out.println("-   " + outputItem); // printing each item
                }
                if (shoppingCart.size() == 0) {
                    // just to make sure in the event if nothing is in the cart
                    System.out.println("Your shopping cart is empty! Therefore, there is no need to pay!");
                } else {
                    // if the cart has an item
                    System.out.println("The total price of your cart is " + price);
                    System.out.println("Enjoy express 2 day shipping to \'1044 Edgewood Rd, North Vancouver, BC V7R 1Y7\'");
                    System.out.println("Brought to you by the Vatougios-Post!");
                }
                System.out.println(); // blank line
                System.out.println("Have a nice day!"); // printing
                stay = false; // setting this boolean to false will end the loop
                break; // the break to case 4
            case 5:
                //Empty the list
                System.out.print('\f'); // clears the screen
                shoppingCart.clear(); // clears the cart
                System.out.println("JahCart Emptied!"); // shows the user the cart is cleared
                stay = true; // re running the do while loop by keeping this boolean true
                generateSpacing(); // calling the method
                break; // the break to case 5
            case 6:
                //Exit
                System.out.print('\f'); // clears the screen
                System.out.println("Thank you for visiting our digital shopping cart!"); // prints to the user
                stay = false; // setting this boolean to false will end the loop
                break; // the break to case 6
            default:
            // default for error control
                System.out.print('\f'); // clears the screen
                System.out.println("Sorry, your request was not between 1 and 6. Please enter a valid input."); // prints to user the error
                stay = true; // setting the loop to true so the user can retry
                generateSpacing(); // calling the method
            }
        prompt.close(); // closing the prompt scanner to prevent bugs
        } while(stay); // end of do while loop with the parameter stay
    } // end of main method
} // end of class
// end of program