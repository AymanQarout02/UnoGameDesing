package Cards.CreatorClasses;

import Cards.FactoryClasses.Card;
import Cards.Enum.Color;
import Cards.Strategy.EffectStrategy;

public abstract class CardCreator {
    public abstract Card createCard(Color color, String effect, EffectStrategy effectStrategy);

}
