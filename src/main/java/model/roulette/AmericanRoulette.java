package model.roulette;

import java.util.Random;

public class AmericanRoulette extends Roulette {

  private static final String NAME = "AMERICAN ROULETTE";
  private static final String[] SECTORS = {
          "00", "0", "1", "2", "3", "4", "5", "6",
          "7", "8", "9", "10", "11", "12", "13", "14",
          "15", "16", "17", "18", "19", "20", "21", "22", "23",
          "24", "25", "26", "27", "28", "29", "30", "31", "32",
          "33", "34", "35", "36"};

  public AmericanRoulette() {
    super(AM_TYPE);
  }

  public String name() {
    return NAME;
  }

  protected String[] getSectors() {
    return SECTORS;
  }

}
