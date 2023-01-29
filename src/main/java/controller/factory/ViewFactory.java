package controller.factory;

import view.View;
import view.ViewConsole;
import view.ViewConsoleColor;

public class ViewFactory {

  public static final String KEY_VIEW_MONO = "mono";
  public static final String KEY_VIEW_COLOR = "color";

  public static View create(String key) {
    if (key.equalsIgnoreCase(KEY_VIEW_COLOR)) {
      return new ViewConsoleColor();
    }
    if (key.equalsIgnoreCase(KEY_VIEW_MONO)) {
      return new ViewConsole();
    }
    throw new IllegalArgumentException("Illegal key view: " + key);
  }

  public static boolean isCorrect(String key) {
    try {
      create(key);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

}
