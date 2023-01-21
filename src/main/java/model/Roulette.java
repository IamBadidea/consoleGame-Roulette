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


  public String minSector(String typeGame) {
    if (typeGame.equals(AM_TYPE)) {
      return AM_SECTORS[0];
    }
    return EU_SECTORS[0];
  }

  public String maxSector(String typeGame) {
    if (typeGame.equals(AM_TYPE)) {
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

  public boolean isCorrectTypeGame(String enter) {
    if (enter.equals(EU_TYPE) || enter.equals(AM_TYPE)) {
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
