/**
 * This class represents a CHECKING account with a 1% interest and a minimum balance of 1000  
 * 
 */
public class InterestChecking extends NoServiceChargeChecking
{
	final double INTEREST = 0.01;
	final double MIN_ACCOUNT_BALANCE = 1000.00;
	private double _minBalance;
	private double _interest;
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public InterestChecking(String acntNum, String owner, String id, double balance) 
	{
		super(acntNum, owner, id, balance);
		_interest = INTEREST;
		_minBalance = MIN_ACCOUNT_BALANCE;
	}
	
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public InterestChecking(String acntNum, String owner, String id, double balance, double interest, double minBalance) 
	{
		super(acntNum, owner, id, balance);
		_interest = interest;
		_minBalance = minBalance;
	}
	
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public InterestChecking(String acntNum, String owner, String id, double balance, double minBalance) 
	{
		super(acntNum, owner, id, balance, minBalance);
		_interest = INTEREST;
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
     * Get minimum balance for the account 
     *
     * @return	_minBalance the min balance of the account
     */
	public double getMinBalance()
	{
		return _minBalance;
	}
	
	
	/**
     * Set minimum balance for the account 
     *
     * @param	minBalance	 the min balance to be set
     */
	public void setMinBalance(double minBalance)
	{
		_minBalance = minBalance;
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
     */
	@Override
	public void accountMGMT() 
	{
		deposit(calcInterest());
		
	}
	
	
	/**
     * Overriding toString to better represent our need
     *
     * @return	String representation of the account's information
     */
	public String toString()
	{
		return ("This is a Checking account with an interest and a minimum balance\n" + super.toString() + "\nAccount Minimum Balance: " + _minBalance + "$" 
				+ "\nAccount Interest: " + _interest + "%");
	}
	
	
	/**
     * Overriding equals to compare two different accounts
     *
     * @return	String representation of the account's information
     */
	public boolean equals(InterestChecking other)
	{
		if (super.equals(other) && this._interest == other.getIntereste());
			return true;
	}
}
