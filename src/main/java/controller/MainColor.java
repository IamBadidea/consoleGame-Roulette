package controller;

import view.View;
import view.ViewConsoleColor;

public class MainColor {

  public static void main(String[] args) {
    View view = new ViewConsoleColor();
    new Game(view).start();
  }

}
