import java.util.Random;
import java.util.Scanner;

public class Game {

  private static final int MAX = 36;
  private static final int MIN = 10;

  public void start() {

    showAboutGame();
    int sector = inputSector();
    int numWin = spinRoulette(MIN, MAX);
    checkWin(sector, numWin);

  }

  private int inputSector() {
    Scanner sc = new Scanner(System.in);

    while(true) {
      System.out.println("Введите ваш ход:");
      String input = sc.nextLine();

      if (!isNumber(input)) {
        continue;
      }

      int sector = Integer.parseInt(input);

      if (isCorrectNum(sector)) {
        return sector;
      }
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

  private boolean checkWin(Integer move, int numWin) {
    if (move.equals(numWin)) {
      System.out.println("Вы победили.");
    } else {
      System.out.println("Вы проиграли.");
    }

    System.out.println("Выигрышный номер:".toUpperCase() + numWin);
    return false;
  }

}
