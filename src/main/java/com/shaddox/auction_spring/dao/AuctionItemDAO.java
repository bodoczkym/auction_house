package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.entity.AuctionItem;

import java.util.List;

public interface AuctionItemDAO {
    public List<AuctionItem> getAuctionItems ();
}
