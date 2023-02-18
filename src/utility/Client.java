package utility;

import java.util.Date;

public class Client extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5289985325254880353L;
	private int orderID;
	
	public Client(int _ID, String _surname, String _name, String _patronym, Date _dateOfBirth, SexEnum _sex, int _orderID) {
		super(_ID, _surname, _name, _patronym, _dateOfBirth, _sex);
		// TODO Auto-generated constructor stub
		orderID = _orderID;
	}
	
	public void SetOrderID(int _id) {
		orderID = _id;
	}
	
	public int GetOrderID() {
		return orderID;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"OrderID=" + orderID;
	}
}
