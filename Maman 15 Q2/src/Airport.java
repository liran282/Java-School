import java.util.concurrent.locks.ReentrantLock;
import java.util.Date;
import java.util.concurrent.locks.Condition;

public class Airport 
{
	private String _airportName;
	private int _numOfRunways;
	private boolean[] _runways;
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition busy = lock.newCondition();
	private Date _date;
	
	 
	/**
     * Constructor - Creates a new airport
     * 
     * @param	name	the name of the airport
     * @param	routes	the number of runway in that airport
     */
	public Airport(String name, int runway)
	{
		_airportName = name;
		_numOfRunways = runway;
		
		_runways = new boolean[runway];
		
		for (int i = 0; i < _numOfRunways; i++)
		{
			_runways[i] = true;
		}
	}
	
	
	
	/**
     * Checks which runway is available for departure for a specific flight number
     * 
     * @param	flightNum	the flight number
     * @return	runwayNum	the available runway number for departure
     */
	public int depart(int flightNum)
	{
		lock.lock();
		System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
				+ "Flight Number: "+flightNum
				+ "\nAriport: "+ _airportName
				+ "\nStatus: Request for Departure \n\n");

		
		int availableRunway;
		
		while (availableRunway() == -1)
		{	
			System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
					+ "Flight Number: "+flightNum
					+ "\nStatus: BUSY. PLEASE HOLD \n\n");	
			try 
			{
				busy.await();
			} 
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		availableRunway = availableRunway();
		_runways[availableRunway] = false;
		System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
				+ "Flight Number: "+flightNum
				+ "\nAriport: "+ _airportName
				+ "\nRunway Number: "+ availableRunway
				+ "\nStatus: DEPARTURE GRANTED \n\n");	
		
		lock.unlock();
		return availableRunway;
	}
	
	
	/**
     * Checks which route is available for landing for a specific flight number
     * 
     * @param	flightNum	the flight number
     * @return	runwayNum	the available runway number for landing
     */
	public int land(int flightNum)
	{
		lock.lock();
		int availableRunway;
		System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
				+ "Flight number: "+flightNum
				+ "\nAriport: "+ _airportName
				+ "\nStatus: Request for Landing \n\n");		
		
		
		while (availableRunway() == -1)
		{	
			System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
					+ "Flight Number: "+flightNum
					+ "\nStatus: BUSY. PLEASE HOLD \n\n");	
			try 
			{
				busy.await();
			} 
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		availableRunway = availableRunway();
		_runways[availableRunway] = false;
		System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
				+ "Flight Number: "+flightNum
				+ "\nAriport: "+ _airportName
				+ "\nRunway Number: "+ availableRunway
				+ "\nStatus: LANDING GRANTED \n\n");	
		
		
		lock.unlock();
		return availableRunway;
	}
	
	
	/**
     * Releases a runway that was used for departing / landing
     * 
     * @param	flightNum	the flight number
     * @return	runwayNum	the available runway number for departure
     */
	public void freeRunway(int flightNum, int runwayNum)
	{
		lock.lock();
		System.out.println(getDate() +" (" + Thread.currentThread().getName() + ") \n"
				+ "Flight Number: "+flightNum
				+ "\nAriport: "+ _airportName
				+ "\nRunway Number: "+runwayNum
				+ "\nStatus: RUNWAY CLEAR \n\n");	
		
		_runways[runwayNum] = true;
		busy.signal();
		
		lock.unlock();
	}
	
	
	/**
     * Gets the next available runway
     * 
     * @return	the available runway or -1 if nothing is available
     */
	private int availableRunway()
	{	
		for (int i = 0; i < _runways.length; i++)
		{
			if (_runways[i] == true)
			{
				return i;
			}
		}

		return -1;
	}
	
	
	/**
     * Gets the current date and time
     * 
     * @return	_date	the current date and time
     */
	public Date getDate()
	{
		return _date = new Date();
	}
	
}
