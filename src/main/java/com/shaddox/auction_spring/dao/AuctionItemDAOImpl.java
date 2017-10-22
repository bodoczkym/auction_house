package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.HibernateUtil;
import com.shaddox.auction_spring.entity.AuctionItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuctionItemDAOImpl implements AuctionItemDAO {


    // need to inject the session factory
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
//    @Transactional // Emiatt a session.beginTransaction(); és a session.getTransaction().commit(); elhagyható
    public List<AuctionItem> getAuctionItems() {

        // get the current Hibernate session
        // TODO should add this as a dependency instead of a static method, but it works fine.
        Session currentSession = HibernateUtil.getSession();

        // create a query
        Query<AuctionItem> theQuery = currentSession.createQuery("from AuctionItem", AuctionItem.class);

        // execute a query and get result list
        List<AuctionItem> auctionItems = theQuery.getResultList();

        // return the results
        return auctionItems;
    }
}
