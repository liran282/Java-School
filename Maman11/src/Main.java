import java.util.*;

public class Main 
{	
	public static void main(String[] args)
	{
		//Creating 10 items for our store
		Item t1 = new Item("Milk", 3.5);
		Item t2 = new Item("Bread", 4);
		Item t3 = new Item("Soda", 1.8);
		Item t4 = new Item("Water", 1);
		Item t5 = new Item("Sugar", 4.2);
		Item t6 = new Item("Salt", 2);
		Item t7 = new Item("Flour", 4);
		Item t8 = new Item("Oil", 6);
		Item t9 = new Item("Olive Oil", 8.5);
		Item t10 = new Item("Eggs", 2.3);
		
		//Mapping all items with a key
		Map<String, Item> items = new HashMap<String, Item>(); 
		items.put("1", t1);
		items.put("2", t2);
		items.put("3", t3);
		items.put("4", t4);
		items.put("5", t5);
		items.put("6", t6);
		items.put("7", t7);
		items.put("8", t8);
		items.put("9", t9);
		items.put("10", t10);

		//Creating a new Register object
		Register reg = new Register();
		
		//Flag to get us back to the main menu every time
		boolean flag = true;
		
		//Actual prompt to the user
		while (flag)
		{
			System.out.println ("\nWhich action would you like to perform? ");
			System.out.print ("1) Add Item \n2) Show Current Check \n3) Show Total \n4) Checkout \n5) Show Current Cash \n6) Quit \n");
			    
			Scanner scan = new Scanner (System.in);
			
			//The different cases
			switch (scan.nextInt()) 
		    {
		    	case 1://Add Item
		    		System.out.println ("Here's what we offer:\n");
		    		System.out.println (items);
		    		System.out.println ("\nPlease choose an item to be added");
		    		//scan
		    		String str = scan.nextLine();
		    		//copying the item using the input
		    		Item chosenItem = new Item(items.get(scan.nextLine()));
		    		
		    		System.out.println ("Please choose quantity");
		    		int quantity = scan.nextInt();
		    		
		    		//adding the item to the current check
		    		reg.addItem(chosenItem, quantity);
		    		
		    		System.out.println ("Item "+chosenItem + " has been added " + quantity + " time(s)");
		    		break;
		    		
		    	case 2://Show Current Check
		    		System.out.println ("The current items in your shopping cart are: ");
		    		System.out.println (reg.toString());
		    		break;
		    		
		    	case 3://Show Total
		    		System.out.println ("Your current total is: "+ reg.getTotalCheck() + "$");
		    		break;
	
		    	case 4://Checkout
		    		System.out.println ("Checking out...");
		    		System.out.println ("How much money has been received from the customer?");
		    		reg.receivePayment(scan.nextDouble());
		    		break;
		    		
		    	case 5://Show Current Cash
		    		System.out.println ("The register currently has " + reg._cash + "$");
		    		break;
		    		
		    	case 6://Quit
		    		System.out.println ("Thank you and godbye!");
		    		flag = false; //to end completely 
		    		break;
		    		
		    	default:
		    		System.err.println ("Unrecognized option");
		    		break;
		    }
		}
		    
	}
	
	
	
}
