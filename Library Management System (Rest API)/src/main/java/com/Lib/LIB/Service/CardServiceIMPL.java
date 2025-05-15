package com.Lib.LIB.Service;

import com.Lib.LIB.Model.CardModel;
import com.Lib.LIB.Repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceIMPL implements CardService {

    @Autowired
    private CardRepo cardRepository;

    @Override
    public void addCard(CardModel card) {
        cardRepository.save(card);
    }

    @Override
    public CardModel getCardById(int id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public List<CardModel> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void deleteCard(int id) {
        cardRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cardRepository.deleteAll();
    }

    @Override
    public void updateCardStatus(int cardId, boolean status) {
        CardModel card = cardRepository.findById(cardId).orElse(null);
        if (card != null) {
            card.setCardStatus(status);
            cardRepository.save(card);
        }
    }

    @Override
    public boolean cardExists(int id) {
        return cardRepository.existsById(id);
    }
}
