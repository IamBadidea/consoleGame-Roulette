package view;

import java.util.Scanner;

public class ViewConsole implements View{

  @Override
  public void output(String message) {
    System.out.println(message);
  }

  @Override
  public String input() {
    Scanner sc = new Scanner(System.in);
    return sc.nextLine();
  }
}
