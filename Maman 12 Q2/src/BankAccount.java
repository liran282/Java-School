/**
 * This abstract class represents a bank account 
 * 
 */


public abstract class BankAccount 
{
	private String _accountNumber;
	private String _accountOwner;
	private String _ID;
	private double _accountBalance;
	
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public BankAccount(String acntNum, String owner, String id, double balance)
	{
		_accountNumber = acntNum;
		_accountOwner = owner;
		_ID = id;
		_accountBalance = balance;
	}
	
	/**
     * Get the account number 
     *
     * @return	_accountNumber	the account number
     */
	public String getAccountNumber()
	{
		return _accountNumber;
	}
	
	
	/**
     * Get the account owner 
     *
     * @return	_accountOwner	the account owner
     */
	public String getAccountOwner()
	{
		return _accountOwner;
	}
	
	
	/**
     * Get the ID 
     *
     * @return	_ID	the ID
     */
	public String getID()
	{
		return _ID;
	}
	
	
	/**
     * Get the account balance 
     *
     * @return	_accountBalance	the account balance
     */
	public double getAccountBalance()
	{
		return _accountBalance;
	}
	
	
	/**
     * Add to the account balance
     *
     * @param	amount		the amount to be added to the account's balance
     */
	public void deposit(double amount)
	{
		_accountBalance += amount;
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
			if (_accountBalance < amount)
				throw new IllegalBalance();
			else
				_accountBalance -= amount;
			
		}
		
		catch (IllegalBalance e)
		{
			System.out.println("Cannot withdraw, balance is too low.\n");
		}
	}
	
	
	/**
     * Abstract method that will be handled in child classes
     *
     */
	public abstract void accountMGMT();
	
	
	/**
     * Overriding toString to better represent our need
     *
     * @return	String representation of the account's information
     */
	public String toString()
	{
		return ("Account Number: " + _accountNumber
				+ "\nAccount Owner: " + _accountOwner
				+ "\nAccount Owner ID: " + _ID
				+ "\nAccount Balance: " + _accountBalance + "$");
	}
	
	
	/**
     * Overriding equals to compare two different accounts
     *
     * @return	String representation of the account's information
     */
	public boolean equals(BankAccount other)
	{
		if (this._accountNumber == other._accountNumber && this._accountOwner == other._accountOwner 
				&& this._ID == other._ID && this._accountBalance == other._accountBalance)
			return true;
		else
			return false;
	}
	
	
}
