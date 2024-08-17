package Player;

import Cards.FactoryClasses.Card;
import Game.BasicUnoGame;
import Game.*;
import Ground.GameTable;

import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player {
    public Human(String name, int id) {
        hand = new ArrayList<>();
        this.name = name;
        this.id = id;
    }


    @Override
    public void playerComment(UnoGame game) {

        if(game instanceof BasicUnoGame basicUnoGame) {

            System.out.println("What you would to do:\n "
                    + "1) Draw card \n" +" 2) say UNO\n" +" 3) playCard\n"
            );

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    if(basicUnoGame.playerHaveToDraw(this)){
                        basicUnoGame.drawFromDeck();
                    }else{
                        System.out.println("You have matches you can't draw a card.");
                    }
                    break;

                case 2:
                    if(this.getSize()<=2){
                        if(basicUnoGame.haveMatches()) {
                            System.out.println(this.getName() + " has one card left");
                            this.sayUNO();
                        }else{
                            System.out.println("You still have more than one card");
                            basicUnoGame.drawFromDeck();
                        }
                    }else{
                        System.out.println("You still have more than one card");
                        basicUnoGame.drawFromDeck();
                    }
                    break;
                default:
                    if(!basicUnoGame.haveMatches()){
                        System.out.println("You don't have a match. you have to draw a card");
                        basicUnoGame.drawFromDeck();
                    }
                    break;
            }
        }

    }

    @Override
    public Card playMatchCard() {
        System.out.println("Choose card to play: ");
        Scanner input = new Scanner(System.in);
        int position = input.nextInt();

        while (true) {
            if (this.getCardAtPosition(position).equals(GameTable.getInstance().TopCard())) {
                GameTable.getInstance().thrownCard(this.deiscardCard(position));
                break;
            } else {
                System.out.println("Not match card try again");
                position = input.nextInt();
            }
        }
        return GameTable.getInstance().TopCard();

    }

}
