package shapes;

/**
 * Represents a geometric shape.
 * All shapes can compute area, perimeter,
 * and their distance from the origin.
 */
public interface Shape extends Comparable<Shape> {

  /**
   * Returns the area of this shape.
   *
   * @return area
   */
  double area();

  /**
   * Returns the perimeter of this shape.
   *
   * @return perimeter
   */
  double perimeter();

  /**
   * Returns the distance of this shape's reference point
   * from the origin (0, 0).
   *
   * @return distance from origin
   */
  double distanceFromOrigin();
}
