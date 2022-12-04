package com.gojo.dao;

import com.gojo.Interface.ConsoleColor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Клас сухопутна військова техніка
 */

public class Groundmilitaryequipment extends ReaderFile{
  /**
   * Список сухопутна військова техніка
   */
  private static ArrayList<File> listOfGroundmilitaryequipment = new ArrayList<>();

  /**
   * Шлях до файлів з сухопутна військова техніка
   */
  private static final String PATH_TO_LESSONS = new File("Data\\Ground military equipment").getAbsolutePath();

  /**
   * Повертає сухопутна військова техніка
   *
   * @return повертає сухопутна військова техніка
   */
  public static ArrayList<File> getListOfGroundmilitaryequipment() {
    makeListOfGroundmilitaryequipment();
    return listOfGroundmilitaryequipment;
  }

  /**
   * Отримує список файлів, після їхньої фільтрації
   *
   * @param filterFiles відфільтровані файли
   */
  public static void setListOfLessons(ArrayList<File> filterFiles) {
    listOfGroundmilitaryequipment.clear();

    for (File file : filterFiles) {
      listOfGroundmilitaryequipment.add(file);
    }
  }

  /**
   * Виводить на екран список сухопутна військова техніка
   *
   * @return повертає true якщо вдалося вивести файли, якщо ні то false
   * @throws IOException виняток
   */
  public static boolean showListOfGroundmilitaryequipment() throws IOException {
    System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
    System.out.println("Список сухопутна військова техніка:");

    boolean isLessons = makeListOfGroundmilitaryequipment();

    int i = 0;

    if (isLessons) {
      for (File lesson : listOfGroundmilitaryequipment) {
        System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
        System.out.println(i + " - " + lesson.getName().substring(3, (lesson.getName().length() - 4)));

        i++;
      }
      return true; //Є файли
    }
    return false;//Файлів немає
  }

  /**
   * Заповнює список сухопутна військова техніка файлами
   *
   * @return повертає true якщо вдалося знайти файли, якщо ні то false
   */
  public static boolean makeListOfGroundmilitaryequipment() {
    File file = new File(PATH_TO_LESSONS);

    listOfGroundmilitaryequipment.clear();

    if (file.listFiles() != null) {
      for (File s : file.listFiles()) {
        if (s.isFile()) {
          listOfGroundmilitaryequipment.add(s);
        }
      }
      return true;
    } else {
      System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
      System.out.println("\nНе вдалося знайти файли по Повітряна військова техніка\n");
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
      System.out.print("Виберіть сухопутна військова техніка: ");
      try {
        index = Integer.parseInt(input.readLine());
        System.out.println("");
      } catch (Exception ex) {
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
        continue;
      }

      if (index < listOfGroundmilitaryequipment.size() && index >= 0) {
        break;
      } else {
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("Помилка! Не правильно введене число. Спробуйте ще раз.\n");
        continue;
      }
    } while (true);

    return listOfGroundmilitaryequipment.get(index);
  }
}



