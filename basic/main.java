// Pin Validator Java Semi Final Project

// Jah
import java.awt.*; // Everything needed
import javax.swing.*; // GUI
import java.awt.event.*; // Making buttons and more work
import java.awt.image.BufferedImage; // Allow images to work
import javax.imageio.ImageIO; // Allow images to work
import java.io.*; // Allow external sources
import java.io.File; // Allow external files
import javax.swing.JOptionPane; // Giving us more control with our Panels
import java.io.FileInputStream; // Allow files to work in program
import java.io.InputStream; // Allow files to work in program

// Start of Panel3
public class Panel3 extends JPanel {

    private JPanel container; // Adding the container locally so it does not interfere with the other panel files
    private Panel3 accepted; // Adding the container locally so it does not interfere with the other panel files
    private JButton toLogin; // Adding the container locally so it does not interfere with the other panel files
    private JButton btnQuit; // Adding the container locally so it does not interfere with the other panel files

    JLabel lblTitle; // Init this label to the program
    JLabel lblName1; // Init this label to the program
    JLabel lblName2; // Init this label to the program
    JLabel lblLine; // Init this label to the program
    JLabel lblpg; // Init this label to the program
	JComboBox comboxItems;
	JLabel lblItems;
	JButton btnAdd;
	JButton btnRemove;

    public Panel3(JPanel c) {

        accepted = this; // from Panel2 (line 21)

        container = c;
        this.setLayout(null); // Setting the layout to null
		ArrayList<String> itemList = new ArrayList<String>();
		getItems(itemList);
        initComponents(); // Running the method which is summoning our components to be rendered in the window

        toLogin = new JButton("Logout"); // Adding a button
        toLogin.setBounds (300, 365, 135, 25); // Adding boundaries to the button
        this.add(toLogin); // Adding actions to the button
        this.setBackground(Color.GREEN); // Changing background colour when button pressed
        toLogin.addActionListener( new ActionListener() {
            // action when btn clicked
            public void actionPerformed(ActionEvent e) {
                
                c.remove(accepted);
                revalidate();
                repaint();
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "Login");
                
            } // end of actionPerformed
        }); // end of toLogin btn

    } // End of Panel3

    public void initComponents() {
		
        //construct components
        lblTitle = new JLabel ("Shopping Cart"); // Giving value to our labels
        lblName1 = new JLabel ("By Owen Holman"); // Giving value to our labels
        lblName2 = new JLabel ("and Jacob Schwartz"); // Giving value to our labels
        lblLine = new JLabel ("-------------------------------"); // Giving value to our labels
        lblpg = new JLabel ("Account Page"); // Giving value to our labels
		
		// new items to be positioned:
		comboxItems = new JComboBox(itemList);
		
        
        //set component bounds (only needed by Absolute Positioning)
        lblTitle.setBounds (330, 15, 80, 25); // Giving boundaries to our tags
        lblName1.setBounds (315, 45, 120, 25); // Giving boundaries to our tags
        lblName2.setBounds (307, 60, 125, 25); // Giving boundaries to our tags
        lblLine.setBounds (300, 30, 125, 25); // Giving boundaries to our tags

        //add components
        add (lblTitle); //adding components to the window
        add (lblName1); //adding components to the window
        add (lblName2); //adding components to the window
        add (lblLine); //adding components to the window
        add (lblpg); //adding components to the window

        //Adding quit functionality and quit button to the program
        btnQuit = new JButton("Quit"); // Giving value to the button
        btnQuit.setBounds(300, 400, 135, 25); // Giving placement properties to the button
        add(btnQuit); // Adding the button to the window
        btnQuit.addActionListener( new ActionListener() {
            //Action that happens when you press quit (it quits)
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Once clicked, program is quit
            } // end of actionPerformed quit

        }); // end of btnQuit
    } // end of initComponents
	
	public void getItems(ArrayList<String> items) {
		try {
			JSONObject inputFile = (JSONObject) readJSON("products-list.json"); // init .json object of our file, basically bringing the file into our code
			JsonObject jsonObject = (JsonObject)new JsonParser().parse(inputFile);
			JsonArray groupedObject = jsonObject.getAsJsonArray("group");
			int countItem=0;
			for(int i=0;i < groupedObject.size();i++) {
				JsonObject items = ((JsonObject)groupedObject.get(i)).getAsJsonObject("item");
				countItem+=items.size();
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}

// end of file




import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
 
public class main {
 
    /**
     * Jacob Schwartz and Owen Holman Semifinal Project for ICT12
     */
    public static void main(String[] args) {
        // Initalize most datatypes
        ArrayList<String> shoppingCart = new ArrayList<String>();
        boolean stay = true;
        int choice = 0;
        String input;
        int index=0;
        int total = 0;
        String item;
        int size;
        String lines = "|------------------------------------|";

        Random randomNumb = new Random();

        int price = randomNumb.nextInt(1000);
        price = price += 1;
        String stringPrice = Integer.toString(price);
        String finalPrice = "$"+stringPrice+".99";

        while(stay)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println(lines);
            System.out.println("|            JahCart menu            |");
            System.out.println(lines);
            System.out.println("|1 Add an item to your JahCart       |");
            System.out.println("|2 Remove an item from your JahCart  |");
            System.out.println("|3 View the items in your JahCart    |");
            System.out.println("|4 View items, add Total and Checkout|");
            System.out.println("|5 Empty your JahCart                |");
            System.out.println("|6               Exit                |");
            System.out.println(lines);
            System.out.println("|        Select a menu option        |");
            System.out.println(lines);
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
                    // OPTION 1 - Add an Item
                    System.out.print('\f');
                    System.out.println("Enter an item:");
                    input = prompt.nextLine();
                    item = new String(input);
                    shoppingCart.add(item);
                    //intList.add(input);
                    break;
                case 2:
                    //OPTION 2 - Remove an Item
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
                    //OPTION 3 - View Items
                    System.out.print('\f');
                    size=shoppingCart.size();
                    if (size == 0) {
                        System.out.println("Your JahCart is Empty");
                    } else {
                        System.out.println("Your JahCart consists of:");
                        System.out.println(shoppingCart);
                        System.out.println("and costs a total of " + finalPrice);
                    }
                    break;
                case 4:
                    //OPTION 4 - Checkout
                    System.out.print('\f');
                    System.out.println("Your JahCart consists of:");
                    System.out.println(shoppingCart);
                    System.out.println("and costs a total of " + finalPrice);
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
                    break;
                case 6:
                    //Exit
                    System.out.print('\f');
                    System.out.println("Goodbye");
                    stay = false;
                    break;
 
                }
            prompt.close();
            }
        }
    }
}