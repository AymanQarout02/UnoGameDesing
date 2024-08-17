package Cards.Strategy;

import Cards.Enum.Color;
import Cards.Enum.ConsoleUtils;
import Deck.BasicUnoDeck;
import Game.BasicUnoGame;
import Game.UnoGame;
import Ground.GameTable;
import Player.Player;

import java.util.Scanner;

public class DrawFourStrategy extends EffectStrategy {

    @Override
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


            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());

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
