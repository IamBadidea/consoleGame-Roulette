package model.roulette;

import java.util.ArrayList;
import java.util.Collections;

public class AmericanRoulette extends Roulette {

  private static final String NAME = "AMERICAN ROULETTE";
  private static final String RANGE = "Сектора: 00-36";
  private static final String[] SECTORS = {
          "00", "0", "1", "2", "3", "4", "5", "6",
          "7", "8", "9", "10", "11", "12", "13", "14",
          "15", "16", "17", "18", "19", "20", "21", "22", "23",
          "24", "25", "26", "27", "28", "29", "30", "31", "32",
          "33", "34", "35", "36"};

  public String name() {
    return NAME;
  }

  public String range() {
    return RANGE;
  }

  public String[] getAllSectors() {
    ArrayList<String> sectorList = new ArrayList<>();

    Collections.addAll(sectorList, SECTORS);
    Collections.addAll(sectorList, COLOR_SECTORS);

    String[] sectors = new String[sectorList.size()];
    sectors = sectorList.toArray(sectors);
    return sectors;
  }

  public boolean isCorrectSector(String sector) {
    return Roulette.checkSectors(sector, getAllSectors());
  }

  protected String[] getSectors() {
    return SECTORS;
  }

}
