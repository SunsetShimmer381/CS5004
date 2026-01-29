package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest extends AbstractShapeTest {

  @Override
  protected Shape makeShape() {
    // reference point (3,4) => distance 5
    return new Circle(3, 4, 2);
  }

  @Test
  public void testConstructorValidation() {
    assertThrows(IllegalArgumentException.class, () -> new Circle(0, 0, 0));
    assertDoesNotThrow(() -> new Circle(0, 0, 1));
  }

  @Test
  public void testArea() {
    Circle c = new Circle(0, 0, 2);
    assertEquals(Math.PI * 4.0, c.area(), 1e-9);
    assertTrue(c.area() > 0);
  }

  @Test
  public void testPerimeter() {
    Circle c = new Circle(0, 0, 2);
    assertEquals(2.0 * Math.PI * 2.0, c.perimeter(), 1e-9);
    assertTrue(c.perimeter() > 0);
  }

  @Test
  public void testToString() {
    Circle c = new Circle(3, 4, 2);
    String s = c.toString();
    assertTrue(s.contains("Circle"));
    assertTrue(s.contains("(3.0, 4.0)"));
  }
}
