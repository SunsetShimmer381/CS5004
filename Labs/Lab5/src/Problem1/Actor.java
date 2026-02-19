package Problem1;

/**
 * Concrete artist type: Actor.
 */
public class Actor extends PerformingArtist {
  public Actor(
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

