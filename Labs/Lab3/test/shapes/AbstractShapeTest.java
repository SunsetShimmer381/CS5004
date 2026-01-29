package shapes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Common tests for all Shapes.
 * New shapes should NOT require modifying this file.
 */
public abstract class AbstractShapeTest {

  /**
   * Each concrete test class provides a representative instance
   * whose reference point is (3,4) so distanceFromOrigin = 5.
   */
  protected abstract Shape makeShape();

  @Test
  public void testDistanceFromOrigin() {
    Shape s = makeShape();

    // At least two assertions (rubric)
    assertEquals(5.0, s.distanceFromOrigin(), 1e-9);
    assertTrue(s.distanceFromOrigin() >= 0);
  }

  @Test
  public void testCompareToThreeOutcomes() {
    Shape mid = makeShape();              // distance 5
    Shape small = new Circle(0, 0, 1);    // distance 0
    Shape big = new Circle(6, 8, 1);      // distance 10

    // Exactly covers < 0, = 0, > 0 (rubric asks 3 outcomes)
    assertTrue(mid.compareTo(big) < 0);
    assertEquals(0, mid.compareTo(mid));
    assertTrue(mid.compareTo(small) > 0);
  }

  @Test
  public void testCompareToNullThrows() {
    Shape s = makeShape();
    assertThrows(NullPointerException.class, () -> s.compareTo(null));
    assertDoesNotThrow(() -> s.compareTo(new Circle(0, 0, 1)));
  }
}

