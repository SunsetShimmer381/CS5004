package shapes;

import java.util.Objects;

/**
 * An abstract base class for all Shapes.
 * Stores a reference point and provides common behavior.
 */
public abstract class AbstractShape implements Shape {

  private final Point2D reference;

  /**
   * Constructs a shape with a reference point.
   *
   * @param reference the reference point of the shape
   */
  protected AbstractShape(Point2D reference) {
    this.reference = Objects.requireNonNull(reference,
        "reference point cannot be null");
  }

  /**
   * Returns the reference point of this shape.
   */
  protected Point2D getReference() {
    return reference;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distanceFromOrigin();
  }

  /**
   * Compares shapes by their distance from the origin.
   */
  @Override
  public int compareTo(Shape other) {
    Objects.requireNonNull(other, "other shape cannot be null");
    return Double.compare(
        this.distanceFromOrigin(),
        other.distanceFromOrigin()
    );
  }
}

