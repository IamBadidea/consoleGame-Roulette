package controller;

import view.View;
import view.ViewConsole;

public class Main {

  public static void main(String[] args) {
    View view = new ViewConsole();
    new Game(view).start();
  }

}
