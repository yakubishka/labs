package yakubishka.ru.lab4;

import java.awt.*;

public class Lab4 {

  public static void main(String[] args) {
    Point a = new Point(2, 5);
    Point b = new Point(6, 10);
    Point c = new Point(4, 1);

    Point [] points = new Point []{a, b, c};
    try {
      Triangle triangle = new Triangle(points);
      System.out.println("perimeter = " + triangle.getPerimeter());
      System.out.println("square = " + triangle.getSquare());
      Point medianCrossPoint = triangle.getMedianCrossPoint();
      System.out.println("medianCrossPoint x = " + medianCrossPoint.x + " y = " + medianCrossPoint.y );

    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}

