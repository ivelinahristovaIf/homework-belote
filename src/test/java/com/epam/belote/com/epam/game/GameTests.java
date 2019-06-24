package com.epam.belote.com.epam.game;

import com.epam.belote.Player;
import com.epam.belote.Team;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import com.epam.belote.game.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameTests {

    Game game;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player thirdPlayer;
    private Player fourthPlayer;
    private Team firstTeam;
    private Team secondTeam;

    @Before
    public void setUp() {

        this.game = Game.getInstance();
        this.firstTeam = new Team("Team 1");
        this.firstPlayer = new Player("Player 1", firstTeam);
        this.secondPlayer = new Player("Player 2", firstTeam);
        this.thirdPlayer = new Player("Player 3", secondTeam);
        this.fourthPlayer = new Player("Player 4", secondTeam);
    }


    @Test
    public void testDealing5Card() {
        game.deal5Cards();

        Assert.assertEquals(32 - 4 * 5, game.getDeck().getCards().size());
    }


    @Test
    public void testFirstPlayerPlayingCard() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));
        firstPlayer.addCards(cards);
        Card card = firstPlayer.playCard();
        Assert.assertFalse(firstPlayer.getPlayerCards().contains(card));
    }

    @Test
    public void testSecondPlayerPlayingCard() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        secondPlayer.addCards(cards);
        Card card = secondPlayer.playCard();
        Assert.assertFalse(secondPlayer.getPlayerCards().contains(card));
    }

    @Test
    public void testThirdPlayerPlayingCard() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        thirdPlayer.addCards(cards);
        Card card = thirdPlayer.playCard();
        Assert.assertFalse(thirdPlayer.getPlayerCards().contains(card));
    }

    @Test
    public void testFourthPlayerPlayingCard() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        fourthPlayer.addCards(cards);
        Card card = fourthPlayer.playCard();
        Assert.assertFalse(fourthPlayer.getPlayerCards().contains(card));
    }

}
