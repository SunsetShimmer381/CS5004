// Fraction.java

/**
 * Represents an immutable-ish fraction protocol with an integer numerator and a positive
 * integer denominator.
 *
 * <p>Implementations must maintain the class invariant that the denominator is always
 * positive. Negative values are represented by a negative numerator.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns this fraction's numerator.
   *
   * @return the numerator (may be negative, zero, or positive)
   */
  int getNumerator();

  /**
   * Returns this fraction's denominator.
   *
   * <p>The denominator is always strictly positive.
   *
   * @return the positive denominator
   */
  int getDenominator();

  /**
   * Sets this fraction's numerator.
   *
   * <p>This does not change the sign convention: the denominator remains positive.
   *
   * @param n the new numerator
   */
  void setNumerator(int n);

  /**
   * Sets this fraction's denominator.
   *
   * <p>Implementations must reject non-positive denominators to preserve the invariant
   * that denominators are always strictly positive.
   *
   * @param d the new denominator (must be {@code > 0})
   * @throws IllegalArgumentException if {@code d <= 0}
   */
  void setDenominator(int d);

  /**
   * Returns the decimal (scientific) value of this fraction.
   *
   * @return the value of {@code numerator / denominator} as a {@code double}
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction.
   *
   * <p>If this fraction is {@code n/d}, the reciprocal is {@code d/n}. The result must
   * still obey the sign convention (denominator positive).
   *
   * @return the reciprocal fraction
   * @throws IllegalArgumentException if the numerator is {@code 0} (reciprocal undefined)
   */
  Fraction reciprocal();

  /**
   * Returns the sum of this fraction and another fraction.
   *
   * <p>For {@code a/b + c/d}, the result is {@code (ad + bc) / bd}, then normalized and reduced.
   *
   * @param other the other fraction to add (must not be {@code null})
   * @return a new fraction equal to {@code this + other}
   * @throws IllegalArgumentException if {@code other} is {@code null}
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction to another fraction.
   *
   * <p>Returns a negative integer if {@code this < other}, a positive integer if
   * {@code this > other}, and {@code 0} if equal.
   *
   * @param other the other fraction (must not be {@code null})
   * @return comparison result per {@link Comparable}
   * @throws IllegalArgumentException if {@code other} is {@code null}
   */
  @Override
  int compareTo(Fraction other);
}

