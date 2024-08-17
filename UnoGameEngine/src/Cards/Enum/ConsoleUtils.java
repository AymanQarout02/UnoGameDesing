package Cards.Enum;
import Cards.FactoryClasses.Card;
import Player.Player;

public class ConsoleUtils {
    // ANSI escape codes for colors
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";

    public static final String RED_BACKGROUND = "\033[41m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String BLUE_BACKGROUND = "\033[44m";

    public static void printPlayerTurn(Player player) {
        String background = getColorBackground(player.getId());
        String textColor = "\033[30m"; // Black text color for visibility

        String header = " " + player.getName()+ player.getId() + "'s turn ";
        System.out.println(background + textColor + "___________________" + RESET);
        System.out.println(background + textColor + "|" + repeatSpace((19 - header.length()) / 2) + header + repeatSpace((19 - header.length() + 1) / 2) + "|" + RESET);
        System.out.println(background + textColor + "|" + repeatSpace(19) + "|" + RESET);
        System.out.println(background + textColor + "-------------------" + RESET);
    }

    private static String getColorBackground(int playerNumber) {
        switch (playerNumber % 4) { // Cycle through 4 colors
            case 0: return RED_BACKGROUND;
            case 1: return GREEN_BACKGROUND;
            case 2: return YELLOW_BACKGROUND;
            case 3: return BLUE_BACKGROUND;
            default: return RESET; // Fallback
        }
    }

    private static String repeatSpace(int count) {
        return new String(new char[count]).replace("\0", " ");
    }
    public static void printCardBox(Card card) {
        String value = " " + card.getEffect() + " ";

        System.out.println("|----------------|");
        System.out.println("|                |");
        System.out.println("|" + value + "|");
        //System.out.println("|" + centerString(value, 16) + "|");  // Make sure centerString only pads the string
        System.out.println("|                |");
        System.out.println("------------------" + RESET);
    }

    public static void printTopCard(Card card) {
        String colorCode = getColorCode(card.getColor());
        String header = " TopCard ";
        System.out.println(colorCode + "________________");
        System.out.println("|" + centerString(header, 16) + "|");
        printCardBox(card);
    }

    public static String getColorCode(Color color) {
        switch (color) {
            case RED:
                return RED;
            case GREEN:
                return GREEN;
            case YELLOW:
                return YELLOW;
            case BLUE:
                return BLUE;
            default:
                return RESET; // Default color for BLACK or unknown colors
        }
    }
    private static String centerString(String text, int width) {
        int padSize = width - text.length();
        int padStart = text.length() + padSize / 2;

        text = String.format("%-" + padStart + "s", text);
        text = String.format("%-" + width  + "s", text);   // Ensures the string is padded to the desired width

        return text;
    }

    public static void printColoredNumbers() {
        System.out.println(RED + "1" + RESET);
        System.out.println(BLUE + "2" + RESET);
        System.out.println(GREEN + "3" + RESET);
        System.out.println(YELLOW + "4" + RESET);
    }
}
