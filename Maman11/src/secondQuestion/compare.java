package secondQuestion;
import java.util.*;

public class compare implements Comparator<Element>
{
	/**
     * Helps in sorting the arrayList in a descending order
     *
     * @param	e1	element
     * @param	e2	element
     */
	@Override
    public int compare(Element e1, Element e2) 
	{
        return e1.getPower() > e2.getPower() ? -1 :(e1.getPower() < e2.getPower() ? 1 : 0);
	}
}
