package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest extends AbstractShapeTest {

  @Override
  protected Shape makeShape() {
    // reference point (3,4) => distance 5
    return new Rectangle(3, 4, 2, 5);
  }

  @Test
  public void testConstructorValidation() {
    assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 0, 0, 1));
    assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 0, 1, 0));
    assertDoesNotThrow(() -> new Rectangle(0, 0, 1, 1));
  }

  @Test
  public void testArea() {
    Rectangle r = new Rectangle(0, 0, 2, 3);
    assertEquals(6.0, r.area(), 1e-9);
    assertTrue(r.area() > 0);
  }

  @Test
  public void testPerimeter() {
    Rectangle r = new Rectangle(0, 0, 2, 3);
    assertEquals(10.0, r.perimeter(), 1e-9);
    assertTrue(r.perimeter() > 0);
  }

  @Test
  public void testToString() {
    Rectangle r = new Rectangle(3, 4, 2, 5);
    String s = r.toString();
    assertTrue(s.contains("Rectangle"));
    assertTrue(s.contains("(3.0, 4.0)"));
  }
}

