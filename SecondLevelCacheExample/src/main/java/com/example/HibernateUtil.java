package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration configure = new Configuration().configure();
//			configure.addAnnotatedClass(Employee.class);
			
			 ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build(); 

			 SessionFactory buildSessionFactory = configure.buildSessionFactory(serviceRegistry);
			    
			 return buildSessionFactory;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Not able to create sessionfactory");
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void shutDown(){
		sessionFactory.close();
	}
}	
