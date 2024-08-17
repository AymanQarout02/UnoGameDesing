package Card;

import Cards.CreatorClasses.CardCreator;
import Cards.Enum.Color;
import Cards.FactoryClasses.Card;
import Cards.Strategy.EffectStrategy;

public class DanceCreator extends CardCreator {

    @Override
    public Card createCard(Color color, String effect, EffectStrategy effectStrategy) {
        return new DanceCard(color,effect,effectStrategy);
    }
}
