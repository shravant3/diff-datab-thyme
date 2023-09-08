package com.week4.page;


import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import scorex.util.ArrayList;

@Controller
public class PageController {
    
    @GetMapping("/login")
    public String login(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        data d=new data();
        model.addAttribute("name",d.getName());
        List<card> list=new ArrayList<>();
        list.add(new card("1","/images/thumb/casandra.png"));
        list.add(new card("2","/images/thumb/couch.png"));
        list.add(new card("3","/images/thumb/firebase.png"));
        list.add(new card("4","/images/thumb/mongo.png"));
        list.add(new card("5","/images/thumb/sql.png"));
        model.addAttribute("lst",list);
        return "index";
    }

    @GetMapping("/table")
    public String table(Model model){
        data d=new data();
        model.addAttribute("name",d.getName());
        List<card> list=new ArrayList<>();
        list.add(new card("Casandra","/images/thumb/casandra.png"));
        list.add(new card("Couch","/images/thumb/couch.png"));
        list.add(new card("Firebase","/images/thumb/firebase.png"));
        list.add(new card("Mongo","/images/thumb/mongo.png"));
        list.add(new card("Sql","/images/thumb/sql.png"));
        model.addAttribute("lst",list);
        return "table";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
}