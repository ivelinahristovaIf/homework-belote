package com.epam.belote.cards;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class CardsDeck {

    private List<Card> cards;

    public CardsDeck() {
        this.cards = new LinkedList<>();
        for (CardType cardType : CardType.values()) {
            for (CardSuit cardSuit : CardSuit.values()) {
                cards.add(new Card(cardType, cardSuit));
            }
        }
    }

    public Card takeCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public List<Card> takeNCards(int numberOfCards) {
        List<Card> pickedCards = new LinkedList<Card>();
        for (int count = 0; count < numberOfCards; count++) {
            pickedCards.add(cards.get(0));
            cards.remove(0);
        }
        return pickedCards;
    }

    public void giveCardsBack(List<Card> cards) {
        if (this.cards.size() + cards.size() <= 32) {
            this.cards.addAll(cards);
        } else {
            throw new IllegalArgumentException("Invalid number of cards1");
        }
    }

    public List<Card> getCards() {
        return unmodifiableList(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void split(int number) throws IllegalArgumentException {
        if (number < 0 || number > 32) {
            throw new IllegalArgumentException("Invalid number to split by!");
        }
        for (int count = 0; count < number; count++) {
            Card firstCard = cards.get(0);
            for (int cardNumber = 0; cardNumber < cards.size() - 1; cardNumber++) {
                cards.set(cardNumber, cards.get(cardNumber + 1));
            }
            cards.set(cards.size() - 1, firstCard);
        }
    }

}
