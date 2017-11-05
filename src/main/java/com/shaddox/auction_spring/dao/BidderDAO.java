package com.shaddox.auction_spring.dao;

import com.shaddox.auction_spring.entity.Bidder;

import java.util.List;

public interface BidderDAO {
    List<Bidder> getBidders ();

    void saveBidder(Bidder theBidder);

    Bidder getBidder(int theId);

    void deleteBidder(int theId);
}
