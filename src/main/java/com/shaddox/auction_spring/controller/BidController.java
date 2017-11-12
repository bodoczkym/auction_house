package com.shaddox.auction_spring.controller;

import com.shaddox.auction_spring.entity.AuctionItem;
import com.shaddox.auction_spring.entity.Bid;
import com.shaddox.auction_spring.entity.Bidder;
import com.shaddox.auction_spring.service.AuctionItemService;
import com.shaddox.auction_spring.service.BidService;
import com.shaddox.auction_spring.service.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @Autowired
    private AuctionItemService auctionItemService;

    @Autowired
    private BidderService bidderService;

    @GetMapping("/showFormToBid")
    public String showFormForAdd(@RequestParam("auctionItemId") int auctionItemId, @RequestParam("bidderId") int
            bidderId, /*@RequestParam("bidId") int bidId,*/   Model theModel) {

        AuctionItem theAuctionItem = auctionItemService.getAuctionItem(auctionItemId);
        theModel.addAttribute("auction_item", theAuctionItem);

        Bidder theBidder = bidderService.getBidder(bidderId);
        theModel.addAttribute("bidder", theBidder);

        // create model attribute to bind form data
        Bid theBid = new Bid();
        theModel.addAttribute("newBid", theBid);

        return "bid-form";
    }

    @RequestMapping("/saveBid")
    public String saveBid(@ModelAttribute("current_bid}") Bid theBid, @RequestParam("auctionItemId") int
            auctionItemId, @RequestParam("bidderId") int bidderId) {

        AuctionItem theAuctionItem = auctionItemService.getAuctionItem(auctionItemId);

        Bidder theBidder = bidderService.getBidder(bidderId);

        theBid.setAuctionItem(theAuctionItem);
        theBid.setBidder(theBidder);

        Bid currentBid = theAuctionItem.getHighestBid();
        if (currentBid != null) {
            bidService.deleteBid(currentBid.getBidId());
        }
        bidService.saveBid(theBid);

        return "redirect:/auction_item/list";
    }

    @GetMapping("/delete")
    public String deleteAuctionItem(@RequestParam("bid_id") int theId) {

        bidService.deleteBid(theId);

        return "redirect:/auction_item/list";
    }
}
