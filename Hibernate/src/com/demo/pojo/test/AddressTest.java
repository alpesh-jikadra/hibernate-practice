package com.demo.pojo.test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.db.DB;
import com.demo.pojo.Address;

public class AddressTest {

	public static void main(String[] args){
		Integer id = addAddress("Address1", "city", "state", "zip", "country");
		System.out.println(id);

	}
	public static Integer addAddress(String address1, String city ,String state, String zip, String country) throws IllegalStateException{
		DB db  = new DB();
		Session session = db.getCurrentSession();
		Integer id =null;
		Transaction tx = null;
		try{
			Address address = new Address(address1, city, state,zip, country);
			tx = session.beginTransaction();
			id = (Integer) session.save(address);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
		db.close();
		return id;
	}
}
