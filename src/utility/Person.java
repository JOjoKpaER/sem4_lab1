package utility;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8948122473058093938L;
	private int ID;
	private String surname, name, patronym;
	private Date dateOfBirth;
	private SexEnum sex;
	
	
	public Person(int _ID, String _surname, String _name, String _patronym, Date _dateOfBirth, SexEnum _sex) {
		surname = _surname; name = _name; patronym = _patronym; dateOfBirth = _dateOfBirth; sex = _sex;
		ID = _ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public Person(Person _copy) {
		surname = _copy.surname; name = _copy.name; patronym = _copy.patronym; dateOfBirth = _copy.dateOfBirth; sex = _copy.sex;
	}
	
	public void SetName(String _name) {
		this.name = _name;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public void SetSurname(String _surname) {
		this.surname = _surname;
	}
	
	public String GetSurname() {
		return this.surname;
	}
	
	public void SetPatronym(String _patronym) {
		this.patronym = _patronym;
	}
	
	public String GetPatronym() {
		return this.patronym;
	}
	
	public void SetDateOfBirth(Date _dob) {
		this.dateOfBirth = _dob;
	}
	
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void SetSex(SexEnum _sex) {
		this.sex = _sex;
	}
	
	public SexEnum GetSex() {
		return this.sex;
	}
	
	@Override
	public String toString() {
		return  "ID=" + ID + ", " +
				"Surname=" + surname + ", " +
				"Name=" + name + ", " +
				"Patronym=" + patronym + ", " +
				"DateOfBirth=" + dateOfBirth.toString() + ", " +
				"Sex=" + sex.toString() + ", " ;
	}
}
