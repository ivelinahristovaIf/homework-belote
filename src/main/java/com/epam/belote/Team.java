package com.epam.belote;

import com.epam.belote.cards.Card;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Team {
    public static final int WINNING_SCORE = 151;
    public static final int NO_TRUMPS_SCORE = 5;
    public static final int ALL_TRUMPS_SCORE = 4;
    public static final int DEFAULT_SCORE = 6;

    private String name;
    private Player firstPlayer;
    private Player secondPlayer;
    private int score;
    private List<Card> takenCards;

    public Team(String name) {
        this.name = name;
        this.score = 0;
        this.firstPlayer = new Player(this.name + " - first player", this);
        this.secondPlayer = new Player(this.name + " - second player", this);
        this.takenCards = new LinkedList<>();
    }

    public static int roundScore(int score, Bid bid) {
        int number = 0;
        switch (bid) {
            case NO_TRUMPS:
                number = NO_TRUMPS_SCORE;
                break;
            case ALL_TRUMPS:
                number = ALL_TRUMPS_SCORE;
                break;
            default:
                number = DEFAULT_SCORE;
        }

        if (score % 10 > number) {
            return score / 10 + 1;
        }
        return score / 10;
    }

    public int calculateScore(Bid bid) {
        int currentRoundScore = 0;
        for (Card card : takenCards) {
            if (bid.equals(Bid.ALL_TRUMPS)) {
                currentRoundScore += card.calculatePoints(card.getSuit());
            } else {
                currentRoundScore += card.calculatePoints(bid.getSuit());
            }
        }
        return currentRoundScore;
    }

    public void addScore(Bid bid) {
        this.score += roundScore(calculateScore(bid), bid);
    }

    public void takeCards(List<Card> cards) {
        this.takenCards.addAll(cards);
    }

    public int getScore() {
        return score;
    }

    public boolean hasWON() {
        return this.score > WINNING_SCORE;
    }

    public Player getFirstPlayer() {
        return this.firstPlayer;
    }

    public Player getSecondPlayer() {
        return this.secondPlayer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(firstPlayer, team.firstPlayer) &&
                Objects.equals(secondPlayer, team.secondPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstPlayer, secondPlayer);
    }


}
