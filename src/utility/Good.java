package utility;

import java.io.Serializable;
import java.util.Date;

public class Good implements Comparable<Good>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 789345243758783001L;
	private String brand;
	private Date dom;
	private double price;
	private int ID;
	
	
	public Good(int _ID, String _brand, Date dateOfManufature, double _price) {
		brand = _brand; dom = dateOfManufature; price = _price; ID = _ID;
	}
	
	public Good(Good _copy) {
		brand = _copy.brand; dom = _copy.dom; price = _copy.price;
	}
	
	public int getID() {
		return ID;
	}
	
	public void SetBrand(String _brand) {
		this.brand = _brand;
	}
	
	public String GetBrand() {
		return this.brand;
	}
	
	public void SetDoM(Date _dom){
		this.dom = _dom;
	}
	
	public Date GetDoM() {
		return this.dom;
	}
	
	public void SetPrice(double _price) {
		this.price = _price;
	}
	
	public double GetPrice() {
		return this.price;
	}

	@Override
	public int compareTo(Good o) {
		return brand.compareTo(o.brand);
	}
	
	@Override
	public String toString() {
		return "Name=" + brand + ", " +
			   "Date=" + dom + ", " +
			   "Price=" + Double.toString(price) + ", " +
			   "ID=" + Integer.toString(ID); 
	}
	
}
