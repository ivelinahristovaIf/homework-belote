package com.epam.belote;

import com.epam.belote.cards.Card;

import java.util.Set;

public interface IQuad {
    Set<Bonus> declareBonus();

    Card playCard();

    Bid bid();

    Team getTeam();
}
