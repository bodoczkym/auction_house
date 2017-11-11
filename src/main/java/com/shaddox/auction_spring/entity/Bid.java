package com.shaddox.auction_spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @Column(name = "bid_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "bidder_id")
    private Bidder bidder;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "auction_item_id")
    private AuctionItem auctionItem;

    @Column(name = "bid_amount")
    private Integer bidAmount;

    public Bid() {
    }

    public Bid(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", bidder=" + bidder +
                ", auctionItemId=" + auctionItem.getId() +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
