package Cards.CreatorClasses;

import Cards.FactoryClasses.Card;
import Cards.Enum.Color;
import Cards.FactoryClasses.WildCard;
import Cards.Strategy.EffectStrategy;

public class WildCardCreator extends CardCreator {

    public Card createCard(Color color, String effect, EffectStrategy effectStrategy) {
        return new WildCard(color,effect, effectStrategy);
    }

}
