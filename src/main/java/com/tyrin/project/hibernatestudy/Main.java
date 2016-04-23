/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyrin.project.hibernatestudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
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
//        sessionFactory.
            
                
                
                
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
