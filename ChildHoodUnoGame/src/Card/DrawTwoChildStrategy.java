package Card;
import Ground.GameTable;

import Cards.FactoryClasses.Card;
import Cards.Strategy.EffectStrategy;
import Deck.BasicUnoDeck;
import Game.BasicUnoGame;
import Game.ChildhoodGame;
import Game.UnoGame;
import Player.Player;

public class DrawTwoChildStrategy extends EffectStrategy {
    @Override
    public void makeCardEffect(UnoGame unoGame) {

        if(unoGame instanceof BasicUnoGame basicUnoGame){
            GameTable table = GameTable.getInstance();

            basicUnoGame.changeTurn();
            if (basicUnoGame.isClockwise) {
                basicUnoGame.currentPlayerIndex %= basicUnoGame.players.size();
            } else {
                basicUnoGame.currentPlayerIndex = (basicUnoGame.currentPlayerIndex < 0) ? basicUnoGame.players.size() - 1 : basicUnoGame.currentPlayerIndex;
            }

            Player player = basicUnoGame.players.get(basicUnoGame.currentPlayerIndex);


            for(Card card: player.getHand()) {
                if((card.getEffect().equals("DRAW_TWO") || card.getEffect().equals("WILD_DRAW_FOUR"))){
                    System.out.println("The player: " + player.getName() +"stop the effect of draw");
                    ChildhoodGame.cardToDraw+=2;
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

            if(ChildhoodGame.cardToDraw!=0){
                for(int i =0;i<ChildhoodGame.cardToDraw;i++){
                    player.drawCard(BasicUnoDeck.getInstance().drawCard());
                }
                ChildhoodGame.cardToDraw =0;
            }
            System.out.println("Draw2 Card Played " + player.getName()  +" has drawn two cards. And skip his turn");

        }
    }
}
