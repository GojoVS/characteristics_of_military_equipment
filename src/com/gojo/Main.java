package com.gojo;
import com.gojo.Interface.ConsoleColor;
import com.gojo.Interface.Menu;
import java.io.*;
import java.net.URISyntaxException;

/**
 * Головний клас програми
 */
public class Main {
  /**
   * Точка входу в програму
   *
   * @param args аргументи що надійшли з командного рядка
   * @throws IOException        виняток
   * @throws URISyntaxException виняток
   */
  public static void main(String[] args) throws IOException, URISyntaxException {


    System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
    System.out.println("**************************************************\n" +
        "---Довідник характеристик військової техніки---\n" +
        "**************************************************");


    //Виклик статичного методу mainMenu() класу Menu
    Menu.mainMenu();
  }
}
