package controller;

import controller.factory.RouletteFactory;
import controller.factory.ViewFactory;

public class MainAmericanColor {

  public static void main(String[] args) {
    Main.main(ViewFactory.KEY_VIEW_COLOR, RouletteFactory.KEY_AM_TYPE);
  }

}
