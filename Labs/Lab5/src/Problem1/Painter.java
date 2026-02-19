package Problem1;

/**
 * Concrete artist type: Painter.
 */
public class Painter extends VisualArtist {
  public Painter(
      Name name,
      Integer age,
      String[] genres,
      String[] awards,
      String[] exhibits
  ) {
    super(name, age, genres, awards, exhibits);
  }
}

