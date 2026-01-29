package shapes;

/**
 * Represents a triangle defined by three points.
 * The first point is the reference point.
 */
public class Triangle extends AbstractShape {

  private final Point2D p2;
  private final Point2D p3;

  /**
   * Constructs a triangle from three points.
   * The first point is the reference point.
   */
  public Triangle(double x1, double y1,
      double x2, double y2,
      double x3, double y3) {
    this(new Point2D(x1, y1),
        new Point2D(x2, y2),
        new Point2D(x3, y3));
  }

  public Triangle(Point2D p1, Point2D p2, Point2D p3) {
    super(p1);

    if (p1 == null || p2 == null || p3 == null) {
      throw new IllegalArgumentException("Points cannot be null");
    }

    // No identical points allowed
    if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
      throw new IllegalArgumentException("Triangle cannot have identical points");
    }

    this.p2 = p2;
    this.p3 = p3;
  }

  public Point2D getP1() {
    return getReference();
  }

  public Point2D getP2() {
    return p2;
  }

  public Point2D getP3() {
    return p3;
  }

  @Override
  public double perimeter() {
    Point2D p1 = getReference();

    double a = p1.distanceTo(p2);
    double b = p1.distanceTo(p3);
    double c = p2.distanceTo(p3);

    return a + b + c;
  }

  @Override
  public double area() {
    Point2D p1 = getReference();

    double a = p1.distanceTo(p2);
    double b = p1.distanceTo(p3);
    double c = p2.distanceTo(p3);

    double s = (a + b + c) / 2.0;   // Heron formula

    double value = s * (s - a) * (s - b) * (s - c);

    return Math.sqrt(Math.max(0.0, value));
  }

  @Override
  public String toString() {
    return "Triangle: p1=" + getReference()
        + ", p2=" + p2
        + ", p3=" + p3;
  }
}

