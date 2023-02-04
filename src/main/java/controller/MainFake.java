package controller;

import model.roulette.AmericanRoulette;
import model.roulette.Roulette;
import view.View;
import view.ViewConsole;

public class MainFake {

  public static void main(String[] args) {
    View view = new ViewConsole();
    Roulette roulette = new AmericanRoulette() {
      @Override
      public String name() {
        return "FAKE ROULETTE";
      }

      @Override
      public String spin() {
        return "12";
      }
    };
    new Game(view, roulette).start();
  }

}
