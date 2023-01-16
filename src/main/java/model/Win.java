package model;

public class Win {

  private Win() {
  }

  public static boolean check(int winSector, int selectedSector) {
    return winSector == selectedSector;
  }
}
