package Cards.CreatorClasses;

import Cards.FactoryClasses.Card;
import Cards.Enum.Color;
import Cards.FactoryClasses.NumberCard;
import Cards.Strategy.EffectStrategy;

public class NumberedCardCreator extends CardCreator {

    public Card createCard(Color color, String effect, EffectStrategy effectStrategy) {
        return new NumberCard(color,effect, effectStrategy);
    }
}
