package model;

import model.roulette.Roulette;

public class Win {

  private Win() {
  }

  public static boolean check(String winSector, String colorSelectedSector) {

    String colorWinSector = Roulette.getColorSector(winSector);

    return colorWinSector.equals(colorSelectedSector);
  }
}
