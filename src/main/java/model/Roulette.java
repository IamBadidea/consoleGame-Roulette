package model;

import java.util.Random;

public class Roulette {
  public static final String[] SECTORS = {
          "00", "0", "1", "2", "3", "4", "5", "6",
          "7", "8", "9", "10", "11", "12", "13", "14",
          "15", "16", "17", "18", "19", "20", "21", "22", "23",
          "24", "25", "26", "27", "28", "29", "30", "31", "32",
          "33", "34", "35", "36"};

  public static final String[] COLOR_SECTORS = {"RED", "BLACK"};

  public static final String[] BLACK_SECTORS = {
      "2", "4", "6", "8", "10", "11", "13" ,"15",
      "17", "20", "22", "24", "26", "28", "29",
      "31", "33", "35"};
  public static final String[] RED_SECTORS = {
      "1", "3" ,"5", "7", "9", "12", "14", "16", "18",
      "19", "21", "23", "25", "27", "30", "32", "34", "36"};

  public static final String EU_TYPE = "eu";
  public static final String AM_TYPE = "am";
  public static final String KEY_COLOR_RED = "RED";
  public static final String KEY_COLOR_BLACK = "BLACK";
  public static final String KEY_COLOR_NULL = "NULL";

  private final String type;

  public Roulette(String type) {
    if (!isCorrectTypeGame(type)) {
      throw new IllegalArgumentException("Illegal type roulette: " + type);
    }
    this.type = type.toLowerCase();
  }

  public String name() {
    if (type.equals(EU_TYPE)) {
      return "EUROPEAN ROULETTE";
    }
    return "AMERICAN ROULETTE";
  }


  public String minSector() {
    return isEuropean() ? getSectors()[1] : getSectors()[0];
  }

  public String maxSector() {
    return getSectors()[getSectors().length - 1];
  }


  public String spin() {
    String[] sectors = getSectors();
    Random random = new Random();
    int offset = isEuropean() ? 1 : 0;
    int index = random.nextInt(sectors.length - offset) + offset;
    return sectors[index];
  }

  public boolean isCorrectColorSector(String color) {
    for (String colorSector : COLOR_SECTORS) {
      if (color.equals(colorSector)) {
        return true;
      }
    }
    return false;
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

  private static boolean checkSectors(String sector, String[] sectors) {
    for (String s : sectors) {
      if (sector.equals(s)) {
        return true;
      }
    }
    return false;
  }

  private String[] getSectors() {
    return SECTORS;
  }

  public static boolean isCorrectTypeGame(String enter) {
    if (enter.equalsIgnoreCase(EU_TYPE) || enter.equalsIgnoreCase(AM_TYPE)) {
      return true;
    }
    return false;
  }

  public boolean isAmerican() {
    return type.equals(AM_TYPE);
  }
  public boolean isEuropean() {
    return type.equals(EU_TYPE);
  }


}
