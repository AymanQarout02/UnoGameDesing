package Cards.FactoryClasses;

import Cards.Enum.Color;
import Cards.Strategy.EffectStrategy;
import Game.BasicUnoGame;
import Game.UnoGame;

public abstract class Card implements Comparable<Card> {

 protected Color color;
 protected String effect;

 protected EffectStrategy effectStrategy;

 public abstract void makeEffect(UnoGame unoGame);

 public Color getColor() {
  return color;
 }

 public String getEffect() {
  return effect;
 }

 public void setColor(Color color) {
  this.color = color;
 }

 public void setEffect(String effect) {
  this.effect=effect;
 }


 public boolean matchColor(){

  return true;
 }

 @Override
 public boolean equals(Object obj) {

  if (obj == null) return false;
  if (!(obj instanceof Card)) return false;
  if (this == obj) return true;

  Card card = (Card) obj;

  if (this instanceof WildCard)
   return true;
  else
   return (card.getColor().equals(this.getColor()) || card.getEffect().equals(this.getEffect()));

 }

 @Override
 public String toString(){
  return color + " " + effect + "\n";
 }

 @Override
 public final int compareTo(Card other) {
  int colorComparison = this.getColor().ordinal() - other.getColor().ordinal();
  if (colorComparison == 0) {
   return this.getEffect().compareTo(other.getEffect());
  }
  return colorComparison;
 }

}
