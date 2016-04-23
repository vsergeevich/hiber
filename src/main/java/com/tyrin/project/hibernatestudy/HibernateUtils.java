/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyrin.project.hibernatestudy;
import com.tyrin.project.hibernatestudy.bean.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;
	
	static {
		Configuration cfg = new Configuration().configure();
                cfg.addAnnotatedClass(Book.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties());
		StandardServiceRegistry sr = builder.build();
		sessionFactory = cfg.buildSessionFactory(sr);
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}