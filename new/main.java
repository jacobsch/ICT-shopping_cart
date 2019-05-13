import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
 
public class main {
 
    /**
     * In this program you will replicate an online shopping
     * cart. You will use the ArrayList class to hold the
     * items in your shopping cart.
     * You will use the CartItem class to represent items in
     * your shopping cart.
     * In this driver program you will do the following:
     * Create the shopping cart object
     * Offer a menu of options:
     * 1 add an item to your cart
     * 2 remove an item from your cart
     * 3 view the items in your cart
     * 4 end shopping and go to checkout
     * 5 empty your cart
     * 6 exit the program
     * Use the Scanner class to collect input
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<CartItem> shoppingCart = new ArrayList<CartItem>();
        boolean stay = true;
        int choice = 0;
        int input = 0;
        int index=0;
        int total = 0;
        Integer item;
 
        while(stay)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nJahCart Menu");
            System.out.println("1 Add an item to your JahCart");
            System.out.println("2 Remove an item from your JahCart");
            System.out.println("3 View the items in your JahCart");
            System.out.println("4 Exit and add up the total");
            System.out.println("5 Empty your JahCart");
            System.out.println("6 Exit");
            System.out.println("Select a menu option");
            choice = scan.nextInt();
            scan.close();

            if (choice <1 || choice >6)
            {
                System.out.println("Enter a value between 1 and 6:");
            }
            else
            {
                Scanner prompt = new Scanner(System.in);
                switch (choice)
                {
                case 1:
                    //add an integer
                    System.out.println("Enter an item:");
                    input = prompt.nextLine();
                    item = new String(input);
                    shoppingCart.add(item);
                    //intList.add(input);
                    break;
                case 2:
                    //remove from the list
                    System.out.println("Enter an item to remove:");
                    input = prompt.nextLine();
                    item = new String(input);
                    if (shoppingCart.contains(item))
                    {
                        shoppingCart.remove(item);
                        System.out.println(item + " has been removed.");
                    }
                    else
                    {
                        System.out.println(item + " was not found in your shopping JahCart.");
                    }
                    break;
                case 3:
                    //view the items in your cart
                    System.out.println(shoppingCart);
                    break;
                case 4:
                    //Exit and add up the total
                    // for (int i = 0; i<shoppingCart.size(); i++)
                    // {
                    //     item = shoppingCart.get(i);
                    //     total = total + item.intValue();
                    // }
                    // System.out.println("Total is "+ total);
                    System.out.println("Goodbye");
                    stay = false;
                    break;
                case 5:
                    //Empty the list
                    shoppingCart.clear();
                    break;
                case 6:
                    //exit
                    stay = false;
                    System.out.println("Goodbye");
                    break;
 
                }
            }
        }
    }
}