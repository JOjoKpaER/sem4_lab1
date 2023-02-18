package utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4915232517327891614L;
	private int ID;
	private Date date;
	private double price;
	private ArrayList<Integer> goodsByID;
	
	public Order(int _ID, ArrayList<Integer> _goodsByID, ArrayList<Good> goods,  Date _date) {
		ID = _ID;
		goodsByID = _goodsByID; date = _date; CalcPrice(goods);
	}
	
	public void AddGood(Good _add, int goodById) {
		goodsByID.add(goodById);
		price += _add.GetPrice();
	}
	
	public ArrayList<Integer> getIDs(){
		return goodsByID;
	}
	
	public void SetDate(Date _date) {
		date = _date;
	}
	
	public Date GetDate() {
		return date;
	}
	
	private void CalcPrice(ArrayList<Good> goods ) {
		Iterator<Integer> g = goodsByID.iterator();
		price = 0.0;
		while(g.hasNext()) {
			price += goods.get(g.next()).GetPrice();
		}
	}
	
	public double GetPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return  "ID=" + ID + ", " +
				"Date=" + date.toString() + ", " +
				"Price=" + Double.toString(price) + ", " +
				"List=" + goodsByID.toString() + ", " ;
	}
	
}
