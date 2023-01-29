package controller;

import controller.factory.RouletteFactory;
import controller.factory.ViewFactory;
import model.roulette.Roulette;
import view.View;
import view.ViewConsole;

public class Main {

  public static void main(String[] args) {
    View view = new ViewConsole();

    String keyView = inputKeyView(view);
    view = ViewFactory.create(keyView);

    String typeRoulette = inputTypeRoulette(view);
    Roulette roulette = RouletteFactory.create(typeRoulette);

    Game game = new Game(view, roulette);
    game.start();
  }

  private static String inputKeyView(View view) {

    String title = String.format("Выберите цвет консоли:\n%s\n%s", ViewFactory.KEY_VIEW_MONO, ViewFactory.KEY_VIEW_COLOR);

    Dialog dialog = new Dialog(
        view,
        title,
        "Некорректный ввод!",
        ViewFactory.KEY_VIEW_MONO,
        ViewFactory.KEY_VIEW_COLOR);

    return dialog.input();
  }


  private static String inputTypeRoulette(View view) {

    String title = String.format(
        "Выберите тип рулетки:\n%s\n%s\n%s",
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

    return dialog.input();

  }

}
