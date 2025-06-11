package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Quote;
import com.example.service.QuoteService;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins = "*")
public class QuoteController {
	

    @Autowired
    private QuoteService service;

    @GetMapping("/random")
    public Quote getRandomQuote() {
        return service.getRandomQuote();
    }

    @GetMapping("/search")
    public List<Quote> searchQuotes(@RequestParam String author) {
        return service.searchByAuthor(author);
    }

    @PostMapping("/add")
    public Quote addQuote(@RequestBody Quote quote) {
        return service.saveQuote(quote);
    }
}



