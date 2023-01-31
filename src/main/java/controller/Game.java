package controller;

import controller.factory.BetFactory;
import model.bet.Bet;
import model.bet.BetColor;
import model.bet.BetSector;
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

    Bet selectedBet = inputBet();
    String winSector = roulette.spin();
    boolean resultGame = Win.check(roulette, winSector, selectedBet);

    showResult(winSector, resultGame);

  }



  private Bet inputBet() {
    while (true) {
      view.output("Введите вашу ставку:");
      String key = view.input().toUpperCase();
      if (BetFactory.isCorrect(roulette, key)) {
        Bet bet = BetFactory.create(roulette, key);
        return bet;
      }

      view.output("Ошибка ввода");

    }
  }

  private void showAboutGame() {
    view.output("***************************");
    view.output(roulette.name());
    String range = String.format("Сектора: %s-%s", roulette.minSector(), roulette.maxSector());
    view.output(range);
    String string = String.format("Цвет:\n%s \n%s",
        Roulette.KEY_COLOR_BLACK, Roulette.KEY_COLOR_RED);
    view.output(string);
    view.output("***************************");
  }


  private void showResult(String winSector, boolean resultGame) {
    String string = String.format("ВЫИГРЫШНЫЙ СЕКТОР: %s (%s)", winSector,
        roulette.getColorSector(winSector));
    view.output(string);

    if (resultGame) {
      view.output("Вы выиграли!");
    } else {
      view.output("Вы проиграли!");
    }
  }



}
