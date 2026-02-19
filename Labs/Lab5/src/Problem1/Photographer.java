package Problem1;

/**
 * Concrete artist type: Photographer.
 */
public class Photographer extends VisualArtist {
  public Photographer(
      Name name,
      Integer age,
      String[] genres,
      String[] awards,
      String[] exhibits
  ) {
    super(name, age, genres, awards, exhibits);
  }
}

