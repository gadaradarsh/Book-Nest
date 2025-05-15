package com.Lib.LIB.Service;

import com.Lib.LIB.Model.CardModel;
import java.util.List;

public interface CardService {
    void addCard(CardModel card);
    CardModel getCardById(int id);
    List<CardModel> getAllCards();
    void deleteCard(int id);
    void deleteAll();
    void updateCardStatus(int cardId, boolean status);
    boolean cardExists(int id);
}
