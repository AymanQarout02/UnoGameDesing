package Cards.Strategy;

import Cards.Enum.Color;
import Cards.Enum.ConsoleUtils;
import Game.UnoGame;
import Ground.GameTable;

import java.util.Scanner;

public class ChangeColorStrategy extends EffectStrategy {

    @Override
    public void makeCardEffect(UnoGame unoGame) {
        GameTable table = GameTable.getInstance();
        Color color = changeColor();

        table.TopCard().setColor(color);
        System.out.println("Wild Card Played. The color has been changed to " + color);
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
