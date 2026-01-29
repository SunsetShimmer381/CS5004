package shapes;

/**
 * Represents a circle shape.
 */
public class Circle extends AbstractShape {

  private final double radius;

  /**
   * Constructs a circle with a center (x, y) and a radius.
   *
   * @param x x-coordinate of the center
   * @param y y-coordinate of the center
   * @param radius radius of the circle
   */
  public Circle(double x, double y, double radius) {
    super(new Point2D(x, y));
    if (radius <= 0) {
      throw new IllegalArgumentException("radius must be greater than 0");
    }
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public String toString() {
    return "Circle: center=" + getReference() + ", radius=" + radius;
  }
}

