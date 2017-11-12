package com.shaddox.auction_spring.service;

import com.shaddox.auction_spring.entity.Bid;

public interface BidService {

    Bid getHighestBid(int theId);

    void saveBid(Bid theBid);

    void deleteBid(int theId);
}
