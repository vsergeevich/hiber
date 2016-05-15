/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyrin.project.hibernatestudy;

import com.tyrin.project.hibernatestudy.bean.Book;
import com.tyrin.project.hibernatestudy.bean.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
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
        stdConntection();
//        if(1==1) return;

        SessionFactory sessionFactory = HibernateUtils.getSessionfactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction tr = session.beginTransaction();
            tr.begin();
//        createCascade(session);
            Query q = session.createQuery("from Writer where id=:id");
            q.setParameter("id", 1);
            Writer w = (Writer) q.uniqueResult();

            List<Book> list = w.getBook();
            pr(list);
            list.remove(1);
            pr(list);

            tr.commit();
        } catch (Exception e) {
            System.err.println("ERROR: ");
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private static void createCascade(Session session) {
        Transaction tr = session.beginTransaction();
        tr.begin();

        Writer writer = new Writer();
        writer.setName("Shekspir2");
        session.save(writer);

        Book book = new Book();
        book.setWriter(writer);
        book.setName("Ruslan2");
        session.save(book);

        book = new Book();
        book.setWriter(writer);
        book.setName("Ludmila2");
        session.save(book);

        book = new Book();
        book.setName("Hamlet2");
        book.setWriter(writer);
        session.save(book);

        tr.commit();
//        session.close();

    }

    private static void stdConntection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/hiber";
        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("hiber");
        ds.setUser("hiber");
        ds.setPassword("123456");
        Connection conn = ds.getConnection();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM a");
//        st.setInt(1, 222);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
    }

    private static void pr(Object o) {
        System.out.println(o);
    }

}
