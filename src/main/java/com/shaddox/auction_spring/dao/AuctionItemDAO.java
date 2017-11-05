package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.entity.AuctionItem;

import java.util.List;

public interface AuctionItemDAO {
    List<AuctionItem> getAuctionItems();

    void saveAuctionItem(AuctionItem theAuctionItem);

    AuctionItem getAuctionItem(int theId);

    void deleteAuctionItem(int theId);
}
