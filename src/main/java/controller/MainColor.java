package controller;

import controller.factory.RouletteFactory;
import model.roulette.Roulette;
import view.View;
import view.ViewConsoleColor;

public class MainColor {

  public static void main(String[] args) {
    View view = new ViewConsoleColor();
    String typeRoulette = inputTypeRoulette(view);
    Roulette roulette = RouletteFactory.create(typeRoulette);
    new Game(view, roulette).start();
  }


  private static String inputTypeRoulette(View view) {
    while (true) {
      view.output("Выберите тип рулетки:");
      view.output(RouletteFactory.KEY_AM_TYPE + " - Американская");
      view.output(RouletteFactory.KEY_EU_TYPE + " - Европейская");
      view.output(RouletteFactory.KEY_VEGAS_TYPE + " - Лас-Вегас");
      String type = view.input();

      if (RouletteFactory.isCorrect(type)) {
        return type;
      } else {
        view.output("Некорректный ввод!\n");
      }
    }
  }
}
