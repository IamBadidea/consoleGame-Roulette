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

    String selectedGame = chooseTypeGame();
    showAboutGame(selectedGame);

    String selectedSector = inputSector(selectedGame);
    String winSector = roulette.spin(selectedGame, gameSectors(selectedGame));
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

  private String chooseTypeGame() {
    while (true) {
      view.output("Выберите тип рулетки (am - Американская, eu - Европейская):");
      String type = view.input();

      if(roulette.isCorrectTypeGame(type)) {
        return type;
      } else {
        view.output("Некорректный ввод!\n");
      }
    }
  }


  private void showAboutGame(String typeGame) {
    view.output("***************************");
    if (typeGame.equals(Roulette.EU_TYPE)) {
      view.output("ЕВРОПЕЙСКАЯ РУЛЕТКА");
    } else {
      view.output("АМЕРИКАНСКАЯ РУЛЕТКА");
    }
    String string = String.format("Секторы: %s-%s", roulette.minSector(typeGame), roulette.maxSector(typeGame));
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
