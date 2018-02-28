package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private SessionFactory sessionFactory = null;

	public HibernateUtil(String configFile) {
		super();
		buildSessionFactory("hibernateWithSecondLevelCache.cfg.xml");
	}

	private void buildSessionFactory(String propertyFile) {
		try {
			Configuration configure = new Configuration().configure(propertyFile);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configure.getProperties()).build();

			sessionFactory = configure.buildSessionFactory(serviceRegistry);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Not able to create sessionfactory");
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void shutDown() {
		sessionFactory.close();
	}
}
