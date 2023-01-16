package model;

import java.util.Random;

public class Roulette {
  public static final int MIN_SECTOR = 0;
  public static final int MAX_SECTOR = 36;

  public int spin() {
    Random r = new Random();
    return r.nextInt(MAX_SECTOR - MIN_SECTOR) + MIN_SECTOR + 1;
  }

  public boolean isCorrectSector(int sector) {
    return sector <= MAX_SECTOR && sector >= MIN_SECTOR;
  }





}
