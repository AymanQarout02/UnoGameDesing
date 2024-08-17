import Game.ChildhoodGame;
import Game.UnoGame;

public class Main {
    public static void main(String[] args) {

        UnoGame game = new ChildhoodGame();
        game.play(game);
    }
}