package controller;

import view.View;

public class Dialog {

  private final View view;
  private final String title;
  private final String fail;
  private final String[] variants;

  public Dialog(View view, String title, String fail, String ... variants) {
    this.view = view;
    this.title = title;
    this.fail = fail;
    this.variants = variants;
  }

  public String input() {
    showTitle();
    while (true) {
      String key = view.input();
      for (String variant : variants) {
        if (key.equalsIgnoreCase(variant)) {
          return key;
        }
      }
      showFail();
    }
  }

  private void showTitle() {
    view.output(title);
  }

  private void showFail() {
    view.output(fail);
  }

}
