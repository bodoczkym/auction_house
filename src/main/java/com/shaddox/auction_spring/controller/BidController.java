package com.shaddox.auction_spring.controller;

import com.shaddox.auction_spring.entity.Bid;
import com.shaddox.auction_spring.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Bid theBid = new Bid();

        theModel.addAttribute("bid", theBid);

        return "bid-form";
    }

    @PostMapping("/saveBid")
    public String saveBid(@ModelAttribute("current_bid}") Bid theBid) {

        bidService.saveBid(theBid);

        return "redirect:/auction_item/list";
    }

    @GetMapping("/delete")
    public String deleteAuctionItem(@RequestParam("bid_id") int theId) {

        // delete the customer
        bidService.deleteBid(theId);

        return "redirect:/auction_item/list";
    }
}
