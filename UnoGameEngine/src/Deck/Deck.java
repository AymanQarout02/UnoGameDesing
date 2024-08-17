package Deck;

import Cards.CreatorClasses.*;
import Cards.Enum.*;
import Cards.FactoryClasses.*;
import Cards.Strategy.*;
import java.util.Collections;
import java.util.Stack;

import Ground.GameTable;
import Ground.GameTable.*;

public abstract class Deck {

    protected Stack<Card> cards;

    Deck() {
        this.cards = new Stack<Card>();
        initializePile();
        shuffle();
    }


    protected abstract void initializePile();

    public abstract Card drawCard() ;

    public void shuffle() {
        Collections.shuffle(cards);
    }


    public void returnCardToDeck(Card card) {
        cards.addFirst(card);
    }

    public int getSize() {
        return cards.size();
    }

}
