package yakubishka.ru;

import java.util.*;
import java.util.stream.Collectors;

public class Lab7 {

  public static void main(String[] args) {
    int [] avArray = new int[] { 4, 5, 10, 95, 12, 63 };
    System.out.println("Average value = " + getAverage(avArray));

    ArrayList<String> listToMap = new ArrayList<>();
    listToMap.add("tset");
    listToMap.add("kieww");
    listToMap.add("My name");

    listToUpperCase(listToMap).forEach((item) -> System.out.print(item + " "));
    System.out.println();

    List<Integer> uniqList = Arrays.asList( 4, 5, 10, 23, 5, 4, 6, 9, 3, 3);
    getSquareOfUnique(uniqList).forEach((item) -> System.out.print(item + " "));
    System.out.println();

  }

  private static double getAverage(int[] arr) {
    return Arrays.stream(arr)
        .average()
        .orElse(0.0);
  }
  
  private static List<String> listToUpperCase(List<String> source) {
    return source.stream()
        .map((item) -> item.toUpperCase(Locale.ROOT))
        .collect(Collectors.toList());
  }

  private static List<Integer> getSquareOfUnique(List<Integer> list) {
    return list.stream()
        .filter(el -> Collections.frequency(list, el) == 1)
        .map((item) -> item * item)
        .collect(Collectors.toList());
  }

}
