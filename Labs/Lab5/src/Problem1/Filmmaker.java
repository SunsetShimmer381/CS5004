package Problem1;

/**
 * Concrete artist type: Filmmaker.
 */
public class Filmmaker extends PerformingArtist {
  public Filmmaker(
      Name name,
      Integer age,
      String[] genres,
      String[] awards,
      String[] movies,
      String[] series,
      String[] otherMultimedia
  ) {
    super(name, age, genres, awards, movies, series, otherMultimedia);
  }
}

