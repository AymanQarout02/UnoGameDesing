package Card;
import Cards.Enum.Color;
import Cards.FactoryClasses.Card;
import Cards.Strategy.EffectStrategy;
import Game.UnoGame;

public class DanceCard extends Card{

    public DanceCard(Color color, String effect, EffectStrategy effectStrategy) {
        this.color = color;
        this.effect = effect;
        this.effectStrategy = effectStrategy;
    }

    @Override
    public void makeEffect(UnoGame unoGame) {

    }
}
