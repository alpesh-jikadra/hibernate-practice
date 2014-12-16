package com.demo.pojo.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.db.DB;
import com.demo.pojo.Address;
import com.demo.pojo.Employee;

public class ManyToOne {

	public static void main(String[] args) {
		Address address = addAddress("10th floor", "Ahmedabad", "Gujarat", "380015", "India");
		System.out.println(address);
		Integer empId = addEmployee("Alpesh", "Jikadra", 2000, address);
		System.out.println(empId);
		empId = addEmployee("piyush", "aghera", 2000, address);
		System.out.println(empId);
		DB.close();
	}
	public static Address addAddress(String address1, String city, String state, String zip, String country){
		Address ad = new Address(address1, city, state, zip, country);
		DB db = new DB();
		Transaction tx=null;
		try{
			Session session = db.getCurrentSession();
			tx = session.beginTransaction();
			session.save(ad);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return ad;
	}
	public static Integer addEmployee(String fName, String lName, int salary, Address address){
		Integer id = null;
		/*DB db = new DB();
		Transaction tx=null;
		try{
			Session session =db.getCurrentSession();
			tx = session.beginTransaction();
			Employee e1= new Employee(fName, lName, salary, address);
			id = (Integer) session.save(e1);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}*/
		return id;
	}
}
