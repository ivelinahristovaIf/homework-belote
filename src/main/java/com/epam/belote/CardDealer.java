package com.epam.belote;

public interface CardDealer {
    /**
     * The dealer initially deals 5 cards to each player and waits for the player to bid on trump. If all the player
     * pass then the games does not take place, hence {@link #deal3Cards()} must be never invoked
     */
    void deal5Cards();

    /**
     * After the player have agreed on on the trump the dealer deals 3 additional cards to each player
     */
    void deal3Cards();
}
