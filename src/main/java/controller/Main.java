package controller;

import model.roulette.Roulette;
import view.View;
import view.ViewConsole;
import view.ViewConsoleColor;

public class Main {

  public static void main(String[] args) {
    View view = inputStyleView();

    String typeRoulette = inputTypeRoulette(view);
    Roulette roulette = RouletteFactory.create(typeRoulette);
    new Game(view, roulette).start();
  }
  private static View inputStyleView() {
    View view = new ViewConsole();

    while (true) {
      view.output("Выберите цвет игры:");
      view.output("MONO");
      view.output("COLOR");
      String color = view.input();

      if (!isCorrectColor(color)) {
        view.output("Ошибка ввода!");
        continue;
      }

      if (color.equalsIgnoreCase("COLOR")) {
        return new ViewConsoleColor();
      }
      return view;
    }
  }

  private static boolean isCorrectColor(String color) {
    if (color.equalsIgnoreCase("MONO") || color.equalsIgnoreCase("COLOR")) {
      return true;
    }
    return false;
  }


  private static String inputTypeRoulette(View view) {
    while (true) {
      view.output("Выберите тип рулетки:");
      view.output(RouletteFactory.AM_TYPE + " - Американская");
      view.output(RouletteFactory.EU_TYPE + " - Европейская");
      view.output(RouletteFactory.VEGAS_TYPE + " - Лас-Вегас");
      String type = view.input();

      if (RouletteFactory.isCorrect(type)) {
        return type;
      } else {
        view.output("Некорректный ввод!\n");
      }
    }
  }

}
