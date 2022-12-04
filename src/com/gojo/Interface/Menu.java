package com.gojo.Interface;

import com.gojo.bl.Search;
import com.gojo.dao.*;
import java.io.*;
import java.net.URISyntaxException;

/**
 * Даний клас реалізує меню
 */
public class Menu {

  /**
   * Даний метод реалізує головне меню користувача
   *
   * @throws IOException        виняток
   * @throws URISyntaxException виняток
   */
  public static void mainMenu() throws IOException, URISyntaxException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int command = 0;

    while (true) {
      System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
      System.out.println("- - - МЕНЮ - - -");
      System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
      System.out.print("1 - Сухопутна військова техніка\n" +
          "2 - Повітряна військова техніка\n" +
          "3 - Військово морські сили\n" +
          "4 - Пошук\n" +
          "0 - Вихід\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
          "Команда: ");

      try {
        command = Integer.parseInt(input.readLine());
        System.out.println("");
      } catch (Exception ex) {
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
        continue;
      }

      switch (command) {
        case 1: {
          //Якщо є файли
          if (Groundmilitaryequipment.showListOfGroundmilitaryequipment()) {
            ReaderFile fileReader = new Groundmilitaryequipment();
            fileReader.readFile(Groundmilitaryequipment.selectedFile());
          }

          backToMenu();
          continue;
        }
        case 2: {
          //Якщо є файли
          if (Airmilitaryequipment.showListOfAirmilitaryequipment()) {
            ReaderFile fileReader = new Airmilitaryequipment();
            fileReader.readFile(Airmilitaryequipment.selectedFile());
          }

          backToMenu();
          continue;
        }
        case 3: {
          //Якщо є файли
          if ( Militarynavalforces.showListOfMilitarynavalforces()) {
            ReaderFile fileReader = new  Militarynavalforces();
            fileReader.readFile( Militarynavalforces.selectedFile());
          }

          backToMenu();
          continue;
        }
        case 4: {
          /*
           * Перевірка на те, чи є файли у одному з списків.
           * Якщо списки пусті то методи повертають false
           */
          if (Groundmilitaryequipment.makeListOfGroundmilitaryequipment() |Airmilitaryequipment.makeListOfAirmilitaryequipment()) {
            Search.find();
          }

          backToMenu();
          continue;
        }
        case 0: {
          System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
          System.out.println("Допобачення");
          System.exit(0);
        }
        default: {
          System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
          System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
          continue;
        }
      }
    }
  }

  /**
   * Метод реалізує повернення користувача назад до меню, або вихід з програми
   *
   * @throws IOException виняток
   */
  private static void backToMenu() throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    do {
      int command;
      System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
      System.out.print("1 - Повернутися в меню\n" +
          "0 - Вихід\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
          "Команда: ");
      try {
        command = Integer.parseInt(input.readLine());
      } catch (Exception ex) {
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
        continue;
      }

      switch (command) {
        case 1: {
          System.out.println("");
          break;
        }
        case 0: {
          System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
          System.out.println("\nДопобачення :)");
          System.exit(0);
        }
        default: {
          System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
          System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
          continue;
        }
      }

      break;
    } while (true);
  }
}
