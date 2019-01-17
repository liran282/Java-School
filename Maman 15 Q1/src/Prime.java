
public class Prime implements Runnable
{
	private int _num;
	private Controller _controller;
	
	
	/**
     * Constructor 
     * 
     *	
     */
	public Prime(int num, Controller cont)
	{
		_num = num;
		_controller = cont;
	}
	
	
	
	/**
     * Overrides run(), checks if a number is a prime number or not
     * 
     *	
     */
	public void run() 
	{
		int i = 2;
		
		while (i < _num)
		{
			if (_num % i == 0)
				break;
			
			i++;
		}
		
		if (i == _num) {
			_controller.getArray()[_num] = true;
		}
	}
	
	
	
}
