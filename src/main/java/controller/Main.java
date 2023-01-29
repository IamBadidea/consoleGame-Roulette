package controller;

import controller.factory.RouletteFactory;
import controller.factory.ViewFactory;
import model.roulette.Roulette;
import view.View;
import view.ViewConsole;

public class Main {

  public static void main(String[] args) {
    View view = new ViewConsole();

    view = inputView(view);

    Roulette roulette = inputRoulette(view);

    Game game = new Game(view, roulette);
    game.start();
  }

  private static View inputView(View view) {

    String title = String.format("Выберите цвет консоли:\n%s\n%s", ViewFactory.KEY_VIEW_MONO, ViewFactory.KEY_VIEW_COLOR);

    Dialog dialog = new Dialog(
        view,
        title,
        "Некорректный ввод!",
        ViewFactory.KEY_VIEW_MONO,
        ViewFactory.KEY_VIEW_COLOR);

    String key = dialog.input();

    return ViewFactory.create(key);
  }


  private static Roulette inputRoulette(View view) {

    String title = String.format(
        "Выберите тип рулетки:\n%s - Европейская\n%s - Американская\n%s - Лас-Вегас",
        RouletteFactory.KEY_EU_TYPE,
        RouletteFactory.KEY_AM_TYPE,
        RouletteFactory.KEY_VEGAS_TYPE
        );

    Dialog dialog = new Dialog(
        view,
        title,
        "Некорректный ввод!",
        RouletteFactory.KEY_EU_TYPE,
        RouletteFactory.KEY_AM_TYPE,
        RouletteFactory.KEY_VEGAS_TYPE);

    String key = dialog.input();

    return RouletteFactory.create(key);
  }

}
