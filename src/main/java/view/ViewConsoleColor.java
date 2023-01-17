package view;

import java.util.Scanner;

public class ViewConsoleColor extends ViewConsole{

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  @Override
  public void output(String message) {
    char[] chars = message.toCharArray();
    for (char c : chars) {
      String color = colorBy(c);
      System.out.print(color);
      System.out.print(c);
    }
    System.out.println(ANSI_RESET);
  }

  private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isRussian(char c) {
    return (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я');
  }

  private boolean isEnglish(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private String colorBy(char c) {
    if (isRussian(c)) {
      return ANSI_PURPLE;
    }
    if (isEnglish(c) || isNumber(c)) {
      return ANSI_BLUE;
    }
    return ANSI_GREEN;
  }

}
