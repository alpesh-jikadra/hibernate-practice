package com.example;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoadVsGet {

	SessionFactory sessionFactory = null;
	HibernateUtil util = new HibernateUtil("hibernate.cfg.xml");
	
	public LoadVsGet() {
		super();
		sessionFactory = util.getSessionFactory();
	}


	public static void main(String[] args) {
		LoadVsGet lg = new LoadVsGet();
		try{
			
			lg.load();
			lg.save();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lg.shutdown();
		}
	}
	private void save() {
		Session openSession = sessionFactory.openSession();
		Transaction trn = openSession.beginTransaction();
		Employee load = (Employee) openSession.load(Employee.class, 7);
		EmployeeMobile employeeMobile = new EmployeeMobile();
		employeeMobile.setMobileNo("8956391917");
		Set<EmployeeMobile> mobiles = new HashSet<>();
		mobiles.add(employeeMobile);
		load.setMobiles(mobiles);
		openSession.save(employeeMobile);
		openSession.save(load);
		trn.commit();
	}


	public void shutdown(){
		util.shutDown();
	}
	private void load() {
		
		Session openSession = sessionFactory.openSession();
		Employee load = (Employee) openSession.get(Employee.class, 6);
		System.out.println(load);
		load = (Employee) openSession.get(Employee.class, 6);
		System.out.println(load);
	}

}
