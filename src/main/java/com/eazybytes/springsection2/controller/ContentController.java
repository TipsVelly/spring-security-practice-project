package com.eazybytes.springsection2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {
    @GetMapping("/contact")
    public String saveContactInquiryDetails() {
        return "Inquiry details are saved to the DB";
    }
}
