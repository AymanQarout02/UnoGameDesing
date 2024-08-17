import Cards.CreatorClasses.ActionCardCreator;
import Cards.CreatorClasses.CardCreator;
import Cards.CreatorClasses.NumberedCardCreator;
import Cards.CreatorClasses.WildCardCreator;
import Cards.Enum.Color;
import Cards.FactoryClasses.Card;
import Cards.Strategy.*;
import Deck.*;
import Ground.GameTable;
import Card.*;

public class NewCardUnoDeck extends Deck{

    private static NewCardUnoDeck instance;

    private NewCardUnoDeck() {
        super();
    }


    public static synchronized NewCardUnoDeck getInstance() {
        if (instance == null) {
            instance = new NewCardUnoDeck();
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
                for (int i = 1; i <= 10; i++) {
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
                    cards.add(actionCreator.createCard(color, "DRAW_TWO",new DrawTwoStrategy()));
                    cards.add(actionCreator.createCard(color, "DRAW_THREE",new DrawThreeStarategy()));

                }
            }
        }

        CardCreator wildCreator = new WildCardCreator();
        for (int i = 0; i < 4; i++) {
            cards.add(wildCreator.createCard(Color.WILD, "WILD",new ChangeColorStrategy()));
            cards.add(wildCreator.createCard(Color.WILD, "WILD_DRAW_FOUR",new DrawFourStrategy()));
            cards.add(wildCreator.createCard(Color.WILD, "SHOW_CARD",new ShowCardsStrategy()));

        }

        CardCreator danceCreator = new DanceCreator();
        for (int i = 0; i < 4; i++) {
            cards.add(danceCreator.createCard(Color.WILD, "DanceMonkey",new DancStrategy()));

        }

    }


}
