import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class test 
{
	public static void main(String[] args)
	{
		/*
		System.out.println("Item Name\t Quantity\t Price");
		
		LinkedList<String> test = new 	LinkedList<String>();
		test.add("A"); 
		test.add("B");
		test.add("C");
		test.add("D");
		test.add("E");
		//test.addLast("C"); 
		//test.addFirst("D"); 
		
		//System.out.println(test.getFirst());
		
		for(int i=0; i<test.size(); i++)
			System.out.println(test.get(i));
			
			
		*/
		
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
		
		
		
		//System.out.println(items);
		
		
		System.out.println(t3);
		System.out.println(t4);
	}
	
}
