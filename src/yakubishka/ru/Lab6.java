package yakubishka.ru;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;

public class Lab6 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String in;
    System.out.print("-> ");
    while (!(in = scanner.nextLine()).isEmpty()) {
      String[] userInput = in.split(" ", 3);

      if (userInput.length < 2) {
        if (userInput.length == 1 && userInput[0].equals("exit"))
          break;
        System.out.println("Command input error");
        System.out.print("-> ");
        continue;
      }

      String command = userInput[0];
      String path = userInput[1];
      String text = "";
      if (userInput.length > 2)
        text = userInput[2];

      try {
        switch (command) {
          case "touch" -> touch(path);
          case "ls" -> ls(path);
          case "rm" -> rm(path);
          case "vim" -> vim(path, text, true);
          case "vim_e" -> vim(path, text, false);
          case "cat" -> cat(path);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      finally {
        System.out.print("-> ");
      }
    }
  }

  public static void rm(String path) {
    if (new File(path).delete())
      System.out.println("File " + path + " removed successfully");
    else
      System.out.println("Error happened or file doesn't exist");
  }

  public static void ls(String path) {
    File file = new File(path);
    if (file.isDirectory()) {

      File[] folderContent = file.listFiles();

      if (folderContent != null) {

        if (folderContent.length != 0) {

          System.out.println("Content of directory:");

          for (File value : folderContent)
            System.out.print(value.getName() + " ");

          System.out.println();

        } else {
          System.out.println("directory is empty");
        }
      }
    } else if (file.isFile()) {
      System.out.println(path + " is file");
    } else if (file.exists()) {
      System.out.println(path + "doesn't exist");
    }
  }

  public static void vim(String pathStr, String text, boolean createNew) {
    Path path = Paths.get(pathStr);
    try {
      if (createNew && Files.exists(path)) rm(pathStr);
      Files.write(path, Collections.singletonList(text), StandardCharsets.UTF_8,
          Files.exists(path) && !createNew ? StandardOpenOption.APPEND : StandardOpenOption.CREATE_NEW);

      String message = "Appended to file successfully";
      if (createNew)
        System.out.println(message);

    } catch (IOException e) {
      System.out.println("Something went wrong");
      e.printStackTrace();
    }
  }

  public static void touch(String path) throws IOException {
    if (new File(path).createNewFile())
      System.out.println("File " + path + " created successfully");
    else
      System.out.println("Error happened while creating file " + path);
  }

  public static void cat(String path) throws IOException {
    for (String line : Files.readAllLines(Paths.get(path)))
      System.out.println(line);
  }

}
