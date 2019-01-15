package secondQuestion;

import java.util.*;

public class Polynom implements Comparable<Polynom>
{
	private ArrayList<Element> _poly;
	
	/**
	 * Polynom constructor (empty) initializes an arrayList
	 *
	 */
	public Polynom()
	{
		_poly = new ArrayList<Element>();
	}
	
	/**
     * Polynom constructor
     *
     * @param	mekadmim	an array of mekadmin
     * @param	powers		an array of powers
     */
	public Polynom(double [] mekadmim, int [] powers)
	{
		//declare the array
		_poly = new ArrayList<Element>();
		
		//copy both input arrays to the arraylist
		for (int i=0; i<mekadmim.length; i++)
			_poly.add(new Element(mekadmim[i], powers[i]));
		
		//sort the arrayList
		_poly.sort(Comparator.comparing(Element::getPower));
		Collections.sort(_poly, new compare());
		
	}
	
	/**
     * Getter
     *
     * @return	_poly	an arrayList representing a polynom
     */
	public ArrayList<Element> getPolynom()
	{
		return _poly;
	}
	
	/**
     * Overring toString to represent the polynom in the traditional way
     *
     * @return	str		in the following form: 1.0x^2 + 3.0x^2 + 4.0x 
     */
	public String toString() 
	{
		String str = "";
		for(int i=0; i<_poly.size();i++) {
			if(_poly.get(i).getMekadem() > 0 && i > 0)
				str += "+ ";
			if(_poly.get(i).getPower()==1)
				str += _poly.get(i).getMekadem()+"x ";
			else if(_poly.get(i).getPower()==0)
				str += (double)_poly.get(i).getMekadem()+" ";
				else
					str+= _poly.get(i).getMekadem()+"x^"+_poly.get(i).getPower()+" ";
		}
		return str;
	}
	
	/**
     * Adds the polynom received as a parameter to the polynom it runs on 
     *
     * @param	other	another polynom
     * @return	newPoly	a new polynom with the combined 2 polynoms
     */
	public Polynom plus(Polynom other)
	{
		Polynom newPoly = new Polynom();
		int i = 0; //index for the poly we run on
		int j = 0; //index for the poly received as a parameter 
		
		while (i < _poly.size() || j < other.getPolynom().size())
		{
			//if i reached the end of the arrayList
			if (i == _poly.size())
			{
				newPoly.getPolynom().add(other.getPolynom().get(j));
				j++;
			}
			
			//if j reached the end of the arrayList
			else if (j == other.getPolynom().size())
			{
				newPoly.getPolynom().add(_poly.get(i));
				i++;
			}
			
			//if the power of poly received as parameter smaller copy it to the new newPoly and move i
			else if (_poly.get(i).getPower() > other.getPolynom().get(j).getPower())
			{
				newPoly.getPolynom().add(new Element(_poly.get(i)));
				i++;
			}
			
			//if the plynom's power is equal
			else if (_poly.get(i).getPower() == other.getPolynom().get(j).getPower())
			{
				double sum = (_poly.get(i).getMekadem()+other.getPolynom().get(j).getMekadem());
				
				//if the sum is 0 we won't add it to newPoly
				if (sum == 0)
				{
					i++;
					j++;
				}
				else 
				{
					newPoly.getPolynom().add(new Element(sum, _poly.get(i).getPower()));
					i++;
					j++;
				}
			}
			
			//if the power of poly received as parameter bigger copy it to the newPoly move j
			else if (_poly.get(i).getPower() < other.getPolynom().get(j).getPower())
			{
				newPoly.getPolynom().add(new Element(other.getPolynom().get(j)));
				j++;
			}
		}
			return newPoly;
	}
	
	/**
     * Subtracts the polynom received as a parameter to the polynom it runs on 
     *
     * @param	other	another polynom
     * @return	newPoly	a new polynom after the manipulation
     */
	public Polynom minus(Polynom other)
	{
		Polynom newPoly = new Polynom();
		int i = 0;
		int j = 0;
		
		while (i < _poly.size() || j < other.getPolynom().size())
		{
			//if i reached the end of the arrayList
			if (i == _poly.size())
			{
				newPoly.getPolynom().add(other.getPolynom().get(j));
				j++;
			}
			
			//if j reached the end of the arrayList
			else if (j == other.getPolynom().size())
			{
				newPoly.getPolynom().add(_poly.get(i));
				i++;
			}
			
			//if the power of poly received as parameter smaller
			else if (_poly.get(i).getPower() > other.getPolynom().get(j).getPower())
			{
				newPoly.getPolynom().add(new Element(_poly.get(i)));
				i++;
			}
			
			//if the plynom's power is equal
			else if (_poly.get(i).getPower() == other.getPolynom().get(j).getPower())
			{
				double sum = (_poly.get(i).getMekadem()-other.getPolynom().get(j).getMekadem());
				
				//if the sum is 0 we won't add it to newPoly
				if (sum == 0)
				{
					i++;
					j++;
				}
				else 
				{
					newPoly.getPolynom().add(new Element(sum, _poly.get(i).getPower()));
					i++;
					j++;
				}
				
			}
			
			//if the power of poly received as parameter bigger
			else if (_poly.get(i).getPower() < other.getPolynom().get(j).getPower())
			{
				newPoly.getPolynom().add(new Element((0 - other.getPolynom().get(j).getMekadem()), other.getPolynom().get(j).getPower()));
				j++;
			}
		}
		return newPoly;
	}
	
	/**
     * Cuts the polynom
     *
     * @return	newPoly	a new polynom after the manipulation
     */
	public Polynom cutPoly()
	{
		Polynom newPoly = new Polynom();
		
		for (Element e : _poly)
		{
			if (e.getPower() > 0)
				newPoly.getPolynom().add(new Element((e.getMekadem() * (double)e.getPower() ), e.getPower()-1));
		}
		
		return newPoly;
	}
	
	/**
     * Overrides the method CompareTo. polynom received as a parameter to the polynom it runs on 
     *
     * @param	other	another polynom
     * @return	0		if the polynoms are equal
     * @return	1		if the polynom received as a parameter smaller 
     * @return	-1		if the polynom received as a parameter bigger
     */
	@Override
	public int compareTo(Polynom other) 
	{
		int i = 0;
		int j = 0;
		
		//if the plynom's power is equal, then checking the mekadmim
		if (_poly.get(i).getPower() == other.getPolynom().get(j).getPower())
		{
			if (_poly.get(i).getMekadem() < other.getPolynom().get(j).getMekadem())
				return -1;
			else if (_poly.get(i).getMekadem() > other.getPolynom().get(j).getMekadem())
				return 1;
			else
				return 0;
			
		}
		
		//if the power of poly received as parameter smaller
		if (_poly.get(i).getPower() > other.getPolynom().get(j).getPower())
		{
			if (_poly.get(i).getMekadem() < 0)
				return -1;
			else
				return 1;
		}
		
		//if the power of poly received as parameter bigger
		if (_poly.get(i).getPower() < other.getPolynom().get(j).getPower())
		{
			if (other.getPolynom().get(j).getMekadem() < 0)
				return 1;
			else
				return -1;
		}
		
		return 0;
	}
	
	
}
