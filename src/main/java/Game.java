import java.util.Random;
import java.util.Scanner;

public class Game {

  private static final int MIN = 0;
  private static final int MAX = 36;

  public void start() {

    showAboutGame();
    int selectedSector = inputSector();
    int winSector = spinRoulette(MIN, MAX);
    boolean resultGame = checkWin(winSector, selectedSector);
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

      if (isCorrectNum(sector)) {
        return sector;
      }
      System.out.println("Ошибка ввода");
    }
  }

  private int spinRoulette(int min, int max) {
    Random r = new Random();
    return r.nextInt(MAX - MIN) + MIN + 1;
  }

  private boolean isNumber(String string) {
    try {
      Integer.parseInt(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private boolean isCorrectNum(int number) {
    return number <= MAX && number >= MIN;
  }

  private void showAboutGame() {
    System.out.println("***************************");
    System.out.println("ИГРА РУЛЕТКА");
    System.out.printf("Секторы: %d-%d\n", MIN, MAX);
    System.out.println("***************************");
  }

  private boolean checkWin(int winSector, int selectedSector) {
    return winSector == selectedSector;
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
