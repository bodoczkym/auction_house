package com.shaddox.auction_spring.controller;

import com.shaddox.auction_spring.entity.Bidder;
import com.shaddox.auction_spring.service.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bidder")
public class BidderController {

    @Autowired
    private BidderService bidderService;

    @GetMapping("/list")
    public String listBidders (Model theModel) {

        List<Bidder> theBidders = bidderService.getBidders();

        theModel.addAttribute("bidders", theBidders);

        return "list-bidders";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel) {

        Bidder theBidder = new Bidder();

        theModel.addAttribute("bidder", theBidder);

        return "bidder-form";
    }

    @PostMapping("/saveBidder")
    public String saveBidder (@ModelAttribute("current_bidder}") Bidder theBidder) {

        bidderService.saveBidder(theBidder);

        return "redirect:/bidder/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate (@RequestParam("bidderId") int theId, Model theModel) {

        Bidder theBidder = bidderService.getBidder(theId);

        theModel.addAttribute("bidder", theBidder);

        return "bidder-form";
    }

    @GetMapping("/delete")
    public String deleteBidder(@RequestParam("bidderId") int theId) {

        bidderService.deleteBidder(theId);

        return "redirect:/bidder/list";
    }
}
