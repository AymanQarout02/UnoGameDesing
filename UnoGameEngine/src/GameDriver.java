import Game.BasicUnoGame;
import Game.UnoGame;

public class GameDriver {
    public static void main(String[] args) {

        UnoGame basicUnoGame = new BasicUnoGame();

        basicUnoGame.play(basicUnoGame);

    }
}