package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

import model.Model;
import utility.Func;
import utility.SexEnum;

public class Controller {
	
	private final HashMap<String, Func> commands = new HashMap<>(){{
			put(" ", new Func() {public void f() {getHelp();}});
			put("?", new Func() {public void f() {getHelp();}});
			put("help", new Func() {public void f() {getHelp();}});
			put("end", new Func() {public void f() {end();}});
			put("add new client", new Func() {public void f() {addNewClient();}});
			put("add new employee", new Func() {public void f() {addNewEmployee();}});
			put("add new good", new Func() {public void f() {addNewGood();}});
			put("add new order", new Func() {public void f() {addNewOrder();}});
			put("print clients", new Func() {public void f() {printClients();}});
			put("print employees", new Func() {public void f() {printEmployees();}});
			put("print goods", new Func() {public void f() {printGoods();}});
			put("print median wage", new Func() {public void f() {printMedianWage();}});
			put("print num of employees", new Func() {public void f() {printNumOfEmployees();}});
			put("print orders", new Func() {public void f() {printOrders();}});
			put("print pop good", new Func() {public void f() {printPopGood();}});
			put("print sum wage", new Func() {public void f() {printSumWage();}});
			put("save all", new Func() {public void f() {saveAll();}});
			
	}};
	
	private final SimpleDateFormat date_form = new SimpleDateFormat("dd mm yy"); 
	
	private Model model;
	private Scanner in = new Scanner(System.in).useLocale(Locale.US);
	private Boolean _end = false;
	
	public Controller() {
		model = new Model();
		loop();
	}
	
	private void loop() {
		while (!_end) {
			String inputStatement = "";
			try {
				inputStatement = in.nextLine();
				commands.get(inputStatement).f();;
			} catch (Exception e) {
				continue;
			}
		}
	}
	
	private void end() {
		_end = true;
	}
	
	private void getHelp() {
		System.out.println("Avaiable commands:");
		ArrayList<String> _commands = new ArrayList<>(commands.keySet());
		Iterator<String> i = _commands.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	private void addNewClient() {
		String surname = ""; String name = ""; String patronym = ""; String _doB = ""; SexEnum sex = SexEnum.values()[0]; int orderID = -1;
		Date doB = new Date(0);
		System.out.println("Enter surname: "); surname = in.nextLine();
		System.out.println("Enter name: "); name = in.nextLine();
		System.out.println("Enter patronym: "); patronym = in.nextLine();
		while (true) {
			try {
				System.out.println("Enter date of birth: (" + date_form.toPattern().toString() + ")"); _doB = in.nextLine();
				doB = date_form.parse(_doB);
			} catch (ParseException e) {
				continue;
			}
				break;
			}
		while (true) {
			try {
				int _sex = 0;
				while (true) {
					System.out.println("Enter sex: (M/F)");
					String sexStr = in.nextLine();
					if (sexStr.contains("M")) { _sex = 1; break;}
					if (sexStr.contains("F")) { _sex = 2; break;}
					}
					sex = SexEnum.values()[_sex];
			}catch (Exception e) {
				// TODO: handle exception
			}
				break;
		}
		while (true) {
			System.out.println("Enter order id:");
			try {
				orderID = in.nextInt();
			}catch (Exception e) {
				// TODO: handle exception
			}
				break;
		}
		model.addNewClient(surname,  name,  patronym,  doB, sex, orderID);
	}
	
	private void addNewEmployee() {
		String _Surname; String _Name; String _Patronym; String doB; SexEnum _sex = SexEnum.values()[0]; String _department; String _postion; double _wage;
		Date _doB = new Date(0);
		System.out.println("Enter surname: "); _Surname = in.nextLine();
		System.out.println("Enter name: "); _Name = in.nextLine();
		System.out.println("Enter patronym: "); _Patronym = in.nextLine();
		while (true) {
			try {
				System.out.println("Enter date of birth: (" + date_form.toPattern().toString() + ")"); doB = in.nextLine();
				_doB = date_form.parse(doB);
			} catch (ParseException e) {
				continue;
			}
				break;
			}
		while (true) {
			try {
				int sex = 0;
				while (true) {
					System.out.println("Enter sex: (M/F)");
					String sexStr = in.nextLine();
					if (sexStr.contains("M")) { sex = 1; break;}
					if (sexStr.contains("F")) { sex = 2; break;}
					}
					_sex = SexEnum.values()[sex];
			}catch (Exception e) {
				// TODO: handle exception
			}
				break;
		}
		System.out.println("Enter department:"); _department = in.nextLine();
		System.out.println("Enter position:"); _postion = in.nextLine();
		while (true) {
			try {
				System.out.println("Enter salary:");
				_wage = in.nextDouble();
			}catch (Exception e) {
				continue;
			}
				break;
		}
		model.addEmployee(_Surname, _Name, _Patronym, _doB, _sex, _department, _postion, _wage);
	}
	
	private void addNewGood() {
		String _brand = ""; String dom = ""; double _price = 0.0;
		Date _dom = new Date(0);
		System.out.println("Enter name:"); _brand = in.nextLine();
		while (true) {
			try {
				System.out.println("Enter date of manufacture: (" + date_form.toPattern().toString() + ")"); 
				dom = in.nextLine();
				_dom = date_form.parse(dom);
			} catch (ParseException e) {
				continue;
			}
				break;
		}
		System.out.println("Enter price:");
		while (true) {
			try {
				System.out.println("Enter price:");
				_price = in.nextDouble();
			}catch (Exception e) {
				continue;
			}
				break;
		}
		model.addNewGood(_brand, _dom, _price);
	}
	
	private void addNewOrder() {
		ArrayList<Integer> ids = new ArrayList<>(); String date = "";
		Date _date = new Date(0);
		while (true) {
			try {
				System.out.println("Enter date: (" + date_form.toPattern().toString() + ")"); date = in.nextLine();
				_date = date_form.parse(date);
			} catch (ParseException e) {
				continue;
			}
				break;
		}
		System.out.println("Start enter valid ids:");
		while (true) {
			try {
				ids.add(in.nextInt());
			}catch (Exception e) {
				break;
			}
		}
		model.addNewOrder(ids, _date);
	}
	
	private void printClients() {
		model.printClients();
	}
	
	private void printEmployees() {
		model.printEmployees();
	}
	
	private void printGoods() {
		model.printGoods();
	}
	
	private void printMedianWage() {
		model.printMedianWage();
	}
	
	private void printNumOfEmployees() {
		model.printNumOfEmployees();
	}
	
	private void printOrders() {
		model.printOrders();
	}
	
	private void printPopGood() {
		model.printPopGood();
	}
	
	private void printSumWage() {
		model.printSumWage();
	}
	
	private void saveAll() {
		model.saveAll();
	}
	
}
