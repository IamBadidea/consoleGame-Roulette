package model;

import model.roulette.Roulette;

public class Win {

  private Win() {
  }

  public static boolean check(Roulette roulette, String winSector, String selectedBet) {
    return roulette.getColorSector(winSector).equals(selectedBet) || winSector.equals(
        selectedBet);
  }
}
