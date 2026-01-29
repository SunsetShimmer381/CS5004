package shapes;

/**
 * Represents a rectangle shape.
 */
public class Rectangle extends AbstractShape {

  private final double width;
  private final double height;

  /**
   * Constructs a rectangle with a reference point (x, y),
   * a width, and a height.
   *
   * @param x x-coordinate of the reference point
   * @param y y-coordinate of the reference point
   * @param width width of the rectangle
   * @param height height of the rectangle
   */
  public Rectangle(double x, double y, double width, double height) {
    super(new Point2D(x, y));   // 交给父类 reference 点
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("width and height must be greater than 0");
    }
    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public double area() {
    return width * height;
  }

  @Override
  public double perimeter() {
    return 2 * (width + height);
  }

  @Override
  public String toString() {
    return "Rectangle: reference=" + getReference()
        + ", width=" + width
        + ", height=" + height;
  }
}

