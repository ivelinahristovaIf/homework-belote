package com.epam.belote;

import com.epam.belote.cards.CardType;

import java.util.*;


/**
 * A Quad bonus is declared whenever the player has 4 cards of the same type, e.g. four Kings
 */
public class Quad implements Bonus {
    private final CardType cardType;

    public Quad(CardType cardType) {

        this.cardType = cardType;
    }

    public CardType getCardsType() {

        return cardType;
    }

    @Override
    public int getBonus() {
        switch (cardType){
            case NINE:
                return 150;
            case JACK:
                return 200;
                default:
                    return 100;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quad)) return false;
        Quad quad = (Quad) o;
        return cardType == quad.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType);
    }

}
