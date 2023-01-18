package model;

import java.util.Random;

public class Roulette {
  public static final String[] SECTORS = {
          "00", "0", "1", "2", "3", "4", "5", "6",
          "7", "8", "9", "10", "11", "12", "13", "14",
          "15", "16", "17", "18", "19", "20", "21", "22", "23",
          "24", "25", "26", "27", "28", "29", "30", "31", "32",
          "33", "34", "35", "36"};

  public String minSector() {
    return SECTORS[0];
  }

  public String maxSector() {
    return SECTORS[SECTORS.length - 1];
  }


    public String spin() {
        Random random = new Random();
        int index = random.nextInt(SECTORS.length);
        return SECTORS[index];
    }

    public boolean isCorrectSector(String sector) {
        for (String s : SECTORS) {
            if (s.equals(sector)) {
                return true;
            }
        }
        return false;
    }


}
