package com.shaddox.auction_spring.service;

import com.shaddox.auction_spring.dao.BidderDAO;
import com.shaddox.auction_spring.entity.Bidder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BidderServiceImpl implements BidderService {

    @Autowired
    private BidderDAO bidderDAO;

    @Override
    @Transactional
    public List<Bidder> getBidders() {
        return bidderDAO.getBidders();
    }

    @Override
    @Transactional
    public Bidder getBidder(int theId) {
        return bidderDAO.getBidder(theId);
    }


    @Override
    @Transactional
    public void saveBidder(Bidder theBidder) {
        bidderDAO.saveBidder(theBidder);
    }


    @Override
    @Transactional
    public void deleteBidder(int theId) {
        bidderDAO.deleteBidder(theId);
    }
}
