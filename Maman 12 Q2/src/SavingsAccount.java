/**
 * This class represents a SAVINGS account with interest of 2%
 * 
 */

public class SavingsAccount extends BankAccount
{
	final double INTEREST = 0.02;
	private double _interest;
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public SavingsAccount(String acntNum, String owner, String id, double balance) 
	{
		super(acntNum, owner, id, balance);
		_interest = INTEREST;
	}
	
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public SavingsAccount(String acntNum, String owner, String id, double balance, double interest) 
	{
		super(acntNum, owner, id, balance);
		_interest = interest;
	}
	
	
	/**
     * Get interest for the account 
     *
     * @return	_interest the interest of the account
     */
	public double getIntereste()
	{
		return _interest;
	}
	
	
	/**
     * Set the interest for the account
     *
     * @param	interest	 the interest to be set
     */
	public void setIntereste(double interest)
	{
		_interest = interest;
	}
	
	
	/**
     * Calculate the interest
     *
     * @return	the interest earned for the current account balance 
     */
	public double calcInterest()
	{
		return this.getAccountBalance() * _interest;
	}
	
	
	/**
     * deposit the interest amount into the account
     *
     * @param	interest	 the interest to be set
     */
	@Override
	public void accountMGMT() 
	{
		this.deposit(this.getAccountBalance() *(1 + _interest));
		
	}
	
	
	/**
     * Overriding toString to better represent our need
     *
     * @return	String representation of the account's information
     */
	public String toString()
	{
		return ("This is a Savings account with an interest\n" + super.toString() + "\nAccount Interest: " + _interest + "%");
	}
	
	
	/**
     * Overriding equals to compare two different accounts
     *
     * @return	String representation of the account's information
     */
	public boolean equals(SavingsAccount other)
	{
		if (super.equals(other) && this._interest == other.getIntereste());
			return true;
	}
}
