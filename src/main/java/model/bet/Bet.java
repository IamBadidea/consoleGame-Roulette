package model.bet;

import model.roulette.Roulette;

public class Bet {

  private final Roulette roulette;

  private final String value;

  public Bet(Roulette roulette, String value) {
    this.roulette = roulette;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public boolean isSector() {
    return roulette.isCorrectSector(value);
  }

  public boolean isColor() {
    return roulette.isCorrectColorSector(value);
  }

  public boolean isError() {
    return !isSector() && !isColor();
  }
}
