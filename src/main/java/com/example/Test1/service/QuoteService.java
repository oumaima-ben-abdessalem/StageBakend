package com.example.Test1.service;
import com.example.Test1.dao.QuoteRepository;
import com.example.Test1.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;


    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote addQuote(Quote quote) {
        return (quoteRepository.save(quote));
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote updateQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);

    }
    public Quote getQuoteById(Long id){

        return(quoteRepository.findById(id).orElse(null));
    }


}
