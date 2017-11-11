package com.shaddox.auction_spring.service;

import com.shaddox.auction_spring.dao.BidDAO;
import com.shaddox.auction_spring.entity.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidDAO bidDAO;

    @Override
    @Transactional
    public Bid getBid(int theId) {
        return bidDAO.getBid(theId);
    }

    @Override
    @Transactional
    public void saveBid(Bid theBid) {
        bidDAO.saveBid(theBid);
    }

    @Override
    @Transactional
    public void deleteBid(int theId) {
        bidDAO.deleteBid(theId);
    }
}
