package com.gojo.dao;

import com.gojo.Interface.ConsoleColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * Клас про військово морські сили
 */

public class Militarynavalforces extends ReaderFile{
  /**
   * Список файлів військово морські сили
   */
  private static ArrayList<File> listOfMilitarynavalforces = new ArrayList<>();

  /**
   * Шлях до файлів з інформацією
   */
  private static final String PATH_TO_GENERAL_INFORMATION_ABOUT_JAVA = new File("Data\\Military naval forces").getAbsolutePath();

  /**
   * Повертає список військово морські сили
   *
   * @return повертає список військово морські сили
   */
  public static ArrayList<File> getListOfMilitarynavalforces() {
    return listOfMilitarynavalforces;
  }

  /**
   * Виводить на екран список військово морські сили
   *
   * @return повертає true якщо вдалося вивести файли, якщо ні то false
   * @throws IOException виняток
   */
  public static boolean showListOfMilitarynavalforces() throws IOException {
    System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
    System.out.println("Список:");

    boolean isGeneralInformation = makeListOfMilitarynavalforces();

    int i = 0;
    if (isGeneralInformation) {
      for (File generalInformation : listOfMilitarynavalforces) {
        System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
        System.out.println(i + " - " + generalInformation.getName().substring(3, (generalInformation.getName().length() - 4)));

        i++;
      }
      return true;//Є файли
    }
    return false;//Файлів немає
  }

  /**
   * Заповнює список файлами
   *
   * @return повертає true якщо вдалося знайти файли, якщо ні то false
   */
  public static boolean makeListOfMilitarynavalforces() {
    File file = new File(PATH_TO_GENERAL_INFORMATION_ABOUT_JAVA);

    listOfMilitarynavalforces.clear();

    if (file.listFiles() != null) {
      for (File s : file.listFiles()) {
        if (s.isFile()) {
          listOfMilitarynavalforces.add(s);
        }
      }
      return true;
    } else {
      System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
      System.out.println("\nНе вдалося знайти файли по військово морські сили\n");
      return false;
    }
  }

  /**
   * Визначай файл, який вибрав користувач
   *
   * @return повертає вибраний файл
   * @throws IOException виняток
   */
  public static File selectedFile() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int index = 0;

    do {
      System.out.print(ConsoleColor.PURPLE_BOLD_BRIGHT);
      System.out.print("Вибір: ");
      try {
        index = Integer.parseInt(input.readLine());
        System.out.println("");
      } catch (Exception ex) {
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
        continue;
      }

      if (index >= 0 && index < listOfMilitarynavalforces.size()) {
        break;
      } else {
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("Помилка! Не правильно введене число. Спробуйте ще раз.\n");
        continue;
      }
    } while (true);

    return listOfMilitarynavalforces.get(index);
  }
}





