package com.skills.hub.controller;

import com.skills.hub.model.SkillPack;
import com.skills.hub.service.SkillPackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
=========================================================
WHAT IS THIS FILE?
Handles skill pack (course) operations
=========================================================
*/

@Controller
public class SkillPackController {

    private final SkillPackService packService;

    public SkillPackController(SkillPackService packService) {
        this.packService = packService;
    }

    @GetMapping("/packs")
    public String viewPacks(Model model) {
        // STEP 1: fetch all packs and send to JSP
        model.addAttribute("packs", packService.getAllPacks());
        return "packs";
    }

    @GetMapping("/add-pack")
    public String showAddPackPage() {
        // STEP 1: return add-pack page
        return "add-pack";
    }

    @PostMapping("/add-pack")
    public String addPack(@ModelAttribute SkillPack pack) {
        // STEP 1: call packService.addSkillPack(pack)
        // STEP 2: redirect /packs
        packService.addSkillPack(pack);
        return "redirect:/packs";
    }

    @GetMapping("/delete-pack/{id}")
    public String deletePack(@PathVariable Long id) {
        // STEP 1: call packService.deleteSkillPack(id)
        // STEP 2: redirect /packs
        packService.deleteSkillPack(id);
        return "redirect:/packs";
    }

    public SkillPackService getPackService() {
        return packService;
    }
}
