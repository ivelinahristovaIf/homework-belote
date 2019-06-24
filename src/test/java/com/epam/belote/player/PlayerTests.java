package com.epam.belote.player;

import com.epam.belote.*;

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

public class PlayerTests {

    Player player;
    Team firstTeam;

    @Before
    public void setup() {
        this.firstTeam = new Team("Team 1");
        this.player = new Player("Player 1", firstTeam);
    }

    @Test
    public void testReceiving5Cards() {
        List<Card> cards = new LinkedList<>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.DIAMONDS),
                        new Card(CardType.SEVEN, CardSuit.CLUBS)
                ));

        player.addCards(cards);
        for (Card card : cards
        ) {
            Assert.assertTrue(player.getPlayerCards().contains(card));
        }
    }

    @Test
    public void testReceiving3Cards() {
        List<Card> cards = new LinkedList<>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS)
                ));

        player.addCards(cards);
        for (Card card : cards
        ) {
            Assert.assertTrue(player.getPlayerCards().contains(card));
        }
    }

    @Test
    public void testDeclaringSequence() {
        Bonus sequence = new Sequence(CardSuit.SPADES, Arrays.asList(
                CardType.TEN,
                CardType.JACK,
                CardType.QUEEN,
                CardType.KING
        ));

        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.CLUBS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.KING, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertTrue(player.returnSequences().contains(sequence));
    }

    @Test
    public void testDeclaringQuad() {
        Bonus result = new Quad(CardType.QUEEN);

        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.QUEEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertTrue(player.returnQuads().contains(result));
    }


    @Test
    public void testDeclaringSequenceAndQuad() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.ACE, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.QUEEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(2, player.declareBonus().size());
    }

    @Test
    public void testDeclaringNoBonus() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.EIGHT, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.SEVEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(0, player.declareBonus().size());
    }

    @Test
    public void testCalculatingBonusPoints() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.NINE, CardSuit.HEARTS),
                        new Card(CardType.NINE, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.CLUBS),
                        new Card(CardType.QUEEN, CardSuit.CLUBS),
                        new Card(CardType.NINE, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.CLUBS),
                        new Card(CardType.NINE, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(150 + 50, player.calculateBonusPoints());
    }

    @Test
    public void testCalculatingBonusPointsTierceAndQuinte() {
        List<Card> cards = new LinkedList<Card>(
                Arrays.asList(
                        new Card(CardType.SEVEN, CardSuit.SPADES),
                        new Card(CardType.EIGHT, CardSuit.DIAMONDS),
                        new Card(CardType.EIGHT, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.NINE, CardSuit.DIAMONDS),
                        new Card(CardType.NINE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.SPADES)));

        player.addCards(cards);
        Assert.assertEquals(100 + 20, player.calculateBonusPoints());
    }

    @Test
    public void testCalculatingBonusPointsQuinteAndQuad() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.CLUBS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.SPADES),
                        new Card(CardType.ACE, CardSuit.SPADES)));

        player.addCards(cards);
        Assert.assertEquals(100+100, player.calculateBonusPoints());
    }

    @Test
    public void testCalculatingBonusPointsSequenceTest() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.NINE, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(20, player.calculateBonusPoints());
    }



    @Test
    public void testPlayerHasNoCardsThrowingException() {
        boolean thrown = false;

        try {
            player.playCard();
        } catch (IllegalStateException e) {
            thrown = true;
        }

        Assert.assertTrue(thrown);
    }

    @Test
    public void testReturningCardsInDeck() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        player.returnCardsInDeck();
        Assert.assertTrue(player.getPlayerCards().isEmpty());
    }

}
