package utility;

import java.util.Date;

public class Employee extends Person implements Comparable<Employee>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5482512708617995200L;
	private String department, position;
	private double wage;
	
	public Employee(int _ID, String _surname, String _name, String _patronym, Date _dateOfBirth, SexEnum _sex) {
		super(_ID, _surname, _name, _patronym, _dateOfBirth, _sex);
		department = "NA";
		position = "NA";
		wage = 0.0f;
	}
	
	public Employee(int _ID, String _surname, String _name, String _patronym, Date _dateOfBirth, SexEnum _sex,
					String _department, String _position, double _wage) {
		super(_ID, _surname, _name, _patronym, _dateOfBirth, _sex);
		department = _department; position = _position; wage = _wage;
	}
	
	public void SetDepartment(String _department) {
		department = _department;
	}
	
	public String GetDepartment() {
		return this.department;
	}
	
	public void SetPosition(String _position) {
		position = _position;
	}
	
	public String GetPosition() {
		return this.position;
	}
	
	public void SetWage(double _wage) {
		wage = _wage;
	}
	
	public double GetWage() {
		return this.wage;
	}

	@Override
	public int compareTo(Employee o) {
		return Double.compare(wage, o.wage);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " +
				 "Department=" + department + ", " +
				 "Position=" + position + ", " +
				 "Wage=" + Double.toString(wage);
				
	}
	
}
