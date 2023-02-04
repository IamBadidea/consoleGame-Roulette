package model;

import model.bet.Bet;
import model.bet.BetColor;
import model.bet.BetParity;
import model.bet.BetSector;
import model.roulette.Roulette;

public class Win {

  private Win() {
  }

  public static boolean check(Roulette roulette, String winSector, Bet selectedBet) {


    if (selectedBet instanceof BetColor) {
      String winSectorColor = roulette.getColorSector(winSector);
      return selectedBet.getValue().equals(winSectorColor);
    }
    if (selectedBet instanceof BetSector) {
      return selectedBet.getValue().equals(winSector);
    }
    if (selectedBet instanceof BetParity) {
      String selectedParity = BetParity.getParitySector(selectedBet.getValue());
      String winSectorParity = BetParity.getParitySector(winSector);
      return winSectorParity.equals(selectedParity);
    }
    throw new IllegalArgumentException("Illegal bet value: " + selectedBet.getValue());
  }
}
