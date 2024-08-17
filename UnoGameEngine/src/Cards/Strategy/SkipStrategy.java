package Cards.Strategy;

import Game.BasicUnoGame;
import Game.UnoGame;
import Player.Player;

public class SkipStrategy extends EffectStrategy {

    @Override
    public void makeCardEffect(UnoGame unoGame) {
        if(unoGame instanceof BasicUnoGame basicUnoGame){
            basicUnoGame.changeTurn();
            if (basicUnoGame.isClockwise) {
                basicUnoGame.currentPlayerIndex %= basicUnoGame.players.size();
            } else {
                basicUnoGame.currentPlayerIndex = (basicUnoGame.currentPlayerIndex < 0) ? basicUnoGame.players.size() - 1 : basicUnoGame.currentPlayerIndex;
            }
            Player player = basicUnoGame.players.get(basicUnoGame.currentPlayerIndex);
            System.out.println("Skip Card Played " + player.getName() +" has been skipped");



           // String name = skipPlayerTurn(basicUnoGame);
           // System.out.println("Skip Card Played " + name +" has been skipped");
        }

    }

}
