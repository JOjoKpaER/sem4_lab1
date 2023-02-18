package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import utility.Client;
import utility.Employee;
import utility.Good;
import utility.Order;
import utility.SexEnum;

public class Model {

	private ArrayList<Good> goods;
	private ArrayList<Order> orders;
	private ArrayList<Client> clients;
	private ArrayList<Employee> employees;
		
	final private String goodsFileName = "goods.bin";
	final private String ordersFileName = "orders.bin";
	final private String clientsFileName = "clients.bin";
	final private String employeesFileName = "employees.bin";
	
	public Model() {
		goods = new ArrayList<Good>();
		orders = new ArrayList<Order>();
		clients = new ArrayList<Client>();
		employees = new ArrayList<Employee>();
		readAll();
	}
	
	public void addNewGood(String _brand, Date _dom, double _price) {
		goods.add(new Good(goods.size(),_brand, _dom, _price));
	}
	
	public void printGoods() {
		Iterator<Good> g = goods.iterator();
		while (g.hasNext()) {
			Good good = g.next();
			System.out.println(good.toString());
		}
	}
	
	public void addNewOrder(ArrayList<Integer> ids, Date _date) {
		orders.add(new Order(orders.size(), ids , goods, _date));
	}
	
	public void insertGood(int orderID, int goodID) {
		orders.get(goodID).AddGood(goods.get(goodID), goodID);
	}
	
	public void printOrders() {
		Iterator<Order> o = orders.iterator();
		while (o.hasNext()) {
			Order order = o.next();
			System.out.println(order.toString());
		}
	}
	
	public void printPopGood() {
		HashMap<Integer, Integer> map = new HashMap<>();
		Iterator<Good> g = goods.iterator();
		Iterator<Order> o = orders.iterator();
		while (g.hasNext()) {
			map.putIfAbsent(g.next().getID(), 0);
		}
		while (o.hasNext()) {
			Iterator<Integer> id = o.next().getIDs().iterator();
			while (id.hasNext()) {
				int _id = id.next();
				int amount = map.get(_id) + 1;
				map.put(_id, amount);
			}
		}
		List<Entry<Integer, Integer>> sorted = MapUtil.sortByValue(map);
		try {
		System.out.println("The most popular good is: " + 
							goods.get(sorted.get(sorted.size()-1).getKey()));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNewClient(String _surname, String _name, String _patronym, Date _doB, SexEnum _sex, int _orderID ) {
		clients.add(new Client(clients.size(),_surname, _name, _patronym, _doB, _sex, _orderID));
	}
	
	public void printClients() {
		Iterator<Client> c = clients.iterator();
		while(c.hasNext()) {
			Client client = c.next();
			System.out.println(client.toString());
		}
		
	}
	
	public void addEmployee(
			   String _Surname, String _Name, String _Patronym,
			   Date _doB, SexEnum _sex,
			   String _department, String _postion, double _wage) {
		employees.add(new Employee(employees.size(),
								   _Surname, _Name, _Patronym,
								   _doB, _sex,
								   _department, _postion, _wage));
	}
	
	public void printEmployees() {
		Iterator<Employee> e = employees.iterator();
		while(e.hasNext()) {
			Employee employee = e.next();
			System.out.println(employee.toString());
		}
	}
	
	public void printNumOfEmployees() {
		System.out.println("Total number of employees is: " + (employees.size()));
	}
	
	public void printMedianWage() {
		double median = 0.0;
		Iterator<Employee> e = employees.iterator();
		while (e.hasNext()) {
			median += e.next().GetWage();
		}
		median/=(employees.size());
		System.out.println("Median salary is: " + median);
	}
	
	public void printSumWage() {
		double sum = 0.0;
		Iterator<Employee> e = employees.iterator();
		while (e.hasNext()) {
			sum += e.next().GetWage();
		}
		System.out.println("Total sum of salary is: " + sum);
	}
	
	public void saveAll() {
		try {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(goodsFileName));
        objectOutputStream.writeObject(goods);
        objectOutputStream.close();
        
		objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(ordersFileName));
        objectOutputStream.writeObject(orders);
        objectOutputStream.close();
        
		objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(clientsFileName));
        objectOutputStream.writeObject(clients);
        objectOutputStream.close();
        
		objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(employeesFileName));
        objectOutputStream.writeObject(employees);
        objectOutputStream.close();
        
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readAll() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream(goodsFileName));
			goods = (ArrayList<Good>) objectInputStream.readObject();
			objectInputStream.close();
			
			objectInputStream = new ObjectInputStream(
					new FileInputStream(ordersFileName));
			orders = (ArrayList<Order>) objectInputStream.readObject();
			objectInputStream.close();
			
			objectInputStream = new ObjectInputStream(
					new FileInputStream(clientsFileName));
			clients = (ArrayList<Client>) objectInputStream.readObject();
			objectInputStream.close();
			
			objectInputStream = new ObjectInputStream(
					new FileInputStream(employeesFileName));
			employees = (ArrayList<Employee>) objectInputStream.readObject();
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class MapUtil {
    public static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        return list;
    }
}
