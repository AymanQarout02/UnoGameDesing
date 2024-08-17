package Cards.Strategy;

import Deck.BasicUnoDeck;
import Game.BasicUnoGame;
import Game.UnoGame;
import Player.Player;

import java.util.List;

public class DrawTwoStrategy extends EffectStrategy {

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

            player.drawCard(BasicUnoDeck.getInstance().drawCard());
            player.drawCard(BasicUnoDeck.getInstance().drawCard());

            System.out.println("Draw2 Card Played " + player.getName()  +" has drawn two cards. And skip his turn");

        }
    }



}
