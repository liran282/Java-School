import java.util.Scanner;
import java.util.*;

public class Main 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		GenericList<String> list = new GenericList<String>();
		System.out.println("A brand new, empty linked-list was created just for you!\n");
		System.out.println("Please enter 6 numbers you would like to add to your list");
		
		int numOfElements = 6;
		
		while (numOfElements > 0)
		{
			String input = sc.nextLine();
			
			list.addElement(input);
			System.out.printf("%s was added to the linked list. You have %d more numbers to enter\n",
					input, numOfElements-1);
			numOfElements--;
		}
		
		
		System.out.println("\n\nHere's your list: \n"+ list);
		
		//========================================================
		
		/** now let's print this bad boy backwards
		 * 
		 * i only did it this way and not with a normal method because Tamar wrote in the forum
		 * that we should stick to the script and not create new methods. 
		 */
		GenericList<String> tsil = new GenericList<String>();
		tsil.addElement(list.getTail().getContent());
		tsil.addElement(list.getHead().getNext().getNext().getNext().getNext().getContent());
		tsil.addElement(list.getHead().getNext().getNext().getNext().getContent());
		tsil.addElement(list.getHead().getNext().getNext().getContent());
		tsil.addElement(list.getHead().getNext().getContent());
		tsil.addElement(list.getHead().getContent());
		
		System.out.println("\n\nHere's your list backwards: \n"+ tsil);
		
		//========================================================
		
				
		//Testing max on a linked list of ints
		GenericList<Integer> intList = new GenericList<Integer>();

		intList.addElement(100);
		intList.addElement(23);
		intList.addElement(14);
		intList.addElement(832);
		intList.addElement(63);
		intList.addElement(2);
		
		System.out.println("\n\nHere's your list of Integers: \n"+ intList);
		System.out.println("\nThe max int is: \n"+ max(intList));

		
		
		//========================================================
		GenericList<Person> people = new GenericList<Person>();
		
		Person dani = new Person("Dani", "123456", 1988);
		Person moshe = new Person("Moshe", "98723", 1970);
		Person eli = new Person("Eli", "12386", 1932);
		Person tsvika = new Person("Tsvika", "41289", 1994);
		
		people.addElement(dani);
		people.addElement(moshe);
		people.addElement(eli);
		people.addElement(tsvika);
		
		System.out.println("\n\nHere's your list of people: \n"+ people);
		
		
		System.out.println("\n\nThe oldest person is: \n"+ max(people));

	}
	
	
	public static <T extends Comparable<T>> T max(GenericList<T> list)
	{
		GenericElement<T> p = list.getHead();
		GenericElement<T> max = list.getHead();
		
		while (p != null)
		{
			if(max.getContent().compareTo(p.getContent()) < 0)
			{
				max = p;
			}
			p = p.getNext();
			
		}
		
		return max.getContent();
	}
	
}
