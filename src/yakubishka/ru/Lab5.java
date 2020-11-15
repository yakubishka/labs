package yakubishka.ru;

// Пользователь вводит некоторое число.
// Записать его цифры в стек. Вывести число,
// у которого цифры идут в обратном порядке.
// Предусмотреть возможность введения произвольного количества чисел.

import java.util.Scanner;
import java.util.Stack;

public class Lab5 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number: ");
    String[] userInput = scanner.nextLine().split("\\s+");

    for (String s : userInput) {
      System.out.print(getReversed(s) + " ");
    }

    System.out.println();
  }

  private static String getReversed(String userInput) {
    Stack<Character> numberStk = new Stack<>();
    for (int i = 0; i < userInput.length(); i++) {
      try {
        Integer.parseInt(userInput.charAt(i) + "");
        numberStk.push(userInput.charAt(i));
      } catch (NumberFormatException e) {
        System.out.println("Number format exception");
        System.exit(0);
      }
    }
    StringBuilder resultStr = new StringBuilder();

    while (!numberStk.isEmpty())
      resultStr.append(numberStk.pop());

    return resultStr.toString();
  }
}
