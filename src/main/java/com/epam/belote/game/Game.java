package com.epam.belote.game;

import com.epam.belote.Bid;
import com.epam.belote.Player;
import com.epam.belote.Team;
import com.epam.belote.cards.CardsDeck;

import java.util.LinkedList;
import java.util.List;


public class Game implements IGame {
    private static Game instance = null;

    private Team firstTeam;
    private Team secondTeam;
    private final List<Player> playersPositions = new LinkedList<Player>();
    private CardsDeck deck;

    private Player playerFirstTaker;
    private Bid currentBid;


    private Game() {
        this.firstTeam = new Team("Team 1");
        this.secondTeam = new Team("Team 2");
        setPlayersPositions();
        this.deck = new CardsDeck();

        if (Math.random() > 0.5) {
            this.playerFirstTaker = firstTeam.getFirstPlayer();
        } else {
            this.playerFirstTaker = secondTeam.getFirstPlayer();
        }
        this.currentBid = Bid.PASS;
    }

    public static Game getInstance() {
        if (Game.instance == null) {
            Game.instance = new Game();
        }
        return Game.instance;
    }

    public void setPlayersPositions() {
        playersPositions.add(firstTeam.getFirstPlayer());
        playersPositions.add(secondTeam.getFirstPlayer());
        playersPositions.add(firstTeam.getSecondPlayer());
        playersPositions.add(secondTeam.getSecondPlayer());
    }

    public Player getNextPlayer(Player player) {
        if (playersPositions.indexOf(player) < 3) {
            return playersPositions.get(playersPositions.indexOf(player) + 1);
        } else {
            return playersPositions.get(0);
        }
    }

    private void dealNumberOfCards(int cardsNumber) {
        Player nextPlayer = playerFirstTaker;
        for (int playerCount = 0; playerCount < 4; playerCount++) {
            nextPlayer.addCards(deck.takeNCards(cardsNumber));
            nextPlayer = getNextPlayer(playerFirstTaker);
        }
    }

    public CardsDeck getDeck() {
        return deck;
    }

    @Override
    public void deal5Cards() {
        dealNumberOfCards(3);
        dealNumberOfCards(2);
    }

    @Override
    public void deal3Cards() {
        if (!currentBid.equals(Bid.PASS)) {
            dealNumberOfCards(3);
        }
    }

}
