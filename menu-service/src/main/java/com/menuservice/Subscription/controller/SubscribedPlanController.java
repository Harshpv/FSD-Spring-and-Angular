package com.menuservice.Subscription.controller;


import com.menuservice.Subscription.service.SubscribedPlanServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/SubscribedPlan")
public class SubscribedPlanController {

    SubscribedPlanServices services;

    public SubscribedPlanController(SubscribedPlanServices services){
        super();
        this.services = services;
    }



}
