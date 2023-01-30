package model;

import model.bet.Bet;
import model.roulette.Roulette;

public class Win {

  private Win() {
  }

  public static boolean check(Roulette roulette, String winSector, Bet selectedBet) {
    if (selectedBet.isColor()) {
      String winSectorColor = roulette.getColorSector(winSector);
      return selectedBet.getValue().equals(winSectorColor);
    }
    if (selectedBet.isSector()) {
      return selectedBet.getValue().equals(winSector);
    }
    throw new IllegalArgumentException("Illegal bet value: " + selectedBet.getValue());
  }
}
