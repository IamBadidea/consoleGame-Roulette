package model;

public class Win {

  private Win() {
  }

  public static boolean check(String winSector, String selectedSector) {
    return winSector.equals(selectedSector);
  }
}
