import Game.BasicUnoGame;
import Ground.GameTable;

import java.util.ArrayList;

public class NewUnoCardGame extends BasicUnoGame {

    public NewUnoCardGame() {
        this.players = new ArrayList<>();
        this.drawDeck = NewCardUnoDeck.getInstance();
        this.table = GameTable.getInstance();
    }
}
