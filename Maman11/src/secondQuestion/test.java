package secondQuestion;

public class test 
{
	public static void main(String [] args)
	{
		double [] mekadmim1 = new double[2];
		int [] powers1 = new int [2];
		
		mekadmim1[0] = 2.0;
		mekadmim1[1] = 1.0;
		//mekadmim1[2] = 8.0;
		//mekadmim1[3] = 4.0;
		
		powers1[0] = 4;
		powers1[1] = 3;
		//powers1[2] = 0;
		//powers1[3] = 3;
		
		
		Polynom poly1 = new Polynom(mekadmim1, powers1);
		System.out.println(poly1);
		
		//System.out.println(poly1.cutPoly());
		//=================================================
		
		double [] mekadmim2 = new double[3];
		int [] powers2 = new int [3];
		
		mekadmim2[0] = 5.0;
		mekadmim2[1] = 2.0;
		mekadmim2[2] = 2.0;
		//mekadmim2[3] = -4.0;
		
		powers2[0] = 4;
		powers2[1] = 3;
		powers2[2] = 2;
		//powers2[3] = 4;
		
		
		Polynom poly2 = new Polynom(mekadmim2, powers2);
		System.out.println(poly2);
		//System.out.println(poly1.compareTo(poly2));
		System.out.println("minus is: " + poly1.minus(poly2));
		System.out.println("plus is: " + poly1.plus(poly2));
		
	}
}
