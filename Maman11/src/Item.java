
public class Item 
{
	String _itemName;
	double _itemPrice;
	
	/**
     * Item constructor
     *
     * @param	name	item's name
     * @param	price	item's price
     */
	public Item(String name, double price)
	{
		_itemName = name;
		_itemPrice = price;
	}
	
	/**
     * Copy constructor
     *
     * @param	item	item to be copied
     */
	public Item(Item item)
	{
		_itemName = item.getItemName();
		_itemPrice = item.getPrice();
	}
	
	/**
     * Gets the item's price
     *
     * @return	_itemPrice	item's price
     */
	public double getPrice()
	{
		return _itemPrice;
	}
	
	/**
     * Gets the item's name
     *
     * @return	_itemName	item's name
     */
	public String getItemName()
	{
		return _itemName;
	}
	
	/**
     * toString to print the item's object
     *
     * @return	Name: xxx Price: zzz
     */
	public String toString()
	{
		return (" Name: "+ _itemName +"\nPrice: " +_itemPrice + "\n\n" );
	}

}
