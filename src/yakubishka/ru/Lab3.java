package yakubishka.ru;

import java.util.*;
import java.util.stream.Collectors;

public class Lab3 {

  public static void main(String[] args) {
    String sourceStr = "Somebody once told me that world is gonna roll me"
        .replaceAll("\\s+", "");

    List<String> splittedStr = split(sourceStr);
    printList(splittedStr);

    Random rnd = new Random();
    List<String> swappedList = splittedStr
        .stream()
        .map((item) -> swapMiddleCharacter(item, rnd))
        .collect(Collectors.toList());
    printList(swappedList);

    swappedList.sort(String::compareTo);
    printList(swappedList);
  }

  public static List<String> split(String source) {
    ArrayList<String> resultList = new ArrayList<>();
    int index = 0;
    while (index < source.length())
      resultList.add(source.substring(index, Math.min(index += 3, source.length())));
    return resultList;
  }

  public static String swapMiddleCharacter(String str, Random rnd) {
    String result = str;
    if (str.length() % 2 != 0) {
      int characterToSwap = -1;
      while (characterToSwap == -1 || str.contains((char)characterToSwap + ""))
        characterToSwap = rnd.nextInt(25) + 97;

      int indexToSwap = str.length() / 2;
      result = new StringBuilder(str)
          .replace(indexToSwap, indexToSwap + 1, (char)characterToSwap + "")
          .toString();
    }
    return result;
  }

  public static void printList(List<String> list) {
    System.out.println();
    for (String item : list)
      System.out.print(item + " ");
  }

}

