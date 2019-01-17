import java.util.Date;
import java.util.Random;

public class Flight extends Thread
{
	private int _flightNum;
	private Airport _airportToDepart;
	private Airport _airportToLand;
	//private Date _date = new Date();
	private Date _date;
	private Random rand = new Random();
	
	public Flight(int flightNum, Airport airportToDepart, Airport airportToLand)
	{
		_flightNum = flightNum;
		_airportToDepart = airportToDepart;
		_airportToLand = airportToLand;
	}
	
	
	public void run()
	{
		//Departing
		int departingRunway = _airportToDepart.depart(_flightNum);
		
		try 
		{
			sleep(rand.nextInt(5000)+2000);			
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Error!");
			e.printStackTrace();
		}
		System.out.println(getDate() +"\nFlight number " +_flightNum + " DEPARTED SUCCESSFULY! \n");
		
		
		//Freeing runway
		_airportToDepart.freeRunway(_flightNum, departingRunway);
		try 
		{
			sleep(rand.nextInt(7000)+3000);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Error!");
			e.printStackTrace();
		}
		
		//Landing 
		int landingRunway = _airportToLand.land(_flightNum);
		try 
		{
			sleep(rand.nextInt(5000)+2000);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Error!");
			e.printStackTrace();
		}
		
		System.out.println(getDate() +"\nFlight number " +_flightNum + " LANDED SUCCESSFULY! \n");

		
		//Freeing runway
		_airportToLand.freeRunway(_flightNum, landingRunway);
	}
	
	
	/**
     * Gets the current date and time
     * 
     * @return	_date	the current date and time
     */
	private Date getDate()
	{
		return _date = new Date();
	}
}
