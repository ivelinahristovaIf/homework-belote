package com.epam.belote;

import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

/**
 * The Sequence bonus is declared when the player has a sequence of three or more cards of the same suit, for example Jack, Queen and King of Spades
 */
public class Sequence implements Bonus {
    private final CardSuit suit;
    private final List<CardType> cards;

    public Sequence(CardSuit suit, List<CardType> cards) {
        this.suit = suit;
        this.cards = unmodifiableList(cards);
    }

    public CardSuit getSuit() {
        return suit;
    }

    public List<CardType> getCards() {
        return cards;
    }

    public int getBonus() {
        switch (cards.size()) {
            case 3:
                return 20;
            case 4:
                return 50;
            default:
                return 100;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sequence)) return false;
        Sequence sequence = (Sequence) o;
        return suit == sequence.suit &&
                Objects.equals(cards, sequence.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, cards);
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "suit=" + suit +
                ", cards=" + cards +
                '}';
    }
}
