package Card;

import Cards.Enum.Color;
import Cards.FactoryClasses.*;
import Cards.Enum.*;
import Cards.Strategy.*;
import Deck.BasicUnoDeck;
import Game.BasicUnoGame;
import Game.ChildhoodGame;
import Game.UnoGame;
import Ground.GameTable;
import Player.Player;

import java.util.Scanner;

public class DrawFourChildStrategy extends EffectStrategy {
    public void makeCardEffect(UnoGame unoGame) {
        if(unoGame instanceof BasicUnoGame basicUnoGame){

            GameTable table = GameTable.getInstance();

            Color color = changeColor();

            table.TopCard().setColor(color);
            System.out.println("Wild4 Card Played. The color has been changed to " + color);

            basicUnoGame.changeTurn();
            if (basicUnoGame.isClockwise) {
                basicUnoGame.currentPlayerIndex %= basicUnoGame.players.size();
            } else {
                basicUnoGame.currentPlayerIndex = (basicUnoGame.currentPlayerIndex < 0) ? basicUnoGame.players.size() - 1 : basicUnoGame.currentPlayerIndex;
            }
            Player player = basicUnoGame.players.get(basicUnoGame.currentPlayerIndex);

            for(Card card: player.getHand()) {
                if((card.getEffect().equals("DRAW_TWO")&&card.getColor().equals(table.TopCard().getColor())) || card.getEffect().equals("WILD_DRAW_FOUR")){
                    System.out.println("The player: " + player.getName() +"stop the effect of draw");
                    ChildhoodGame.cardToDraw+=4;
                    if (basicUnoGame.isClockwise) {
                        basicUnoGame.currentPlayerIndex--;
                    } else {
                        basicUnoGame.currentPlayerIndex++;
                    }
                    return;
                }
            }

            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());

            if(ChildhoodGame.cardToDraw!=0){
                for(int i =0;i<ChildhoodGame.cardToDraw;i++){
                    player.drawCard(BasicUnoDeck.getInstance().drawCard());
                }
                ChildhoodGame.cardToDraw =0;
            }



            System.out.println("The player: " + player.getName() +"Draw 4 cards and has been skipped");
        }
    }

    private Color changeColor() {
        GameTable table = GameTable.getInstance();
        System.out.println("Enter the color you need to change: ");

        ConsoleUtils.printColoredNumbers();

        Scanner input = new Scanner(System.in);
        int color = input.nextInt();

        return switch (color) {
            case 1 -> {
                table.TopCard().setColor(Color.RED);
                yield Color.RED;
            }
            case 2 -> {
                table.TopCard().setColor(Color.BLUE);
                yield Color.BLUE;
            }
            case 3 -> {
                table.TopCard().setColor(Color.GREEN);
                yield Color.GREEN;
            }
            case 4 -> {
                table.TopCard().setColor(Color.YELLOW);
                yield Color.YELLOW;
            }
            default -> Color.YELLOW;
        };

    }

}
