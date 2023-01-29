package controller.factory;

import model.roulette.AmericanRoulette;
import model.roulette.EuropeanRoulette;
import model.roulette.Roulette;
import model.roulette.VegasRoulette;

public class RouletteFactory {
  public static final String KEY_EU_TYPE = "eu";
  public static final String KEY_AM_TYPE = "am";
  public static final String KEY_VEGAS_TYPE = "vegas";

  public static Roulette create(String typeRoulette) {
    if (typeRoulette.equalsIgnoreCase(KEY_EU_TYPE)) {
      return new EuropeanRoulette();
    }
    if (typeRoulette.equalsIgnoreCase(KEY_AM_TYPE)) {
      return new AmericanRoulette();
    }
    if (typeRoulette.equalsIgnoreCase(KEY_VEGAS_TYPE)) {
      return new VegasRoulette();
    }
    throw new IllegalArgumentException("Illegal type roulette: " + typeRoulette);
  }

  public static boolean isCorrect(String key) {
    try {
      create(key);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
