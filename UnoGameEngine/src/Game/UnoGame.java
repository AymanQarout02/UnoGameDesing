package Game;


import Cards.FactoryClasses.Card;
import Deck.Deck;
import Ground.GameTable;
import Player.Player;

import java.util.List;
import java.util.Scanner;

public abstract class UnoGame {

    public List<Player> players;
    public Deck drawDeck ;
    public GameTable table ;
    public int currentPlayerIndex = 0;
    public boolean isClockwise = true;

    public abstract void initializePlayer();

    public abstract void shuffle();

    public abstract void dealingCardsToPlayers();

    public abstract void setFirstCardOnTable();

    public final void setupGame(){

        initializePlayer();

        shuffle();

        dealingCardsToPlayers();

        setFirstCardOnTable();

    }


    public abstract void printHelloMessage();

    public abstract boolean isGameFinished();

    public abstract void currentPlayerTurn();

    public abstract void playerComment();

    public abstract Card playCard();

    public abstract void changeTurn();

    public abstract boolean haveMatches();

    public abstract void displayWinner();

    public abstract void drawFromDeck();

    public final void play(UnoGame unoGame){

        setupGame();

        printHelloMessage();

        while (!isGameFinished()) {
            currentPlayerTurn();

            playerComment();

            if(haveMatches())
                playCard().makeEffect(unoGame);
            else
                System.out.println("No match card to play \nnext turn ..");

            changeTurn();
        }
        displayWinner();
    }
}

