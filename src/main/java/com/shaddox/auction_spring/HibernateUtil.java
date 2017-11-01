package com.shaddox.auction_spring;

import com.shaddox.auction_spring.entity.AuctionItem;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;

    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/auction_house?useSSL=false");
            prop.setProperty("hibernate.connection.username", "auction_user");
            prop.setProperty("hibernate.connection.password", "auction_user");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

            concreteSessionFactory = new Configuration()
                    .addPackage("com.shaddox.auction_spring")
                    .addProperties(prop)
                    .addAnnotatedClass(AuctionItem.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }

    public static void main(String[] args) {
        try {
            Session session = getSession();

            System.out.println("Creating new AuctionItem");
            AuctionItem tempAuctionItem = new AuctionItem("Loxon Java Challenge", 5000);

            session.beginTransaction();

            System.out.println("Saving AuctionItem object");
            session.save(tempAuctionItem);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {

        }
    }
}
