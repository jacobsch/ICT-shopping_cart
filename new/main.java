import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
 
public class main {
 
    /**

     */
    public static void main(String[] args) {
        ArrayList<String> shoppingCart = new ArrayList<String>();
        boolean stay = true;
        int choice = 0;
        String input;
        int index=0;
        int total = 0;
        String item;

        Random randomNumb = new Random();

        int price = randomNumb.nextInt(1000);
        price = price += 1;
        String stringPrice = Integer.toString(price);
        String finalPrice = "$"+stringPrice+".99";

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
                    System.out.print('\f');
                    System.out.println("Enter an item:");
                    input = prompt.nextLine();
                    item = new String(input);
                    shoppingCart.add(item);
                    //intList.add(input);
                    break;
                case 2:
                    //remove from the list
                    System.out.print('\f');
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
                    System.out.print('\f');
                    System.out.println(shoppingCart);
                    System.out.println(finalPrice);
                    break;
                case 4:
                    System.out.print('\f');
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
                    System.out.print('\f');
                    shoppingCart.clear();
                    stay = true;
                    break;
                case 6:
                    //exit
                    stay = false;
                    System.out.println("Goodbye");
                    break;
 
                }
            prompt.close();
            }
        }
    }
}