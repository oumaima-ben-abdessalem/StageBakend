package com.example.Test1.controller;
import com.example.Test1.entity.Quote;
import com.example.Test1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quote")
public class QuoteController {
    @Autowired
    private final QuoteService quoteService;
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }
    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return new ResponseEntity<>(quoteService.getAllQuotes(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote quote) {
        Quote newQuote = quoteService.addQuote(quote);
        return new ResponseEntity<>(newQuote, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Quote> updateQuote(@RequestBody Quote quote) {
        Quote updatedQuote = quoteService.updateQuote(quote);
        return new ResponseEntity<>(updatedQuote,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuote(@PathVariable("id") Long id ){
        quoteService.deleteQuote(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }


}
