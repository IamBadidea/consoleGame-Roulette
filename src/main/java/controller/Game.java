package controller;

import model.Roulette;
import model.Win;
import view.View;

public class Game {

  private final View view;
  private final Roulette roulette = new Roulette();

  public Game(View view) {
    this.view = view;
  }

  public void start() {

    showAboutGame();
    int selectedSector = inputSector();
    int winSector = roulette.spin();
    boolean resultGame = Win.check(winSector, selectedSector);
    showResult(winSector, resultGame);

  }

  private int inputSector() {

    while(true) {
      view.output("Введите ваш ход:");
      String input = view.input();

      if (!isNumber(input)) {
        view.output("Ошибка ввода");
        continue;
      }

      int sector = Integer.parseInt(input);

      if (roulette.isCorrectSector(sector)) {
        return sector;
      }
      view.output("Ошибка ввода");
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
    view.output("***************************");
    view.output("ИГРА РУЛЕТКА");
    String string = String.format("Секторы: %d-%d", Roulette.MIN_SECTOR, Roulette.MAX_SECTOR);
    view.output(string);
    view.output("***************************");
  }



  private void showResult(int winSector, boolean resultGame) {
    String string = String.format("ВЫИГРЫШНЫЙ СЕКТОР: %d", winSector);
    view.output(string);
    if (resultGame) {
      view.output("Вы выиграли!");
    } else {
      view.output("Вы проиграли!");
    }
  }

}
