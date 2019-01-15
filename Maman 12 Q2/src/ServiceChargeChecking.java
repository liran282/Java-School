/**
 * This class represents a CHECKING account with a monthly fee
 * 
 */


public class ServiceChargeChecking extends CheckingAccount
{
	final double MONTHLY_FEES = 4.0;
	private double _monthlyFees;
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     */
	public ServiceChargeChecking(String acntNum, String owner, String id, double balance) 
	{
		super(acntNum, owner, id, balance);
		_monthlyFees = MONTHLY_FEES;
	}
	
	
	/**
     * Constructor 
     *
     * @param	acntNum	the account number
     * @param	owner	the account owner
     * @param	id		the owner's ID
     * @param	balance	the account balance
     * @param	fees	the fees on the account
     */
	public ServiceChargeChecking(String acntNum, String owner, String id, double balance, double fees) 
	{
		super(acntNum, owner, id, balance);
		_monthlyFees = fees;
	}
	
	
	/**
     * Get fees 
     *
     * @return	the fees
     */
	public double getFees()
	{
		return _monthlyFees;
	}
	
	
	/**
     * Set fees 
     *
     * @param	the fees
     */
	public void setFees(double fees)
	{
		_monthlyFees = fees;
	}


	/**
     * Charging the account with the monthly fees
     *
     */
	@Override
	public void accountMGMT() 
	{
		try 
		{
			super.withdraw(_monthlyFees);
		} 
		
		catch (IllegalBalance e) 
		{
			System.out.println("\nERROR: Cannot withdraw fees. Balance is too low.\n");
		}
		
	}
	
	
	/**
     * Overriding toString to better represent our need
     *
     * @return	String representation of the account's information
     */
	public String toString()
	{
		return ("This is a Checking account with a monthly fee\n" + super.toString() + "\nAccount Fees: " + _monthlyFees +"$");
	}
	
	
	/**
     * Overriding equals to compare two different accounts
     *
     * @return	String representation of the account's information
     */
	public boolean equals(ServiceChargeChecking other)
	{
		if (super.equals(other) && this._monthlyFees == other.getFees());
			return true;
	}
	
}
