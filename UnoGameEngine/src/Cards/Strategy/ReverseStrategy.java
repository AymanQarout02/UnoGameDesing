package Cards.Strategy;

import Game.BasicUnoGame;
import Game.UnoGame;

public class ReverseStrategy  extends EffectStrategy {

    @Override
    public void makeCardEffect(UnoGame unoGame) {
        if(unoGame instanceof BasicUnoGame basicUnoGame){
            basicUnoGame.isClockwise=!basicUnoGame.isClockwise;
            System.out.println("Reverse Card Played");
        }
    }
}
