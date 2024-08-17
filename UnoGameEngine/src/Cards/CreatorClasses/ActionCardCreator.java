package Cards.CreatorClasses;

import Cards.FactoryClasses.Card;
import Cards.Enum.Color;
import Cards.FactoryClasses.ActionCard;
import Cards.Strategy.EffectStrategy;

public class ActionCardCreator extends CardCreator {

    public Card createCard(Color color, String effect, EffectStrategy effectStrategy) {
        return new ActionCard(color,effect,effectStrategy);
    }


}
