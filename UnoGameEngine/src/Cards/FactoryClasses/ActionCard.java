package Cards.FactoryClasses;

import Cards.Enum.Color;
import Cards.Strategy.DrawTwoStrategy;
import Cards.Strategy.EffectStrategy;
import Cards.Strategy.ReverseStrategy;
import Cards.Strategy.SkipStrategy;
import Game.BasicUnoGame;
import Game.UnoGame;

public class ActionCard extends Card {


    public ActionCard(Color color, String effect, EffectStrategy effectStrategy) {
        this.color = color;
        this.effect = effect;
        this.effectStrategy = effectStrategy;
    }


    @Override
    public void makeEffect(UnoGame unoGame) {

            effectStrategy.makeCardEffect(unoGame);

    }

}

