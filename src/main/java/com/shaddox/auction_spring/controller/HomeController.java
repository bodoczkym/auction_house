package com.shaddox.auction_spring.controller;

import com.shaddox.auction_spring.entity.AuctionItem;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import static com.shaddox.auction_spring.HibernateUtil.getSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home () {
        return "redirect:auction_item/list";
    }
}
