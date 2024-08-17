package Player;

import Cards.FactoryClasses.Card;
import Cards.Enum.ConsoleUtils;
import Comments.Comment;
import Game.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Player {

    protected String name;
    protected int id;
    protected List<Card> hand;
    protected boolean UNO;

    protected Comment comment;

    // ************* getter and setter ****************

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getSize(){
        return hand.size();
    }

    public List<Card> getHand(){
        return new ArrayList<>(hand);
    }

    public boolean getUno(){
        return UNO;
    }

    // ************* method ****************

    private String centerString(String text, int width) {
        int padSize = width - text.length();
        int padStart = text.length() + padSize / 2;

        text = String.format("%-" + padStart + "s", text);
        text = String.format("%-" + width + "s", text);   // Ensures the string is padded to the desired width

        return text;
    }
    public void showCards(){
        StringBuilder header = new StringBuilder();
        StringBuilder top = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        int cardPosition = 0; // Start position numbering at 1
        for (Card card : hand) {
            String colorCode = ConsoleUtils.getColorCode(card.getColor());
            String reset = ConsoleUtils.RESET;

            // Constructing the card display with color
            header.append(String.format("%s|%2d       %s", colorCode, cardPosition++, reset));
            top.append(colorCode).append("|---------").append(reset);
            middle.append(colorCode).append("|").append(centerString(" " + card.getEffect() + " ", 9)).append(reset);
            bottom.append(colorCode).append("|---------").append(reset);
        }

        // Print all parts
        System.out.println(header);
        System.out.println(top);
        System.out.println(middle);
        System.out.println(bottom);



//        for(Card card : hand){
//            System.out.print(card.color+" | ");
//        }
//        System.out.println();
//        for(Card card : hand){
//            System.out.print(card.value+" | ");
//        }
//        System.out.println();
    }



    public Card deiscardCard(int cardPosition) {
        return hand.remove(cardPosition);
    }

    public Card getCardAtPosition(int position){
        return hand.get(position);
    }

    public boolean zeroCards(){
        return hand.isEmpty();
    }

    public void sayUNO(){
        UNO = true;
    }

    public void notUnoAnyMore(){
        UNO = false;
    }

    public void drawCard(Card card) {
        hand.add(card);
        Collections.sort(hand);
    }

    // ************* Override ****************

    @Override
    public String toString(){
        return name + " " + id;
    }

    public abstract void playerComment(UnoGame game);

    public abstract Card playMatchCard();


}
