package Deck;

import Card.*;
import Cards.CreatorClasses.ActionCardCreator;
import Cards.CreatorClasses.CardCreator;
import Cards.CreatorClasses.NumberedCardCreator;
import Cards.CreatorClasses.WildCardCreator;
import Cards.Enum.Color;
import Cards.FactoryClasses.Card;
import Cards.Strategy.*;
import Ground.GameTable;

public class ChildhoodDeck extends Deck {

    private static ChildhoodDeck instance;

    private ChildhoodDeck() {
        super();
    }

    public static synchronized ChildhoodDeck getInstance() {
        if (instance == null) {
            instance = new ChildhoodDeck();
        }
        return instance;
    }

    @Override
    public Card drawCard() {
        if (cards.isEmpty()) {
            getInstance().cards = GameTable.returnDeck();
        }
        return cards.pop();
    }

    @Override
    protected void initializePile() {
        CardCreator numberCreator = new NumberedCardCreator();
        for (Color color : Color.values()) {
            if (color != Color.WILD) {
                cards.add(numberCreator.createCard(color,Integer.toString(0),new NumberStrategy()));
                for (int i = 1; i <= 9; i++) {
                    cards.add(numberCreator.createCard(color,Integer.toString(i),new NumberStrategy()));
                    cards.add(numberCreator.createCard(color,Integer.toString(i),new NumberStrategy()));
                }
            }
        }

        CardCreator actionCreator = new ActionCardCreator();
        for (Color color : Color.values()) {
            if (color != Color.WILD) {
                for (int i = 0; i < 2; i++) {
                    cards.add(actionCreator.createCard(color, "SKIP",new SkipStrategy()));
                    cards.add(actionCreator.createCard(color, "REVERSE",new ReverseStrategy()));
                    cards.add(actionCreator.createCard(color, "DRAW_TWO",new DrawTwoChildStrategy()));
                }
            }
        }

        CardCreator wildCreator = new WildCardCreator();
        for (int i = 0; i < 4; i++) {
            cards.add(wildCreator.createCard(Color.WILD, "WILD",new ChangeColorStrategy()));
            cards.add(wildCreator.createCard(Color.WILD, "WILD_DRAW_FOUR",new DrawFourChildStrategy()));
        }

    }

}
