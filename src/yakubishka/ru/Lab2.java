package yakubishka.ru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Lab2 {

  public static void main(String[] args) {

    int size = 4;
    int [][]source = new int[size][size];
    Random rnd = new Random();
    ArrayList<Integer> rowMaxes = new ArrayList<>();

    for (int i = 0; i < source.length; i++)
      for (int j = 0; j < source[i].length; j++)
        source[i][j] = rnd.nextInt(200);
    System.out.println("-----SOURCE-----");
    printArray(source);

    for (int i = 0; i < size; i++) {
      rowMaxes.add(findMax(source[i]));
    }

    int minOfMaxInd = rowMaxes.indexOf(Collections.min(rowMaxes));

    int[][] resultArray = new int[size - 1][size];
    for (int i = 0, j = 0; i < size; i++) {
      if (i != minOfMaxInd) {
        System.arraycopy(source[i], 0, resultArray[j], 0, size);
        j++;
      }
    }
    System.out.println("-----RESULT-----");
    printArray(resultArray);

  }

  private static int findMax(int[] arr) {
    return Arrays.stream(arr).reduce(Math::max).orElse(0);
  }

  private static void printArray(int[][] arr) {
    for (int[] ints : arr) {
      Arrays.stream(ints).forEach(s -> System.out.print(s + " "));
      System.out.println();
    }
  }

}
