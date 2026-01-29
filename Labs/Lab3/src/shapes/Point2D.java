package shapes;

import java.util.Objects;

public class Point2D {
  private final double x;
  private final double y;

  /**
   * construct a point at (x, y)
   *
   * @param x x-cordinate
   * @param y y-cordinate
   */

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  /**
   * Computes the distance from this point to another point.
   *
   * @param other the other point
   * @return Euclidean distance
   */
  public double distanceTo(Point2D other) {
    Objects.requireNonNull(other, "other point can not be null!");
    double dx = this.x - other.x;
    double dy = this.y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  /**
   * Computes the distance from this point to the origin.
   *
   * @return distance from (0,0)
   */
  public double distanceFromOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Point2D)) return false;
    Point2D p = (Point2D) o;
    return Double.compare(p.x, x) == 0 &&
        Double.compare(p.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
