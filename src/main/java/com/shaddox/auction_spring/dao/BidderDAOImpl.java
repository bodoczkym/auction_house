package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.HibernateUtil;
import com.shaddox.auction_spring.entity.Bidder;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BidderDAOImpl implements BidderDAO {

    @Override
    public List<Bidder> getBidders() {

        Session currentSession = HibernateUtil.getSession();
        Query<Bidder> theQuery = currentSession.createQuery( "from Bidder order by name", Bidder.class);
        return theQuery.getResultList();
    }

    @Override
    public Bidder getBidder(int theId) {
        Session currentSession = HibernateUtil.getSession();
        return currentSession.get(Bidder.class, theId);
    }

    @Override
    public void saveBidder(Bidder theBidder) {
        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(theBidder);
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteBidder(int theId) {
        Session currentSession = HibernateUtil.getSession();
        currentSession.beginTransaction();
        Query theQuery = currentSession.createQuery("delete from Bidder where id=:bidderId");
        theQuery.setParameter("bidderId", theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();
    }
}
