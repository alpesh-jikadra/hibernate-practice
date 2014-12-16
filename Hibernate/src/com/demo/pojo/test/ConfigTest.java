package com.demo.pojo.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.demo.db.DB;
import com.demo.pojo.Config;

public class ConfigTest {

	public static void main(String[] args) {
//		add();
		get();
		DB.close();
	}
	
	public static void get(){
		DB db = new DB();
		Session session = db.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Statistics stats = DB.sessionFactory.getStatistics();
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		try {
			/*Query query = session.createQuery("from com.demo.pojo.Config where id = 1");
			query.setCacheable(true);
			Config c = (Config)query.uniqueResult();*/
			Config  c  = (Config) session.load(Config.class, 1);
			System.out.println(c);
			printStats(stats,0);
			
			/*query = session.createQuery("from com.demo.pojo.Config where id = 1");
			query.setCacheable(true);
			c = (Config)query.uniqueResult();*/
			c  = (Config) session.load(Config.class, 1);
			System.out.println(c);
			printStats(stats,1);
			session.evict(c);
			
			/*query = session.createQuery("from com.demo.pojo.Config where id = 1");
			query.setCacheable(true);
			c = (Config)query.uniqueResult();*/
			c  = (Config) session.load(Config.class, 1);
			System.out.println(c);
			printStats(stats,2);
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*List<Config> lists = null;
		try {
			Query query = session.createQuery("from com.demo.pojo.Config");
			query.setCacheable(true);
			lists = query.list();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		print(lists);*/
	}
	public static void print(List<Config> lists){
		for(Config c : lists){
			System.out.println(c);
		}
	}
	private static void printStats(Statistics stats, int i) {
        System.out.println("***** " + i + " *****");
        System.out.println("Fetch Count="
                + stats.getEntityFetchCount());
        System.out.println("Second Level Hit Count="
                + stats.getSecondLevelCacheHitCount());
        System.out
                .println("Second Level Miss Count="
                        + stats
                                .getSecondLevelCacheMissCount());
        System.out.println("Second Level Put Count="
                + stats.getSecondLevelCachePutCount());
    }
	public static void add(){
		DB db = new DB();
		Session session = db.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			Config c = new Config("site","infibeam");
			session.save(c);
			c = new Config("name","alpesh");
			session.save(c);
			c = new Config("age","29");
			session.save(c);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}

}
