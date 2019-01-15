/**
 * This class represents a SAVINGS account with the highest interest of 4%, and highest minimum balance of 2000
 * 
 */

public class HighInterestSavings extends SavingsAccount
{
	final double INTEREST = 0.04;
	final double MIN_ACCOUNT_BALANCE = 2000.00;
	private double _interest;
	private double _minBalance;
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public HighInterestSavings(String acntNum, String owner, String id, double balance) 
	{
		super(acntNum, owner, id, balance);
		_interest = INTEREST;
		_minBalance = MIN_ACCOUNT_BALANCE;
	}
	
	
	/**
     * Constructor 
     *
     * @param	acntNum		the account number
     * @param	owner		the account owner
     * @param	id			the owner's ID
     * @param	balance		the account balance
     * @param	interest	the interest applied for the account
     * @param	minBalance	the minimum balance the account needs to have
     */
	public HighInterestSavings(String acntNum, String owner, String id, double balance, double interest, double minBalance) 
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
	public HighInterestSavings(String acntNum, String owner, String id, double balance, double interest) 
	{
		super(acntNum, owner, id, balance, interest);
		_minBalance = MIN_ACCOUNT_BALANCE;
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
     * @param	interest	 the interest to be set
     */
	@Override
	public void accountMGMT() 
	{
		this.deposit(this.getAccountBalance() *(1 + _interest));
		
	}
	
	
	/**
     * Withdraw from the account balance and throw an exception if balance is too low
     *
     * @param	amount		the amount to be withdrawn from the account's balance
	 * @throws IllegalBalance 
     */
	public void withdraw(double amount) throws IllegalBalance
	{
		try 
		{
			if (_minBalance < amount)
				throw new IllegalBalance();
			else
				super.withdraw(amount);
		}
		
		catch (IllegalBalance e) 
		{
			System.out.println("\nERROR: Cannot withdraw amount. Minimum balance has to be " + _minBalance + "\n");
		}
	}
	
	
	/**
     * Overriding toString to better represent our need
     *
     * @return	String representation of the account's information
     */
	public String toString()
	{
		return ("This is a Savings account with a high interest and a high minimum balance\n" + super.toString() + "\nAccount Minimum Balance: " + _minBalance + "$"
				+ "\nAccount Interest: " + _interest + "%");
	}
	
	
	/**
     * Overriding equals to compare two different accounts
     *
     * @return	String representation of the account's information
     */
	public boolean equals(HighInterestSavings other)
	{
		if (super.equals(other) && this._minBalance == other.getMinBalance());
			return true;
	}
}
