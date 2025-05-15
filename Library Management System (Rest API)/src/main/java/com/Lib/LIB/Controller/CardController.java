package com.Lib.LIB.Controller;

import com.Lib.LIB.Model.CardModel;
import com.Lib.LIB.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public String addCard(@RequestBody CardModel card) {
        cardService.addCard(card);
        return "Card added successfully!";
    }

    @GetMapping("/{id}")
    public CardModel getCardById(@PathVariable int id) {
        return cardService.getCardById(id);
    }

    @GetMapping
    public List<CardModel> getAllCards() {
        return cardService.getAllCards();
    }

    @PutMapping("/{id}/status")
    public String updateCardStatus(@PathVariable int id, @RequestParam boolean status) {
        cardService.updateCardStatus(id, status);
        return "Card status updated!";
    }


    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable int id) {
        cardService.deleteCard(id);
        return "Card deleted successfully!";
    }

    @DeleteMapping("/delete-all")
    public String deleteAllCards() {
        cardService.deleteAll();
        return "All cards deleted!";
    }
}
