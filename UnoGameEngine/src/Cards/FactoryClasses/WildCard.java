package Cards.FactoryClasses;

import Cards.Enum.Color;
import Cards.Strategy.*;
import Game.BasicUnoGame;
import Game.UnoGame;

public class WildCard extends Card {


    public WildCard(Color color , String effect, EffectStrategy effectStrategy) {
        this.color = color;
        this.effect = effect;
        this.effectStrategy = effectStrategy;
    }

    @Override
    public void makeEffect(UnoGame unoGame) {

        effectStrategy.makeCardEffect(unoGame);

    }
}
