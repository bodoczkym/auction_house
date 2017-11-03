package com.shaddox.auction_spring.service;

import com.shaddox.auction_spring.entity.AuctionItem;
import com.shaddox.auction_spring.entity.Bidder;

import java.util.List;

public interface AuctionService {
    List<AuctionItem> getAuctionItems();

    // TODO add bidders
    //public List<Bidder> getBidders();

    void saveAuctionItem (AuctionItem auctionItem);

    AuctionItem getAuctionItem(int theId);
}
