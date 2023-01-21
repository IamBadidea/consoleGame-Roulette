package model;

import java.util.Random;

public class Roulette {
  public static final String[] EU_SECTORS = {
          "0", "1", "2", "3", "4", "5", "6",
          "7", "8", "9", "10", "11", "12", "13", "14",
          "15", "16", "17", "18", "19", "20", "21", "22", "23",
          "24", "25", "26", "27", "28", "29", "30", "31", "32",
          "33", "34", "35", "36"};
  public static final String[] AM_SECTORS = {
          "00", "0", "1", "2", "3", "4", "5", "6",
          "7", "8", "9", "10", "11", "12", "13", "14",
          "15", "16", "17", "18", "19", "20", "21", "22", "23",
          "24", "25", "26", "27", "28", "29", "30", "31", "32",
          "33", "34", "35", "36"};

  public static final String EU_TYPE = "eu";
  public static final String AM_TYPE = "am";

  private final String type;

  public Roulette(String type) {
    if (!isCorrectTypeGame(type)) {
      throw new IllegalArgumentException("Illegal type roulette: " + type);
    }
    this.type = type;
  }

  public String name() {
    if (type.equals(EU_TYPE)) {
      return "EUROPEAN ROULETTE";
    }
    return "AMERICAN ROULETTE";
  }


  public String minSector() {
    if (type.equals(AM_TYPE)) {
      return AM_SECTORS[0];
    }
    return EU_SECTORS[0];
  }

  public String maxSector() {
    if (type.equals(AM_TYPE)) {
      return AM_SECTORS[AM_SECTORS.length - 1];
    }
    return EU_SECTORS[EU_SECTORS.length - 1];
  }


  public String spin(String typeGame, String[] sectors) {
    Random random = new Random();
    int index = random.nextInt(sectors.length);
    return sectors[index];
  }

  public boolean isCorrectSector(String sector, String[] sectors) {
    for (String s : sectors) {
      if (s.equals(sector)) {
        return true;
      }
    }
    return false;
  }

  public static boolean isCorrectTypeGame(String enter) {
    if (enter.equalsIgnoreCase(EU_TYPE) || enter.equalsIgnoreCase(AM_TYPE)) {
      return true;
    }
    return false;
  }

  private String[] gameSectors(String typeGame) {
    if (typeGame.equals(AM_TYPE)) {
      return AM_SECTORS;
    }
    return EU_SECTORS;
  }


}
