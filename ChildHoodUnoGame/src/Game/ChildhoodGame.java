package Game;

import Cards.Enum.ConsoleUtils;
import Cards.FactoryClasses.Card;
import Deck.BasicUnoDeck;
import Deck.ChildhoodDeck;
import Ground.GameTable;
import Player.Bot;
import Player.Human;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChildhoodGame extends BasicUnoGame{

    //************************ DataFiled *******************************

    public static int cardToDraw = 0;
    List<String>winners = new ArrayList<>();

    public ChildhoodGame() {
        this.players = new ArrayList<>();
        this.drawDeck = ChildhoodDeck.getInstance();
        this.table = GameTable.getInstance();
    }

    //************************ SetupAbstractMethod *******************************
    @Override
    public void dealingCardsToPlayers() {

        System.out.print("Choose Number of dealing card: ");
        Scanner sc = new Scanner(System.in);
        int numberOfDealingCard = sc.nextInt();
        for (Player player : players) {
            System.out.println("deals cards for : " + player.getName() );
            for (int j = 0; j < numberOfDealingCard; j++) {
                player.drawCard(drawDeck.drawCard());
            }
        }
    }


    @Override
    public void printHelloMessage() {
        System.out.println("**************WELCOME TO Childhood UNO GAME**************");
        System.out.println("**************LET'S START FUN**************\n");
    }

    @Override
    public boolean isGameFinished() {

        if(players.size()==1) {
            winners.add(players.get(0).getName());
            return true;
        }
        for (Player player : players) {
            if (player.zeroCards()) {
                winners.add(player.getName());
                players.remove(player);
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

        if(currentPlayer.getSize()==1&&!currentPlayer.getUno()){
            currentPlayer.drawCard(drawDeck.drawCard());
            currentPlayer.drawCard(drawDeck.drawCard());
        }

        ConsoleUtils.printPlayerTurn(currentPlayer);
        currentPlayer.showCards();

        table.showTopCard();
    }
    @Override
    public void displayWinner() {
        int i =1;
        for (String winner : winners) {
            System.out.println("in place " + i + " " + winner);
            i++;
        }
    }

}
