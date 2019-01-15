package secondQuestion;

import java.util.Scanner;

public class Main 
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner (System.in);
		System.out.println("How many numbers would you like to have in your first polynom?");
		
		//scan
		int poly1length = scan.nextInt();

		//declare arrays for the 1st polynom
		double [] mekadmim1 = new double[poly1length];
		int [] powers1 = new int [poly1length];
		
		
		int p1 = poly1length;
		for (int i=0; i<poly1length; i++)
		{
			
			System.out.println("Please Insert the numbers for the FIRST polynom in the form of <mekadem power>, without the <> and click enter.\n The mekadem can be a double but the power has to be an int. You have " + p1 + " more numbers to insert");
			
			mekadmim1[i] = scan.nextDouble();
			powers1[i] = scan.nextInt();
			p1--;
			
		}
		//creating the first polynom
		Polynom poly1 = new Polynom(mekadmim1, powers1);

		System.out.println("\n\nHow many numbers would you like to have in your second polynom?");
		
		//scan
		int poly2length = scan.nextInt();

		//declare arrays for the 1st polynom
		double [] mekadmim2 = new double[poly2length];
		int [] powers2 = new int [poly2length];
		
		
		int p2 = poly2length;
		for (int i=0; i<poly2length; i++)
		{
			
			System.out.println("Please Insert the numbers for the SECOND polynom in the form of <mekadem power>, without the <> and click enter.\n The mekadem can be a double but the power has to be an int. You have " + p2 + " more numbers to insert");
			
			mekadmim2[i] = scan.nextDouble();
			powers2[i] = scan.nextInt();
			p2--;
			
		}
		//creating the second polynom
		Polynom poly2 = new Polynom(mekadmim2, powers2);
		
		//printing
		System.out.println("\n This is your first polynom:");
		System.out.println(poly1);
		System.out.println("\n This is your second polynom:");
		System.out.println(poly2);
		
		
		
		
		
		//Flag to get us back to the main menu every time
		boolean flag = true;
		
		//Actual prompt to the user
		while (flag)
		{
			System.out.println ("\nWhich action would you like to perform? ");
			System.out.print ("1) poly1 + poly2 \n2) poly1 - poly2 \n3) Cut Polies\n4) Compare poly2 to poly1 \n5) Quit \n");
			    
			
			//The different cases
			switch (scan.nextInt()) 
		    {
		    	case 1://poly1 + poly2
		    		System.out.println ("First polynom plus the second one is:");
		    		System.out.println (poly1.plus(poly2));
		    		break;
		    		
		    	case 2://poly1 - poly2
		    		System.out.println ("First polynom minus the second one is:");
		    		System.out.println (poly1.minus(poly2));
		    		break;
		    		
		    	case 3://Cut Polies
		    		System.out.println ("Cutting the first poly results in:");
		    		System.out.println (poly1.cutPoly());
		    		System.out.println ("Cutting the first poly results in:");
		    		System.out.println (poly2.cutPoly());
		    		break;
	
		    	case 4://Compare poly2 to poly1
		    		System.out.println ("Comparying polynom2 with polynom1");
		    		System.out.println ("0 = Polynoms are equal | 1 = Poly1 is bigger | -1 = Poly2 is bigger");
		    		System.out.println("\nEnd the result is... " + poly1.compareTo(poly2));
		    		break;
		    				    		
		    	case 5://Quit
		    		System.out.println ("Thank you and godbye!");
		    		flag = false; //to end completely 
		    		break;
		    		
		    	default:
		    		System.err.println ("Unrecognized option");
		    		break;
		    }
		}
	}
}
