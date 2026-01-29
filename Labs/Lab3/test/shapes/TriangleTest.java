package shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriangleTest extends AbstractShapeTest {

  @Override
  protected Shape makeShape() {
    // reference point (3,4) => distance 5
    return new Triangle(3, 4, 0, 0, 0, 5);
  }

  @Test
  public void testConstructorIdenticalPointsThrows() {
    // p1 == p2
    assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 0, 0, 1, 1));
    // p1 == p3
    assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 1, 1, 0, 0));
    // p2 == p3
    assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 1, 1, 1, 1));
  }

  @Test
  public void testConstructorValidDoesNotThrow() {
    assertDoesNotThrow(() -> new Triangle(0, 0, 1, 0, 0, 1));
    Triangle t = new Triangle(0, 0, 1, 0, 0, 1);
    assertNotNull(t);
  }

  @Test
  public void testPerimeterRightTriangle() {
    // (0,0)-(3,0)-(0,4): 3-4-5 => perimeter 12
    Triangle t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(12.0, t.perimeter(), 1e-9);
    assertTrue(t.perimeter() > 0);
  }

  @Test
  public void testAreaRightTriangle() {
    Triangle t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(6.0, t.area(), 1e-9); // 1/2*3*4
    assertTrue(t.area() >= 0);
  }

  @Test
  public void testCollinearAreaIsZero() {
    // collinear: y=x
    Triangle t = new Triangle(0, 0, 1, 1, 2, 2);
    assertEquals(0.0, t.area(), 1e-9);
    assertTrue(t.perimeter() > 0);
  }

  @Test
  public void testToString() {
    Triangle t = new Triangle(1, 2, 3, 4, 5, 6);
    String s = t.toString();
    assertTrue(s.contains("Triangle"));
    assertTrue(s.contains("(1.0, 2.0)"));
  }
}

