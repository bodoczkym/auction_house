package com.shaddox.auction_spring.controller;

import com.shaddox.auction_spring.dao.AuctionItemDAO;
import com.shaddox.auction_spring.entity.AuctionItem;
import com.shaddox.auction_spring.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/auction_item")
public class AuctionItemController {

    // need to inject our customer service
    @Autowired
    private AuctionService auctionService;

    // @GetMapping annotation will only respond to GET requests (instead of the normal @RequestMapping)
    @GetMapping("/list")
    public String listAuctionItems (Model theModel) {

        // get the auction items from the sevice
        List<AuctionItem> theAuctionItems = auctionService.getAuctionItems();

        // add the auction items to the model
        theModel.addAttribute("auction_items", theAuctionItems);

        return "list-auction_items";
    }

}
