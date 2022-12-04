package com.gojo.dao;

import com.gojo.Interface.ConsoleColor;

import java.io.*;


/**
 * Клас для читання вмісту файлу
 */
public class ReaderFile {

  /**
   * Метод який реалізує читання з файлу
   *
   * @param file файл вміст якого потрібно прочитати
   */
  public void readFile(File file) {

    BufferedReader reader = null;
    String line = "";

    try {
      reader = new BufferedReader(new FileReader(file));

      while ((line = reader.readLine()) != null) {

        String[] row = line.split(",");

        for (String index : row) {
          System.out.printf("%-30s", index);
        }
        System.out.println(ConsoleColor.CYAN_BOLD_BRIGHT);
      }
    } catch (Exception ex) {
      System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
      System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.");
    }

    System.out.println("\n");
  }
}