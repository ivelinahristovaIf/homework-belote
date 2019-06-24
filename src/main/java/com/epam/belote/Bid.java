package com.epam.belote;

import com.epam.belote.cards.CardSuit;

public enum Bid {
    PASS(null),
    CLUBS_TRUMP(CardSuit.CLUBS),
    DIAMONDS_TRUMP(CardSuit.DIAMONDS),
    HEARTS_TRUMP(CardSuit.HEARTS),
    SPADES_TRUMP(CardSuit.SPADES),
    NO_TRUMPS(null),
    ALL_TRUMPS(null);

    private CardSuit suit;
    private int strength;

    Bid(CardSuit suit) {

        this.suit = suit;
    }

    public CardSuit getSuit() {

        return this.suit;
    }

    public int getStrength() {

        return this.strength;
    }
}
