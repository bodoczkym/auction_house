package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.HibernateUtil;
import com.shaddox.auction_spring.entity.Bid;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BidDAOImpl implements BidDAO {

    @Override
    public Bid getHighestBid(int theId) {
        Session currentSession = HibernateUtil.getSession();
        return currentSession.get(Bid.class, theId);
    }

    @Override
    public void saveBid(Bid theBid) {

        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();
        currentSession.save(theBid);
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteBid(int theId) {
        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();
        Query theQuery = currentSession.createQuery("delete from Bid where id=:bidId");
        theQuery.setParameter("bidId", theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();
    }
}
