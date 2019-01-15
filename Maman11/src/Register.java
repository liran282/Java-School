import java.util.*;
public class Register 
{
	double _cash;
	LinkedList<LineInCheck> check;
	
	/**
     * Empty Constructor
     * Zeroes out the register and starts a new check
     */
	public Register()
	{
		_cash = 0;
		check = new LinkedList<LineInCheck>();
	}
	
	/**
     * Register Constructor
     * 
     *@param	cash 	how much cash is in the cashier when we start 
     */
	public Register(double cash)
	{
		_cash = cash;
		check = new LinkedList<LineInCheck>();
	}
	
	/**
     * Adds an item to the current check
     *
     * @param	item		the item to be added
     * @param	quantity	how many times should it be added
     */
	public void addItem(Item item, int quantity)
	{

		LineInCheck line = new LineInCheck(item, quantity);
		check.add(line);
	}
	
	/**
     * toString presentation of the register
     *
     */
	public String toString()
	{
		System.out.println("Item Name\t Quantity\t Total Price");
		for (int i=0; i<check.size(); i++)
			System.out.println((check.get(i).getItem().getItemName()) +"\t   \t   " + (check.get(i).getQuantity()) +"\t\t    " + (check.get(i).getTotal())); 
		return "";
	}
	
	/**
     * Prints the total check by going through each element and getting it's total price
     *
     *@return	total	the total of the check
     */
	public double getTotalCheck()
	{
		double total = 0.0;
		for (int i=0; i<check.size(); i++)
			total += check.get(i).getTotal();
		return total;

	}
	
	/**
     * Updates the cash reserve, calculating the change, clears the check 
     *
     * @param	payment		the amount received from the customer
     * @return	change		the change for the customer / how much money the customer owes
     */
	public double receivePayment(double payment)
	{
		double change = 0;
		
		_cash += getTotalCheck(); //update the register's cash
		change = payment - getTotalCheck() ; //calculate the change
		if (payment < getTotalCheck())
			System.out.println("The customer owes " + change + " more dollars");
		else
			System.out.println("The customer's change is " + change + "$");
				
		check.clear(); //clear the current sale
		return change; //return the customer their cash
	}
}
