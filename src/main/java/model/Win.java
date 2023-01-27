package model;

import model.roulette.Roulette;

public class Win {

  private Win() {
  }

  public static boolean check(String winSector, String selectedSector) {
    return winSector.equals(selectedSector);
  }
}
