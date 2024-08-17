package Ground;

import Cards.FactoryClasses.Card;
import Cards.Enum.ConsoleUtils;
import Cards.FactoryClasses.NumberCard;

import java.util.Stack;

public class GameTable {

    private static GameTable instance;

    private Stack<Card> table;

    public static synchronized GameTable getInstance() {
        if (instance == null) {
            instance = new GameTable();
        }
        return instance;
    }
    private GameTable() {
        this.table = new Stack<Card>();
    }

    public Card TopCard(){
        return table.peek();
    }

    public void thrownCard(Card card){
        table.push(card);
    }



    public int getSize() {
        return table.size();
    }

    public boolean canBeFirstCard(Card card){
        return card instanceof NumberCard;
    }

    public void showTopCard(){
        System.out.println("The Current Card In Table Is: ");
        ConsoleUtils.printTopCard(table.peek());
    }

    public static Stack<Card> returnDeck() {
        Stack<Card> copiedStack = new Stack<>();
        copiedStack.addAll(getInstance().table);

        Card card = getInstance().TopCard();
        getInstance().table.clear();
        getInstance().table.add(card);

        return copiedStack;
    }


}
