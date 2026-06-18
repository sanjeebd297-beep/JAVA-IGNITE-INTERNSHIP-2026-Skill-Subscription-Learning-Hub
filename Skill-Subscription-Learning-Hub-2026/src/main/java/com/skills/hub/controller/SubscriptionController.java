package com.skills.hub.controller;

import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
=========================================================
WHAT IS THIS FILE?
Handles subscription between user and skill pack
=========================================================
*/

@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscribe")
    public String subscribe(@RequestParam Long userId,
                            @RequestParam Long packId) {
        // =========================
        // TASK
        // =========================
        // STEP 1: call subscriptionService.subscribe(userId, packId)
        subscriptionService.subscribe(userId, packId);

        // STEP 2: redirect to subscriptions page
        return "redirect:/subscriptions/" + userId;
    }

    @GetMapping("/subscriptions/{userId}")
    public String viewSubscriptions(@PathVariable Long userId, Model model) {
        // =========================
        // TASK
        // =========================
        // STEP 1: list = subscriptionService.getUserSubscriptions(userId)
        // STEP 2: model.addAttribute("subs", list)
        model.addAttribute("subs", subscriptionService.getUserSubscriptions(userId));

        // STEP 3: return subscriptions.jsp
        return "subscriptions";
    }

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }
}
