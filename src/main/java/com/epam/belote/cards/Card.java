package com.epam.belote.cards;

import java.util.Objects;

public class Card {
    private final CardType type;
    private final CardSuit suit;

    public Card(CardType type, CardSuit suit) {
        this.type = type;
        this.suit = suit;
    }

    public CardType getType() {
        return type;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int calculatePoints(CardSuit trump){
        if(this.type==CardType.JACK){
            if(this.suit == trump){
                return 20;
            }else{
                return 2;
            }
        }
        if(this.type==CardType.NINE && this.suit==trump){
            return 14;
        }
        if(this.type==CardType.ACE){
            return 11;
        }
        if(this.type==CardType.ACE){
            return 10;
        }
        if ( this.type == CardType.TEN) {
            return 10;
        }
        if ( this.type == CardType.KING) {
            return 4;
        }
        if ( this.type == CardType.QUEEN) {
            return 3;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return type == card.type &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", suit=" + suit +
                '}';
    }
}
