package com.shaddox.auction_spring.service;

import com.shaddox.auction_spring.entity.AuctionItem;

import java.util.List;

public interface AuctionItemService {
    List<AuctionItem> getAuctionItems();

    void saveAuctionItem(AuctionItem auctionItem);

    AuctionItem getAuctionItem(int theId);

    void deleteCustomer(int theId);
}
