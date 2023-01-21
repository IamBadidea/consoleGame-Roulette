package controller;

import model.Roulette;
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
    roulette = new Roulette(typeRoulette);

    showAboutGame();

    String selectedSector = inputSector(typeRoulette);
    String winSector = roulette.spin(typeRoulette, gameSectors(typeRoulette));
    boolean resultGame = Win.check(winSector, selectedSector);
    showResult(winSector, resultGame);

  }

  private String inputSector(String typeGame) {

    while (true) {
      view.output("Введите ваш ход:");
      String sector = view.input();

      if (roulette.isCorrectSector(sector, gameSectors(typeGame))) {
        return sector;
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
    String string = String.format("Секторы: %s-%s", roulette.minSector(), roulette.maxSector());
    view.output(string);
    view.output("***************************");
  }


  private void showResult(String winSector, boolean resultGame) {
    String string = String.format("ВЫИГРЫШНЫЙ СЕКТОР: %s", winSector);
    view.output(string);
    if (resultGame) {
      view.output("Вы выиграли!");
    } else {
      view.output("Вы проиграли!");
    }
  }

  private String[] gameSectors(String typeGame) {
    if (typeGame.equals(Roulette.AM_TYPE)) {
      return Roulette.AM_SECTORS;
    }
    return Roulette.EU_SECTORS;
  }

}
