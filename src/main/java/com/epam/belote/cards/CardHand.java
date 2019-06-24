package com.epam.belote.cards;

import com.epam.belote.Player;

import java.util.Map;
import java.util.TreeMap;

public class CardHand {
    private Map<Card, Player> hand;
    private CardSuit trump;

    CardHand(Map<Card, Player> hand, CardSuit trump) {
        this.hand = new TreeMap<>(new CardComparator());
        this.hand = hand;
        this.trump = trump;
    }

    public void takeHand() {

        Player p = hand.entrySet().stream().sorted().findFirst().get().getValue();
        System.out.println(p);
    }
}
