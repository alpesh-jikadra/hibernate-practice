package com.example;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Cache;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.sf.ehcache.CacheManager;

public class Demo {
//http://www.baeldung.com/hibernate-second-level-cache
	SessionFactory sessionFactory = null;

	public Demo(){
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void insert() {

		Session currentSession = sessionFactory.openSession();
		Transaction beginTransaction = currentSession.beginTransaction();
		Employee employee = new Employee();
		employee.setName("Alpesh 1");
		Serializable save = currentSession.save(employee);
		System.out.println(save);
		beginTransaction.commit();

	}

	public Employee get(Integer pk) {
		 
		return (Employee) getSession().get(Employee.class, pk);

	}
	public void readByQuery(Integer pk){
		Session currentSession = sessionFactory.openSession();
		List<Employee> list = currentSession.createQuery("from com.example.Employee as e where e.id ="+pk).list();
		System.out.println(list);
		
	}
	public  Session getSession(){
		return sessionFactory.openSession();
	}
	
	public void readExample(Session session){
		print(get(6));
		print(get(6));
		print(get(6));
		print(get(6));
		print(get(6));
	}
	public static void main(String[] args) {
		try {
			Demo demo = new Demo();
			Session session = demo.getSession();
			demo.readExample(session);
//			demo.queryCacheExample(session);
			/*Employee read = demo.read(6, session);
			print(read);
			Transaction beginTransaction = session.beginTransaction();
			read.setName("BB");
			session.update(read);
			session.flush();
			beginTransaction.commit();*/
//			int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("employee").getSize();
//			print("Total Size = " +size);
//			read = demo.read(7, session);
//			print(read);
			
			
//			size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("employee").getSize();
//			print("Total Size = " +size);
			
//			Query createQuery = session.createQuery("from com.example.Employee where id =6");
//			createQuery.setCacheable(true);
//			createQuery.addQueryHint("org.hibernate.cacheable");
			/*createQuery.addSynchronizedEntityClass(Employee.class);
			createQuery.addSynchronizedEntityName("com.example.Employee");
			createQuery.addSynchronizedQuerySpace("employee");*/
//			Object uniqueResult = createQuery.list();
//			print("Obj== "+uniqueResult);
			
//			createQuery = session.createQuery("from com.example.Employee where id =6");
//			createQuery.setCacheable(true);
//			createQuery.addQueryHint("org.hibernate.cacheable");
//			
//			print("Obj== "+createQuery.list());
			

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutDown();
		}

	}

	public void queryCacheExample(Session session){
		
		Query createQuery = session.createQuery("from com.example.Employee where id =6");
		createQuery.setCacheable(true);
		createQuery.addQueryHint("org.hibernate.cacheable");
		Object uniqueResult = createQuery.list();
		print("Obj== "+uniqueResult);
		
		createQuery = session.createQuery("from com.example.Employee where id =6");
		createQuery.setCacheable(true);
		createQuery.addQueryHint("org.hibernate.cacheable");
		uniqueResult = createQuery.list();
		print("Obj== "+uniqueResult);
	}
	private static void print(Object o) {
		System.out.println(o);
	}

}
