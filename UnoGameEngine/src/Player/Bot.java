package Player;

import Cards.Enum.Color;
import Cards.FactoryClasses.Card;
import Cards.FactoryClasses.NumberCard;
import Cards.Strategy.DrawFourStrategy;
import Game.*;
import Ground.GameTable;

import java.util.ArrayList;
import java.util.Scanner;

public class Bot extends Player {

    public Bot(String name, int id) {
        hand = new ArrayList<>();
        this.name = name;
        this.id = id;
    }

    @Override
    public void playerComment(UnoGame game) {
        if (game instanceof BasicUnoGame basicUnoGame) {
            if (basicUnoGame.playerHaveToDraw(this)) {
                basicUnoGame.drawFromDeck();
            } else if (this.getSize() <= 2) {
                System.out.println(this.getName() + " has one card left");
                this.sayUNO();
            }
        }
    }

    @Override
    public Card playMatchCard() {

        int i =0;
        for(Card card: this.getHand()){
            if(card.equals(GameTable.getInstance().TopCard())){
                GameTable.getInstance().thrownCard(this.deiscardCard(i));
                break;
            }
            i++;
        }
        return  GameTable.getInstance().TopCard();
    }

}
