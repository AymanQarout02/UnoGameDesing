package Cards.FactoryClasses;

import Cards.Enum.Color;
import Cards.Strategy.EffectStrategy;
import Game.BasicUnoGame;
import Game.UnoGame;

public class NumberCard extends Card {

    public NumberCard(Color color, String effect, EffectStrategy effectStrategy) {
        this.color = color;
        this.effect = effect;
        this.effectStrategy = effectStrategy;
    }

    @Override
    public void makeEffect(UnoGame unoGame) {

    }
}
