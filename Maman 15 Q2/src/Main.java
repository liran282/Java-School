import java.util.Random;

public class Main 
{
	private static Airport[] _airports = new Airport[2];
	private static Random _rand = new Random();

	
	public static void main (String[] args)
	{		
		_airports[0] = new Airport("SFO", 3);
		_airports[1] = new Airport("AMS", 3);

		
		
		Flight f1 = new Flight(1111, airport(), airport());
		f1.start();
		
		Flight f2 = new Flight(2222, airport(), airport());
		f2.start();
		
		Flight f3 = new Flight(3333, airport(), airport());
		f3.start();
		
		Flight f4 = new Flight(4444, airport(), airport());
		f4.start();
		
		Flight f5 = new Flight(5555, airport(), airport());
		f5.start();
		
		Flight f6 = new Flight(6666, airport(), airport());
		f6.start();
		
		Flight f7 = new Flight(7777, airport(), airport());
		f7.start();
		
		Flight f8 = new Flight(8888, airport(), airport());
		f8.start();
		
		Flight f9 = new Flight(9999, airport(), airport());
		f9.start();
		
		Flight f10 = new Flight(1010, airport(), airport());
		f10.start();
	}
	
	private static Airport airport()
	{
		return _rand.nextDouble() < 0.5 ? _airports[0] : _airports[1];
	}
	
}
