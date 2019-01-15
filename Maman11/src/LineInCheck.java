
public class LineInCheck 
{
	Item _item;
	int _quantity;
	double _total;
	
	/**
     * Constructs a single line in a check
     *
     * @param	item		item
     * @param	quantity	quantity
     */
	public LineInCheck(Item item, int quantity)
	{
		_item = item;
		_quantity = quantity;
		_total = (double)quantity * item.getPrice();
		//System.out.println("HERRRRREEEE " + item.getPrice()+ "TOTAL IS " +_total);
	}
	
	/**
     * Gets the item's name
     *
     * @return	_item	item
     */
	public Item getItem()
	{
		return _item;
	}
	
	/**
     * Gets the item's name
     *
     * @return	_quantity	quantity
     */
	public int getQuantity()
	{
		return _quantity;
	}
	
	/**
     * Gets the item's name
     *
     * @return	_total	total price
     */
	public double getTotal()
	{
		return _total;
	}
}
