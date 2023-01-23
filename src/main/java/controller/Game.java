package controller;

import model.roulette.AmericanRoulette;
import model.roulette.EuropeanRoulette;
import model.roulette.Roulette;
import model.Win;
import view.View;

public class Game {

  private final View view;
  public Game(View view) {
    this.view = view;
  }

  private Roulette roulette;

  public void start() {

    String typeRoulette = inputTypeRoulette();
    roulette = createRoulette(typeRoulette);

    showAboutGame();

    String selectedSector = inputSector();
    String winSector = roulette.spin();
    boolean resultGame = Win.check(winSector, selectedSector);

    showResult(winSector, resultGame);

  }

  private Roulette createRoulette(String typeRoulette) {
    if (typeRoulette.equalsIgnoreCase(Roulette.EU_TYPE)) {
      return new EuropeanRoulette();
    }
    if (typeRoulette.equalsIgnoreCase(Roulette.AM_TYPE)) {
      return new AmericanRoulette();
    }
    throw new IllegalArgumentException("Illegal type roulette: " + typeRoulette);
  }

  private String inputSector() {

    while (true) {
      view.output("Введите ваш ход:");
      String color = view.input().toUpperCase();

      if (roulette.isCorrectColorSector(color)) {
        return color;
      }
      view.output("Ошибка ввода");
    }
  }

  private String inputTypeRoulette() {
    while (true) {
      view.output("Выберите тип рулетки (am - Американская, eu - Европейская):");
      String type = view.input();

      if(Roulette.isCorrectTypeGame(type)) {
        return type;
      } else {
        view.output("Некорректный ввод!\n");
      }
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
    String string = String.format("ВЫИГРЫШНЫЙ СЕКТОР: %s (%s)", winSector, Roulette.getColorSector(winSector));
    view.output(string);

    if (resultGame) {
      view.output("Вы выиграли!");
    } else {
      view.output("Вы проиграли!");
    }
  }

}
