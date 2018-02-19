package com.example;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Demo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try{
			Session currentSession = sessionFactory.openSession();
			Transaction beginTransaction = currentSession.beginTransaction();
			Employee employee = new Employee();
			employee.setName("Alpesh");
			Serializable save = currentSession.save(employee);
			System.out.println(save);
			beginTransaction.commit();
		}finally{
			HibernateUtil.shutDown();
		}
	}

}
