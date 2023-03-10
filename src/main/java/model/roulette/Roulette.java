package model.roulette;

import model.bet.BetParity;

import java.util.Random;

public abstract class Roulette {

  public static final String[] BLACK_SECTORS = {
      "2", "4", "6", "8", "10", "11", "13", "15",
      "17", "20", "22", "24", "26", "28", "29",
      "31", "33", "35"};
  public static final String[] RED_SECTORS = {
      "1", "3", "5", "7", "9", "12", "14", "16", "18",
      "19", "21", "23", "25", "27", "30", "32", "34", "36"};

  public static final String KEY_COLOR_RED = "RED";
  public static final String KEY_COLOR_BLACK = "BLACK";
  public static final String KEY_COLOR_NULL = "NULL";
  public static final String KEY_PARITY_EVEN = "EVEN";
  public static final String KEY_PARITY_ODD = "ODD";
  public static final String KEY_PARITY_NULL = "NULL";
  public static final String[] COLOR_SECTORS = {KEY_COLOR_RED, KEY_COLOR_BLACK};
  public static final String[] PARITY_SECTORS = {KEY_PARITY_EVEN, KEY_PARITY_ODD};


  public abstract String name();

  public String minSector() {
    return getSectors()[0];
  }

  public String maxSector() {
    return getSectors()[getSectors().length - 1];
  }

  public String spin() {
    String[] sectors = getSectors();
    Random random = new Random();
    int index = random.nextInt(sectors.length);
    return sectors[index];
  }

  private static boolean containInArray(String[] array, String find) {
    for (String s : array) {
      if (s.equals(find)) {
        return true;
      }
    }
    return false;
  }


  public String getColorSector(String sector) {
    if (containInArray(BLACK_SECTORS, sector)) {
      return KEY_COLOR_BLACK;
    }
    if (containInArray(RED_SECTORS, sector)) {
      return KEY_COLOR_RED;
    }
    return KEY_COLOR_NULL;
  }

  public boolean isCorrectSector(String sector) {
    String[] sectors = getSectors();
    return containInArray(sectors, sector);

  }

  public boolean isCorrectColorSector(String color) {
    return containInArray(COLOR_SECTORS, color);
  }
  public boolean isCorrectParitySector(String parity) {
    return containInArray(PARITY_SECTORS, parity);
  }

  public String getParitySector(String sector) {
    int number = Integer.parseInt(sector);
    if (number == 0) {
      return KEY_PARITY_NULL;
    }
    return number % 2 == 0 ? KEY_PARITY_EVEN : KEY_PARITY_ODD;
  }


  protected abstract String[] getSectors();

}
