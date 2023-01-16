import java.util.Scanner;
import model.Roulette;
import model.Win;

public class Game {

  private final Roulette roulette = new Roulette();

  public void start() {

    showAboutGame();
    int selectedSector = inputSector();
    int winSector = roulette.spin();
    boolean resultGame = Win.check(winSector, selectedSector);
    showResult(winSector, resultGame);

  }

  private int inputSector() {
    Scanner sc = new Scanner(System.in);

    while(true) {
      System.out.println("Введите ваш ход:");
      String input = sc.nextLine();

      if (!isNumber(input)) {
        System.out.println("Ошибка ввода");
        continue;
      }

      int sector = Integer.parseInt(input);

      if (roulette.isCorrectSector(sector)) {
        return sector;
      }
      System.out.println("Ошибка ввода");
    }
  }



  private boolean isNumber(String string) {
    try {
      Integer.parseInt(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }



  private void showAboutGame() {
    System.out.println("***************************");
    System.out.println("ИГРА РУЛЕТКА");
    System.out.printf("Секторы: %d-%d\n", Roulette.MIN_SECTOR, Roulette.MAX_SECTOR);
    System.out.println("***************************");
  }



  private void showResult(int winSector, boolean resultGame) {
    System.out.printf("ВЫИГРЫШНЫЙ СЕКТОР: %d\n", winSector);
    if (resultGame) {
      System.out.println("Вы выиграли!");
    } else {
      System.out.println("Вы проиграли!");
    }
  }

}
