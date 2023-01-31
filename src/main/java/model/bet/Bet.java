package model.bet;

import model.roulette.Roulette;

public abstract class Bet {

  private final String value;

  public Bet(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
