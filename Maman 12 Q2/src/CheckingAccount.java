/**
 * This abstract class represents a CHECKING account that allows writing checks 
 * 
 */
public abstract class CheckingAccount extends BankAccount
{
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public CheckingAccount(String acntNum, String owner, String id, double balance) 
	{
		super(acntNum, owner, id, balance);
	}

	
	/**
     * Writing a check if the balance is not too low, and if it is too low, throw an error  
     *
     * @param	amount	the amount to be sent
     */
	public void writeCheck(double amount) throws IllegalBalance
	{
		withdraw(amount);
	}
	
	
}
