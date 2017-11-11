package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.entity.Bid;

public interface BidDAO {

    Bid getBid(int theId);

    void saveBid(Bid theBid);

    void deleteBid(int theId);

}

