import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Controller 
{
	private int _maxNumOfThreads;
	private boolean[] _array;
	private ExecutorService pool;
	private int _num;
	private int _current = 0;
	
	
	/**
     * Constructor - Creates a new controller
     * 
     *	
     */
	public Controller(int threads, int num)
	{
		_maxNumOfThreads = threads;
		_num = num;
		_array = new boolean[num];
		
		pool = Executors.newFixedThreadPool(_maxNumOfThreads);
	}
	
	
	/**
     * Creates threads that checks whether or not a number is a prime number
     * 
     *	
     */
	public void isPrime()
	{
		while (_current < _num)
		{
			for (int i = 1; i < _maxNumOfThreads; i++)
			{
				pool.execute(new Prime(giveMeANum(), this));
			}
			
			
		}
		pool.shutdown();
	}
	

	
	public synchronized int giveMeANum()
	{
		_current++;
		return _current-1;
	}
	
	
	/**
     * Gets the array from the controller object
     * 
     * @return	_array	the array
     */
	public boolean[] getArray()
	{
		return _array;
	}
	
	
	/**
     * Gets the number from the controller object
     * 
     * @return	_num	the num
     */
	public int getNum()
	{
		return _maxNumOfThreads;
		//return _num;
	}
	
	
	/**
     * Overriding toString 
     * 
     * @return	str	a string of the prime numbers
     */
	public String toString()
	{		
		try 
		{
			pool.awaitTermination(500, TimeUnit.MILLISECONDS);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		String str = "";
		int cntr = 0;
		for (int i = 0; i < _array.length; i++)
		{
			if (_array[i] == true)
			{
				str += " " + (i);
				cntr++;
			}
			if (cntr == 10)
			{
				str += "\n";
				cntr = 0;
			}
		}
		
		return str;
	}
}
