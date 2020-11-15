package yakubishka.ru.lab4;

import java.awt.*;

import static java.lang.Math.*;

public class Triangle {

  private final Point [] pn;

  public Triangle(Point[] points) throws Exception {
    if (points.length != 3)
      throw new Exception("Triangle should have 3 points");
    else
      pn = points;
  }

  public Point getPoint(int position) throws Exception {
    if (position > 3)
      throw new Exception("Position should be less than 3");
    else
      return pn[position];
  }

  public double getSquare() {
    return 0.5 * abs((pn[0].x - pn[2].x) * (pn[1].y - pn[2].y) - (pn[1].x - pn[2].x) * (pn[0].y - pn[2].y));
  }

  public double getPerimeter() {
    return getSideLength(pn[0], pn[1]) + getSideLength(pn[1], pn[2]) + getSideLength(pn[2], pn[0]);
  }

  private double getSideLength(Point p1, Point p2) {
    return sqrt( pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
  }

  public Point getMedianCrossPoint() {
    return new Point((pn[0].x + pn[1].x + pn[2].x) / 3, (pn[0].y + pn[1].y + pn[2].y) / 3);
  }

}
