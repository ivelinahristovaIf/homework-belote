package com.epam.belote.player;

import com.epam.belote.Bid;
import com.epam.belote.Team;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TeamTests {

    private Team team;

    @Before
    public void setUp() {
        this.team = new Team("Team 1");
    }

    @Test
    public void testingScoreDownAllTrumps() {
        Assert.assertEquals(12, Team.roundScore(124, Bid.ALL_TRUMPS));
    }

    @Test
    public void testingScoreDownNoTrumpsTest() {
        Assert.assertEquals(12, Team.roundScore(125, Bid.NO_TRUMPS));
    }

    @Test
    public void testingScoreUpAllTrumpsTest() {
        Assert.assertEquals(13, Team.roundScore(125, Bid.ALL_TRUMPS));
    }

    @Test
    public void testingScoreUpNoTrumpsTest() {
        Assert.assertEquals(13, Team.roundScore(126, Bid.NO_TRUMPS));
    }

    @Test
    public void testingScoreDownClubsTrumpsTest() {
        Assert.assertEquals(12, Team.roundScore(126, Bid.CLUBS_TRUMP));
    }

    @Test
    public void testingScoreUpClubsTrumpsTest() {
        Assert.assertEquals(13, Team.roundScore(127, Bid.CLUBS_TRUMP));
    }

    @Test
    public void testingCalculationAllTrumpsScore() {
        List<Card> cards = new LinkedList<>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        Assert.assertEquals(34, team.calculateScore(Bid.ALL_TRUMPS));
    }

    @Test
    public void testingCalculationNoTrumpsScore() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        Assert.assertEquals(16, team.calculateScore(Bid.NO_TRUMPS));
    }

    @Test
    public void testingCalculationClubsTrumpScore() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        Assert.assertEquals(34, team.calculateScore(Bid.CLUBS_TRUMP));
    }

    @Test
    public void testingAddScore() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        team.addScore(Bid.CLUBS_TRUMP);
        Assert.assertEquals(3, team.getScore());
    }

    @Test
    public void testingSddScoreNoTrumps() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        team.addScore(Bid.NO_TRUMPS);
        Assert.assertEquals(2, team.getScore());
    }

}
