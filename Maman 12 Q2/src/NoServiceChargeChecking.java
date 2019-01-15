/**
 * This class represents a CHECKING account without a monthly fee and with a minimum balance of 500 
 * 
 */

public class NoServiceChargeChecking extends CheckingAccount 
{
	final double MIN_ACCOUNT_BALANCE = 500.00;
	private double _minBalance;
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public NoServiceChargeChecking(String acntNum, String owner, String id, double balance) 
	{
		super(acntNum, owner, id, balance);
		_minBalance = MIN_ACCOUNT_BALANCE;
	}
	
	
	/**
     * Constructor 
     *
     * @param	acntNum		the account number
     * @param	owner		the account owner
     * @param	id			the owner's ID
     * @param	balance		the account balance
     * @param	minBalance	the min balance on the account
     */
	public NoServiceChargeChecking(String acntNum, String owner, String id, double balance, double minBalance) 
	{
		super(acntNum, owner, id, balance);
		_minBalance = minBalance;
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


	@Override
	public void accountMGMT() 
	{
		// TODO Auto-generated method stub
		
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
			System.out.println("\nERROR: Cannot withdraw amount. Minimum balance has to be " + _minBalance +"\n");
		}
	}
	
	
	/**
     * Overriding toString to better represent our need
     *
     * @return	String representation of the account's information
     */
	public String toString()
	{
		return ("This is a Checking account with a minimum balance\n" + super.toString() + "\nAccount Minimum Balance: " + _minBalance + "$");
	}
	
	
	/**
     * Overriding equals to compare two different accounts
     *
     * @return	String representation of the account's information
     */
	public boolean equals(NoServiceChargeChecking other)
	{
		if (super.equals(other) && this._minBalance == other.getMinBalance());
			return true;
	}

}
