package com.demo.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.demo.pojo.Employee;

public class DB {

	public static SessionFactory sessionFactory = null;
	
	static{
//		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Configuration cfg  =new AnnotationConfiguration().configure();
		cfg.addAnnotatedClass(Employee.class);
		sessionFactory = cfg.buildSessionFactory(); 
	}
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	public Session getOpenSession(){
		return sessionFactory.openSession();
	}
	public static void close(){
		//sessionFactory.getCurrentSession().flush();
		//sessionFactory.getCurrentSession().close();
		sessionFactory.close();
	}
}
