package controller.factory;

import model.bet.Bet;
import model.bet.BetColor;
import model.bet.BetSector;
import model.roulette.Roulette;

public class BetFactory {

  private BetFactory() {
  }

  public static Bet create(Roulette roulette, String key){
    if (roulette.isCorrectSector(key)) {
      return new BetSector(key);
    }
    if (roulette.isCorrectColorSector(key)) {
      return new BetColor(key);
    }
    throw new IllegalArgumentException("Illegal key bet: " + key);
  }

  public static boolean isCorrect(Roulette roulette, String key) {
    try {
      create(roulette, key);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

}
