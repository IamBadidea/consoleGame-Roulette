package model.roulette;

import java.util.Random;

public abstract class Roulette {

  public static final String[] COLOR_SECTORS = {"RED", "BLACK"};

  public static final String[] BLACK_SECTORS = {
      "2", "4", "6", "8", "10", "11", "13", "15",
      "17", "20", "22", "24", "26", "28", "29",
      "31", "33", "35"};
  public static final String[] RED_SECTORS = {
      "1", "3", "5", "7", "9", "12", "14", "16", "18",
      "19", "21", "23", "25", "27", "30", "32", "34", "36"};

  public static final String[] ALL_SECTORS = {
      "RED", "BLACK",

      "2", "4", "6", "8", "10", "11", "13", "15",
      "17", "20", "22", "24", "26", "28", "29",
      "31", "33", "35",

      "1", "3", "5", "7", "9", "12", "14", "16", "18",
      "19", "21", "23", "25", "27", "30", "32", "34", "36"
  };

  public static final String KEY_COLOR_RED = "RED";
  public static final String KEY_COLOR_BLACK = "BLACK";
  public static final String KEY_COLOR_NULL = "NULL";

  public abstract String name();

  public abstract String range();

  public abstract String[] getAllSectors();

  public String minSector() {
    return getAllSectors()[0];
  }

  public String maxSector() {
    return getAllSectors()[getAllSectors().length - 1];
  }

  public String spin() {
    String[] sectors = getAllSectors();
    Random random = new Random();
    int index = random.nextInt(sectors.length);
    return sectors[index];
  }


  public static String getColorSector(String sector) {
    if (checkSectors(sector, BLACK_SECTORS)) {
      return KEY_COLOR_BLACK;
    }
    if (checkSectors(sector, RED_SECTORS)) {
      return KEY_COLOR_RED;
    }
    return KEY_COLOR_NULL;
  }

  public abstract boolean isCorrectSector(String sector);
//  protected static boolean checkSectors(String sector, String[] sectors);

  public boolean isCorrectColorSector(String color) {
    for (String colorSector : COLOR_SECTORS) {
      if (color.equals(colorSector)) {
        return true;
      }
    }
    return false;
  }

  public static boolean checkSectors(String sector, String[] sectors) {
    for (String s : sectors) {
      if (sector.equals(s)) {
        return true;
      }
    }
    return false;
  }

//  protected abstract String[] getSectors();

}
