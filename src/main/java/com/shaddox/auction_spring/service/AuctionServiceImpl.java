package com.shaddox.auction_spring.service;

import com.shaddox.auction_spring.controller.AuctionItemController;
import com.shaddox.auction_spring.dao.AuctionItemDAO;
import com.shaddox.auction_spring.entity.AuctionItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    // need to inject auction item dao
    @Autowired
    private AuctionItemDAO auctionItemDAO;

    // TODO need to inject bidder dao


    @Override
    @Transactional // Emiatt a session.beginTransaction(); és a session.getTransaction().commit(); elhagyható
    public List<AuctionItem> getAuctionItems() {
        return auctionItemDAO.getAuctionItems();
    }

    // TODO @Transactional not working for some reason, need to understand the mechanics of it

    @Override
    @Transactional
    public void saveAuctionItem(AuctionItem theAuctionItem) {

        auctionItemDAO.saveAuctionItem(theAuctionItem);

    }

    @Override
    @Transactional
    public AuctionItem getAuctionItem(int theId) {
        return auctionItemDAO.getAuctionItem(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        auctionItemDAO.deleteAuctionItem(theId);
    }
}
