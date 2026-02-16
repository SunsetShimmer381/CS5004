// FractionImpl.java

import java.util.Objects;

/**
 * Concrete implementation of {@link Fraction}.
 *
 * <p>Invariant: denominator is always strictly positive. Negative values are represented
 * by the numerator being negative.
 */
public final class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a fraction with the given numerator and denominator.
   *
   * <p>The denominator must be positive. If a negative value is desired, the numerator
   * should be negative (this class will also normalize signs so the denominator stays positive).
   *
   * @param numerator the numerator (may be negative, zero, or positive)
   * @param denominator the denominator (must be {@code > 0})
   * @throws IllegalArgumentException if {@code denominator <= 0}
   */
  public FractionImpl(int numerator, int denominator) {
    validateDenominator(denominator);
    this.numerator = numerator;
    this.denominator = denominator;
    normalizeInPlace();
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    this.numerator = n;
    normalizeInPlace();
  }

  @Override
  public void setDenominator(int d) {
    validateDenominator(d);
    this.denominator = d;
    normalizeInPlace();
  }

  @Override
  public double toDouble() {
    return ((double) numerator) / ((double) denominator);
  }

  @Override
  public Fraction reciprocal() {
    if (this.numerator == 0) {
      throw new IllegalArgumentException("Cannot take reciprocal of zero.");
    }

    int newNumerator = this.denominator;
    int newDenominator = this.numerator;

    // 保证 denominator 始终为正
    if (newDenominator < 0) {
      newNumerator = -newNumerator;
      newDenominator = -newDenominator;
    }

    return new FractionImpl(newNumerator, newDenominator);
  }


  @Override
  public Fraction add(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Other fraction must not be null.");
    }

    // Use long to reduce overflow risk in intermediate multiplication.
    long a = this.numerator;
    long b = this.denominator;
    long c = other.getNumerator();
    long d = other.getDenominator();

    long newNum = a * d + c * b;
    long newDen = b * d;

    // Convert back to int; if overflow matters in your course, you could throw instead.
    return new FractionImpl((int) newNum, (int) newDen);
  }

  @Override
  public int compareTo(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Other fraction must not be null.");
    }

    // Compare a/b and c/d by comparing ad and cb; use long to reduce overflow risk.
    long left = ((long) this.numerator) * ((long) other.getDenominator());
    long right = ((long) other.getNumerator()) * ((long) this.denominator);
    return Long.compare(left, right);
  }

  /**
   * Returns a string representing this fraction in simplest form: "n / d".
   *
   * <p>Examples:
   * <ul>
   *   <li>4/2 becomes "2 / 1"</li>
   *   <li>-3/6 becomes "-1 / 2"</li>
   *   <li>0/5 becomes "0 / 1"</li>
   * </ul>
   *
   * @return simplest-form string for this fraction
   */
  @Override
  public String toString() {
    // normalizeInPlace always keeps it reduced; this is just defensive.
    int n = numerator;
    int d = denominator;
    int g = gcd(Math.abs(n), d);
    n /= g;
    d /= g;
    if (n == 0) {
      d = 1;
    }
    return n + " / " + d;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Fraction)) {
      return false;
    }
    Fraction other = (Fraction) o;
    // Compare by normalized simplest form via cross-multiplication.
    return this.compareTo(other) == 0;
  }

  @Override
  public int hashCode() {
    // Use simplest form for stable hash.
    int n = numerator;
    int d = denominator;
    int g = gcd(Math.abs(n), d);
    n /= g;
    d /= g;
    if (n == 0) {
      d = 1;
    }
    return Objects.hash(n, d);
  }

  /**
   * Validates the denominator according to the class invariant.
   */
  private static void validateDenominator(int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
  }

  /**
   * Normalizes the internal representation:
   * - Keeps denominator positive
   * - Reduces to simplest terms using gcd
   * - Canonicalizes zero to 0/1
   */
  private void normalizeInPlace() {
    // Denominator is already validated to be positive in constructor/setter.
    if (numerator == 0) {
      denominator = 1;
      return;
    }

    // Reduce by gcd. We use abs(numerator) so gcd is non-negative.
    int g = gcd(Math.abs(numerator), denominator);
    numerator /= g;
    denominator /= g;

    // Ensure denominator is positive (defensive; should already be positive).
    if (denominator < 0) {
      denominator = -denominator;
      numerator = -numerator;
    }
  }

  /**
   * Returns the greatest common divisor (GCD) of two non-negative integers using
   * Euclid's algorithm.
   *
   * <p>Note: callers should pass non-negative values; this method treats gcd(a, 0) = a.
   */
  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}

