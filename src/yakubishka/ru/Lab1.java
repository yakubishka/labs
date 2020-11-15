package yakubishka.ru;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Lab1 {

  public static void main(String[] args) {

    int size = 10;
    int []sourceArray = new int[size];
    int []resultArray = new int[size];
    HashSet<Integer> positionsSet = new HashSet<>();
    Random rnd = new Random();

    for (int i = 0; i < size; i++) {
      sourceArray[i] = i;
      positionsSet.add(i);
    }

    printArray(sourceArray);

    for (int i = 0; i < size; i++) {
      while (true) {
        int newPosition = rnd.nextInt(size);
        if (newPosition != i) {
          if (positionsSet.contains(newPosition)) {
            resultArray[newPosition] = sourceArray[i];
            positionsSet.remove(newPosition);
            break;
          } else if (i == size - 1 && positionsSet.contains(i)) {
            resultArray[size - 1] = resultArray[newPosition];
            resultArray[newPosition] = sourceArray[size - 1];
            break;
          }
        }
      }
    }
    printArray(resultArray);
  }

  public static void printArray(int[] array) {
    Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    System.out.println();
  }
}