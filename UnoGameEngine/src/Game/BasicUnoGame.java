package Game;

import Cards.FactoryClasses.Card;
import Cards.Enum.ConsoleUtils;
import Comments.Comment;
import Player.*;
import Deck.*;
import Ground.GameTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicUnoGame extends UnoGame {


    //************************ DataFiled *******************************

    public BasicUnoGame() {
        this.players = new ArrayList<>();
        this.drawDeck = BasicUnoDeck.getInstance();
        this.table = GameTable.getInstance();
    }

    //************************ SetupAbstractMethod *******************************


    @Override
    public void initializePlayer() {
        System.out.println("How many real players would you like to play?");
        Scanner input = new Scanner(System.in);
        int numberOfPlayers = input.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter Name of Player " + (i+1) + ": ");
            players.add(new Human(input.next(),i+1));
        }

        System.out.println("How many bot players would you like to play?");
        int numberOfBots = input.nextInt();
        for (int i = 0; i < numberOfBots; i++) {
            players.add(new Bot("bot",i+1));
        }


    }

    @Override
    public void shuffle() {
        drawDeck.shuffle();
    }

    @Override
    public void dealingCardsToPlayers() {
        for (Player player : players) {
            System.out.println("deals cards for : " + player.getName() );
            final int numberOfDealingCard = 7;
            for (int j = 0; j < numberOfDealingCard; j++) {
                player.drawCard(drawDeck.drawCard());
            }
        }
    }

    @Override
    public void setFirstCardOnTable() {
        while(true){
            Card card = drawDeck.drawCard();
            if(table.canBeFirstCard(card)) {
                table.thrownCard(card);
                break;
            }else{
                drawDeck.returnCardToDeck(card);
            }
        }
    }

    //************************ PlayAbstractMethod *******************************


    @Override
    public void printHelloMessage() {
        System.out.println("**************WELCOME TO THE BASIC UNO GAME**************");
        System.out.println("**************LET'S START FUN**************\n");
    }

    @Override
    public boolean isGameFinished() {
        for (Player player : players) {
            if (player.zeroCards()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void currentPlayerTurn() {
        if (isClockwise) {
            currentPlayerIndex %= players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex < 0) ? players.size() - 1 : currentPlayerIndex;
        }

        Player currentPlayer = players.get(currentPlayerIndex);

        ConsoleUtils.printPlayerTurn(currentPlayer);
        currentPlayer.showCards();

        table.showTopCard();
    }

    public boolean playerHaveToDraw(Player player){
        return !haveMatches();
    }

    @Override
    public void playerComment() {
        Player currentPlayer = players.get(currentPlayerIndex);
        //        //playerComment(currentPlayer);
//
//        System.out.println("What you would to do:\n "
//        + "1) Draw card \n" +" 2) say UNO\n" +" 3) playCard\n"
//        );
//
//        Scanner input = new Scanner(System.in);
//        int choice = input.nextInt();
//
//        switch (choice) {
//            case 1:
//                if(playerHaveToDraw(currentPlayer)){
//                    drawFromDeck();
//                }else{
//                    System.out.println("You have matches you can't draw a card.");
//                }
//                break;
//
//            case 2:
//                if(currentPlayer.getSize()<=2){
//                    if(haveMatches()) {
//                        System.out.println(currentPlayer.getName() + " has one card left");
//                        currentPlayer.sayUNO();
//                    }else{
//                        System.out.println("You still have more than one card");
//                        drawFromDeck();
//                    }
//                }else{
//                    System.out.println("You still have more than one card");
//                    drawFromDeck();
//                }
//                break;
//            default:
//                if(!haveMatches()){
//                    System.out.println("You don't have a match. you have to draw a card");
//                    drawFromDeck();
//                }
//                break;
//        }
        currentPlayer.playerComment(this);

    }

    @Override
    public Card playCard() {
        Player currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer.playMatchCard();
       //        System.out.println("Choose card to play: ");
//        Scanner input = new Scanner(System.in);
//        int position = input.nextInt();
//
//        while(true) {
//            if (currentPlayer.getCardAtPosition(position).equals(table.TopCard())) {
//                table.thrownCard(currentPlayer.playCard(position));
//                break;
//            }else{
//                System.out.println("Not match card try again");
//                position = input.nextInt();
//            }
//        }
//        return table.TopCard();
    }


    @Override
    public void changeTurn() {
        if (isClockwise) {
            currentPlayerIndex++;
        } else {
            currentPlayerIndex--;
        }
    }

    @Override
    public boolean haveMatches() {
        Player currentPlayer = players.get(currentPlayerIndex);
        List<Card> hand = currentPlayer.getHand();
        for(Card card : hand){
            if(card.equals(table.TopCard())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayWinner() {

        for (Player player : players) {
            if (player.zeroCards()) {
                String goldColor = "\u001B[33m";
                String resetStyle = "\u001B[0m";
                System.out.println(goldColor + "🥇" + player.getName() + " wins!🥇" + resetStyle);
                break;
            }
        }

    }

    @Override
    public void drawFromDeck() {
        Player currentPlayer = players.get(currentPlayerIndex);

        Card drawnCard = drawDeck.drawCard();
        currentPlayer.drawCard(drawnCard);

        System.out.println("The card has been drawn is :");
        ConsoleUtils.printTopCard(drawnCard);

        currentPlayer.showCards();
        currentPlayer.notUnoAnyMore();
    }
}
