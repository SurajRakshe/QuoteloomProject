package com.example.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Quote;
import com.example.repository.QuoteRepository;

@Service
public class QuoteService {
	
	  
    @Autowired
    private QuoteRepository repo;

    public Quote getRandomQuote() {
        List<Quote> all = repo.findAll();
        return all.get(new Random().nextInt(all.size()));
    }

    public List<Quote> searchByAuthor(String author) {
        return repo.findByAuthorContainingIgnoreCase(author);
    }

    public Quote saveQuote(Quote quote) {
        return repo.save(quote);
    }
}