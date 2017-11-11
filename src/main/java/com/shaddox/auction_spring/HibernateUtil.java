package com.shaddox.auction_spring;

import com.shaddox.auction_spring.entity.AuctionItem;
import com.shaddox.auction_spring.entity.Bid;
import com.shaddox.auction_spring.entity.Bidder;
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

            // need to add configuration when adding new tables!
            concreteSessionFactory = new Configuration()
                    .addPackage("com.shaddox.auction_spring")
                    .addProperties(prop)
                    .addAnnotatedClass(AuctionItem.class)
                    .addAnnotatedClass(Bidder.class)
                    .addAnnotatedClass(Bid.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }

    static Session currentSession;

    public static void main(String[] args) {
        try {
            currentSession = getSession();

//            AuctionItem tempAuctionItem = new AuctionItem("Eiffel-tower", 78500);
//
//            // create bids
//            Bid tempBid1 = new Bid(80000);
//            Bid tempBid2 = new Bid(85000);
//
//            // create bidders
//            Bidder tempBidder1 = new Bidder("Vilmos");
//            Bidder tempBidder2 = new Bidder("Emma");
//
//            tempBid1.setAuctionItem(tempAuctionItem);
//            tempBid1.setBidder(tempBidder1);
//            tempBid2.setAuctionItem(tempAuctionItem);
//            tempBid2.setBidder(tempBidder2);


//            currentSession.save(tempAuctionItem);
//            currentSession.save(tempBidder1);
//            currentSession.save(tempBidder2);
//            currentSession.save(tempBid1);
//            currentSession.save(tempBid2);

            //            To retrieve auction item

//            int theId = 17;
//            AuctionItem tempAuctionItem = currentSession.get(AuctionItem.class, theId);
//            System.out.println("\nAuction item: " + tempAuctionItem);
//            System.out.println("\nBids: " + tempAuctionItem.getBids());

            AuctionItem tempAuctionItem = new AuctionItem("Tuzhely", 900);

            Bid tempBid1 = new Bid(990);

            Bidder tempBidder1 = new Bidder("Vilmos");

            tempBid1.setBidder(tempBidder1);
            tempBid1.setAuctionItem(tempAuctionItem);


            tempAuctionItem.setHighestBid(tempBid1);

            currentSession.beginTransaction();

            currentSession.save(tempBidder1);
            currentSession.save(tempAuctionItem);
            currentSession.save(tempBid1);

            currentSession.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            currentSession.close();
        }
    }
}
