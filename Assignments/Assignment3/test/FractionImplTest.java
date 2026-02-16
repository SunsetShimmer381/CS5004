// FractionImplTest.java

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit5 tests for {@link FractionImpl}.
 *
 * <p>Tests cover normal behavior, simplification/normalization, negatives, and exceptional cases.
 */
public class FractionImplTest {

  // -------------------------
  // Constructor tests
  // -------------------------

  @Test
  @DisplayName("Constructor: reduces to simplest form and keeps denominator positive")
  void constructorReducesAndNormalizes() {
    Fraction f = new FractionImpl(4, 2);
    assertEquals(2, f.getNumerator());
    assertEquals(1, f.getDenominator());
    assertEquals("2 / 1", f.toString());
  }

  @Test
  @DisplayName("Constructor: handles negative numerator correctly")
  void constructorNegativeNumerator() {
    Fraction f = new FractionImpl(-3, 6);
    assertEquals(-1, f.getNumerator());
    assertEquals(2, f.getDenominator());
    assertEquals("-1 / 2", f.toString());
  }

  @Test
  @DisplayName("Constructor: canonicalizes zero numerator to 0/1")
  void constructorZeroNumerator() {
    Fraction f = new FractionImpl(0, 5);
    assertEquals(0, f.getNumerator());
    assertEquals(1, f.getDenominator());
    assertEquals("0 / 1", f.toString());
  }

  @Test
  @DisplayName("Constructor: throws when denominator is zero or negative")
  void constructorInvalidDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, -3));
  }

  // -------------------------
  // Getter / Setter tests
  // -------------------------

  @Test
  @DisplayName("Setters: setNumerator updates value and re-normalizes")
  void setNumeratorRenormalizes() {
    FractionImpl f = new FractionImpl(2, 4); // becomes 1/2
    assertEquals("1 / 2", f.toString());

    f.setNumerator(3); // 3/2
    assertEquals(3, f.getNumerator());
    assertEquals(2, f.getDenominator());
    assertEquals("3 / 2", f.toString());
  }

  @Test
  @DisplayName("Setters: setDenominator rejects non-positive values and preserves invariant")
  void setDenominatorRejectsNonPositive() {
    FractionImpl f = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(-5));

    // Invariant preserved after failed set attempts.
    assertEquals(1, f.getNumerator());
    assertEquals(2, f.getDenominator());
  }

  @Test
  @DisplayName("Setters: setDenominator triggers reduction")
  void setDenominatorTriggersReduction() {
    FractionImpl f = new FractionImpl(2, 3);
    f.setDenominator(6); // 2/6 reduces to 1/3
    assertEquals(1, f.getNumerator());
    assertEquals(3, f.getDenominator());
    assertEquals("1 / 3", f.toString());
  }

  // -------------------------
  // toDouble tests
  // -------------------------

  @Test
  @DisplayName("toDouble: computes correct decimal value for positive and negative fractions")
  void toDoubleWorks() {
    assertEquals(0.5, new FractionImpl(1, 2).toDouble(), 1e-12);
    assertEquals(-0.25, new FractionImpl(-1, 4).toDouble(), 1e-12);
  }

  // -------------------------
  // toString tests
  // -------------------------

  @Test
  @DisplayName("toString: always returns simplest form with spaces around '/'")
  void toStringSimplifies() {
    assertEquals("2 / 1", new FractionImpl(4, 2).toString());
    assertEquals("-1 / 2", new FractionImpl(-3, 6).toString());
    assertEquals("0 / 1", new FractionImpl(0, 99).toString());
  }

  // -------------------------
  // gcd tests (package-private static)
  // -------------------------

  @Test
  @DisplayName("gcd: handles zeros and typical values")
  void gcdWorks() {
    assertEquals(6, FractionImpl.gcd(54, 24));
    assertEquals(5, FractionImpl.gcd(5, 0));
    assertEquals(7, FractionImpl.gcd(0, 7)); // with this recursive version, gcd(0,7)=gcd(7,0)=7
  }

  // -------------------------
  // reciprocal tests
  // -------------------------

  @Test
  @DisplayName("reciprocal: flips numerator/denominator and normalizes sign")
  void reciprocalWorks() {
    Fraction f = new FractionImpl(2, 3).reciprocal();
    assertEquals(3, f.getNumerator());
    assertEquals(2, f.getDenominator());
    assertEquals("3 / 2", f.toString());

    Fraction g = new FractionImpl(-1, 4).reciprocal();
    assertEquals(-4, g.getNumerator());
    assertEquals(1, g.getDenominator());
    assertEquals("-4 / 1", g.toString());
  }

  @Test
  @DisplayName("reciprocal: throws for zero numerator")
  void reciprocalThrowsOnZeroNumerator() {
    FractionImpl f = new FractionImpl(0, 5);
    assertThrows(IllegalArgumentException.class, f::reciprocal);
  }

  // -------------------------
  // add tests
  // -------------------------

  @Test
  @DisplayName("add: same denominator")
  void addSameDenominator() {
    Fraction a = new FractionImpl(1, 5);
    Fraction b = new FractionImpl(2, 5);
    Fraction sum = a.add(b);
    assertEquals("3 / 5", sum.toString());
  }

  @Test
  @DisplayName("add: different denominators with reduction")
  void addDifferentDenominators() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(1, 3);
    Fraction sum = a.add(b); // 5/6
    assertEquals(5, sum.getNumerator());
    assertEquals(6, sum.getDenominator());
    assertEquals("5 / 6", sum.toString());
  }

  @Test
  @DisplayName("add: handles negatives and zero")
  void addNegativesAndZero() {
    Fraction a = new FractionImpl(-1, 2);
    Fraction b = new FractionImpl(1, 4);
    assertEquals("-1 / 4", a.add(b).toString());

    Fraction zero = new FractionImpl(0, 7);
    assertEquals("-1 / 2", a.add(zero).toString());
  }

  @Test
  @DisplayName("add: throws on null argument")
  void addThrowsOnNull() {
    Fraction a = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class, () -> a.add(null));
  }

  // -------------------------
  // compareTo tests
  // -------------------------

  @Test
  @DisplayName("compareTo: equal fractions compare as 0")
  void compareToEqual() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(2, 4);
    assertEquals(0, a.compareTo(b));
    assertEquals(0, b.compareTo(a));
  }

  @Test
  @DisplayName("compareTo: less/greater across signs")
  void compareToLessGreater() {
    Fraction neg = new FractionImpl(-1, 2);
    Fraction pos = new FractionImpl(1, 3);
    assertTrue(neg.compareTo(pos) < 0);
    assertTrue(pos.compareTo(neg) > 0);
  }

  @Test
  @DisplayName("compareTo: works without double rounding")
  void compareToNoRounding() {
    Fraction a = new FractionImpl(1, 3);
    Fraction b = new FractionImpl(2, 5);
    assertTrue(a.compareTo(b) < 0); // 0.333.. < 0.4
  }

  @Test
  @DisplayName("compareTo: throws on null argument")
  void compareToThrowsOnNull() {
    Fraction a = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class, () -> a.compareTo(null));
  }
}

