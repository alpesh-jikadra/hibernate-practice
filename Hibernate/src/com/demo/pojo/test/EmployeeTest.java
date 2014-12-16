package com.demo.pojo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.demo.db.DB;
import com.demo.pojo.Employee;

public class EmployeeTest {

	public Integer addEmployee(String fName, String lName, int salary) {
		DB db = new DB();
		Transaction tx = null;
		Session session = db.getCurrentSession();
		tx = session.beginTransaction();
		Integer empId = null;
		try {
			Employee e1 = new Employee(fName, lName, salary);
			empId = (Integer) session.save(e1);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return empId;
	}
	public void checkCriteria(){
		DB db = new DB();
		Session session  = db.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria cr= session.createCriteria(Employee.class);
		
		//cr.setProjection(Projections.rowCount());
		cr.setProjection(Projections.avg("salary"));
	
		List l = cr.list();
		
		tx.rollback();
		
	}
	public void checkNetiveQuery(){
		DB db = new DB();
		Session session  = db.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from employee");
		query.addEntity(Employee.class);
		List l = query.list();
		
		tx.rollback();	
	}
	public static void main(String[] args) {
		
		EmployeeTest et = new EmployeeTest();
		et.checkCriteria();
		et.checkNetiveQuery();
		
		System.out.println(et.addEmployee("Alpesh", "Jikadra", 20000));
		DB.close(); 
		
	}

}
