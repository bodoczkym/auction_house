package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.HibernateUtil;
import com.shaddox.auction_spring.entity.AuctionItem;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuctionItemDAOImpl implements AuctionItemDAO {

    private static final Logger LOGGER = Logger.getLogger(AuctionItemDAOImpl.class);
//     need to inject the session factory
//        @Autowired
//        private SessionFactory sessionFactory;

    @Override
//  @Transactional // Emiatt a session.beginTransaction(); és a session.getTransaction().commit(); elhagyható
    public List<AuctionItem> getAuctionItems() {

        // get the current Hibernate session
        // TODO should add this as a dependency instead of a static method. This works fine, but it is closely coupled, which is not ideal.

        Session currentSession = HibernateUtil.getSession();

        // create a query
        Query<AuctionItem> theQuery = currentSession.createQuery("from AuctionItem order by name", AuctionItem.class);

        // execute a query and get result list
        List<AuctionItem> auctionItems = theQuery.getResultList();

        // return the results
        return auctionItems;
    }

    @Override
    public void saveAuctionItem(AuctionItem theAuctionItem) {

        // get current hibernate session
        Session currentSession = HibernateUtil.getSession();

        // begin transaction
        currentSession.beginTransaction();

        // save/update the auction item
        currentSession.saveOrUpdate(theAuctionItem);

        // commit the transaction
        currentSession.getTransaction().commit();
    }

    @Override
    public AuctionItem getAuctionItem(int theId) {

        // get the current hibernate session
        Session currentSession = HibernateUtil.getSession();

        // retrieve/read from database using the primary key
        AuctionItem theAuctionItem = currentSession.get(AuctionItem.class, theId);

        // return the auction item
        return theAuctionItem;
    }

    @Override
    public void deleteAuctionItem(int theId) {

        // get the current hibernate session
        Session currentSession = HibernateUtil.getSession();

        currentSession.beginTransaction();

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from AuctionItem where id=:auctionItemId");
        theQuery.setParameter("auctionItemId", theId);

        theQuery.executeUpdate();

        currentSession.getTransaction().commit();
    }
}
