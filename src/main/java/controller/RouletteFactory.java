package controller;

import model.roulette.AmericanRoulette;
import model.roulette.EuropeanRoulette;
import model.roulette.Roulette;
import model.roulette.VegasRoulette;

public class RouletteFactory {
  public static final String EU_TYPE = "eu";
  public static final String AM_TYPE = "am";
  public static final String VEGAS_TYPE = "vegas";

  public static Roulette create(String typeRoulette) {
    if (typeRoulette.equalsIgnoreCase(EU_TYPE)) {
      return new EuropeanRoulette();
    }
    if (typeRoulette.equalsIgnoreCase(AM_TYPE)) {
      return new AmericanRoulette();
    }
    if (typeRoulette.equalsIgnoreCase(VEGAS_TYPE)) {
      return new VegasRoulette();
    }
    throw new IllegalArgumentException("Illegal type roulette: " + typeRoulette);
  }

  public static boolean isCorrect(String typeRoulette) {
    try {
      create(typeRoulette);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
