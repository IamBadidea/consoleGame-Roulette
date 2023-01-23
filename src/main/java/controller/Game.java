package controller;

import model.roulette.Roulette;
import model.Win;
import view.View;

public class Game {

  private final View view;
  private final Roulette roulette;

  public Game(View view, Roulette roulette) {
    this.view = view;
    this.roulette = roulette;
  }

  public void start() {

    showAboutGame();

    String selectedColorSector = inputColorSector();
    String winSector = roulette.spin();
    boolean resultGame = Win.check(winSector, selectedColorSector);

    showResult(winSector, resultGame);

  }



  private String inputColorSector() {

    while (true) {
      view.output("Введите ваш ход:");
      String color = view.input().toUpperCase();

      if (roulette.isCorrectColorSector(color)) {
        return color;
      }
      view.output("Ошибка ввода");
    }
  }

  private void showAboutGame() {
    view.output("***************************");
    view.output(roulette.name());
    String string = String.format("Ставки на цвет:\n%s \n%s",
        Roulette.KEY_COLOR_BLACK, Roulette.KEY_COLOR_RED);
    view.output(string);
    view.output("***************************");
  }


  private void showResult(String winSector, boolean resultGame) {
    String string = String.format("ВЫИГРЫШНЫЙ СЕКТОР: %s (%s)", winSector,
        Roulette.getColorSector(winSector));
    view.output(string);

    if (resultGame) {
      view.output("Вы выиграли!");
    } else {
      view.output("Вы проиграли!");
    }
  }



}
