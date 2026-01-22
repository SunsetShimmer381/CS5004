/**
 * CS50004 CSA 2025Fall
 * Lirui Liu
 * Lab 2
 */

public class Shoe {
  private Kind kind;
  private Brand brand;
  private Color color;
  private double size;

  /**
   * Constructor for Shoe object
   * @param kind The kind of shoe (Enum)
   * @param brand The brand of shoe (Enum)
   * @param color The color of shoe (Enum)
   * @param size The size of shoe (double)
   * @throws IllegalArgumentException if brand is NIKE and kind is DRESS
   */
  public Shoe(Kind kind, Brand brand, Color color, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("Nike does not make dress shoes!");
    }
    this.kind = kind;
    this.brand = brand;
    this.color = color;
    this.size = size;
  }

  public Kind getKind() { return this.kind;}
  public Brand getBrand() { return this.brand;}
  public Color getColor() { return this.color;}
  public double getSize() {return this.size;}

  public String toString() {
    String colorString;
    switch (this.color) {
      case BROWN:
        colorString = "Classic Brown";
        break;
      case WHITE:
        colorString = "Clean White";
        break;
      default:
        colorString = "Neutral";
        break;
    }
    return "Sheo: " + this.brand + " " + this.kind + " (" + colorString + "), Size: " + this.size;
  }
}
