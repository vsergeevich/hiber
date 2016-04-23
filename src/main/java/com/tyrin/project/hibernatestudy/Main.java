/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyrin.project.hibernatestudy;

import com.tyrin.project.hibernatestudy.bean.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 * @author lenovo
 */
public class Main {


    public static void main(String[] args) throws SQLException {
//        stdConntection();
        
        SessionFactory sessionFactory = HibernateUtils.getSessionfactory();
        System.out.println("SUCCESS");
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        tr.begin();
        Book book = new Book();
        book.setName("Shekspir");
        session.save(book);
        tr.commit();
        session.close();
                
    }

    
    
    
    
    
    
    
    
    private static void stdConntection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/hiber";
        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("hiber");
        ds.setUser("tyrin");
        ds.setPassword("123456");
        Connection conn = ds.getConnection();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM test");
        st.setInt(1, 222);
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt(1));
        }
    }
    
}
