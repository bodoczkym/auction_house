package com.shaddox.auction_spring.controller;

import com.shaddox.auction_spring.dao.AuctionItemDAO;
import com.shaddox.auction_spring.entity.AuctionItem;
import com.shaddox.auction_spring.service.AuctionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/auction_item")
public class AuctionItemController {

    private static final Logger LOGGER = Logger.getLogger(AuctionItemController.class);

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

        return "list-auction-items";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel) {

        // create model attribute to bind form data
        AuctionItem theAuctionItem = new AuctionItem();

        theModel.addAttribute("auction_item", theAuctionItem);

        return "auction-item-form";
    }

    @PostMapping("/saveAuctionItem")
    public String saveAuctionItem (@ModelAttribute("auction_item") AuctionItem theAuctionItem) {

        LOGGER.info("AuctionItemController :saveAuctionItem method started.");

        LOGGER.info("auction item name: " + theAuctionItem.getName());
        LOGGER.info("auction item price: " + theAuctionItem.getPrice());
        LOGGER.info("auction item type: " + theAuctionItem.getPrice().getClass());

        auctionService.saveAuctionItem(theAuctionItem);

        return "redirect:/auction_item/list";
    }
}
