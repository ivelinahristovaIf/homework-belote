package com.epam.belote.cards;

import org.junit.Assert;
import org.junit.Test;

public class CardTests {

    @Test
    public void testPointsJackTrump() {
        Card card = new Card(CardType.JACK, CardSuit.CLUBS);
        Assert.assertEquals(20, card.calculatePoints(CardSuit.CLUBS));
    }

    @Test
    public void testPointsJackNotTrump() {
        Card card = new Card(CardType.JACK, CardSuit.CLUBS);
        Assert.assertEquals(2, card.calculatePoints(CardSuit.DIAMONDS));
    }

    @Test
    public void testPointsTen() {
        Card card = new Card(CardType.TEN, CardSuit.SPADES);
        Assert.assertEquals(10, card.calculatePoints(CardSuit.SPADES));
        Assert.assertEquals(10, card.calculatePoints(CardSuit.HEARTS));
    }

    @Test
    public void testPointsNineTrump() {
        Card card = new Card(CardType.NINE, CardSuit.SPADES);
        Assert.assertEquals(14, card.calculatePoints(CardSuit.SPADES));
    }

    @Test
    public void testPointsNineNotTrump() {
        Card card = new Card(CardType.NINE, CardSuit.SPADES);
        Assert.assertEquals(0, card.calculatePoints(CardSuit.DIAMONDS));
    }

    @Test
    public void testPointsQueen() {
        Card card = new Card(CardType.QUEEN, CardSuit.SPADES);
        Assert.assertEquals(3, card.calculatePoints(CardSuit.SPADES));
        Assert.assertEquals(3, card.calculatePoints(CardSuit.HEARTS));
    }

    @Test
    public void testPointsKing(){
        Card card =  new Card(CardType.KING,CardSuit.SPADES);
        Assert.assertEquals(4,card.calculatePoints(CardSuit.SPADES));
        Assert.assertEquals(4,card.calculatePoints(CardSuit.HEARTS));
    }

    @Test
    public void testPointsAce(){
        Card card =  new Card(CardType.ACE,CardSuit.SPADES);
        Assert.assertEquals(11,card.calculatePoints(CardSuit.SPADES));
        Assert.assertEquals(11,card.calculatePoints(CardSuit.HEARTS));
    }
    @Test
    public void testSevenAndEightPoints(){
        Card cardSeven =  new Card(CardType.SEVEN,CardSuit.SPADES);
        Card cardEight = new Card(CardType.EIGHT,CardSuit.SPADES);
        Assert.assertEquals(0,cardSeven.calculatePoints(CardSuit.SPADES));
        Assert.assertEquals(0,cardSeven.calculatePoints(CardSuit.DIAMONDS));
        Assert.assertEquals(0,cardEight.calculatePoints(CardSuit.HEARTS));
        Assert.assertEquals(0,cardEight.calculatePoints(CardSuit.SPADES));
    }
}
