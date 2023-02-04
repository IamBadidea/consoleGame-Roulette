package model.bet;

public class BetParity extends Bet{

  public BetParity(String value) {
    super(value);
  }

  public static boolean isEvenSector(String even) {

    return Integer.valueOf(even) % 2 == 0;
  }
  public static boolean isOddSector(String odd) {
    return Integer.getInteger(odd) % 2 != 0;
  }
  public static String getParitySector(String sector) {
    if ("EVEN".equalsIgnoreCase(sector)) {
      return "EVEN";
    }
    if ("ODD".equalsIgnoreCase(sector)) {
      return "ODD";
    }

    return BetParity.isEvenSector(sector) ? "EVEN" : "ODD";
  }
}
