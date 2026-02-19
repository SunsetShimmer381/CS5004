package Problem1;

import java.util.Arrays;

/**
 * Shared abstract class for Actor, Dancer, Filmmaker.
 *
 * Required extra fields:
 * - Movies: String[]
 * - Series: String[]
 * - Other multimedia: String[]
 */
public abstract class PerformingArtist extends Artist {
  private final String[] movies;
  private final String[] series;
  private final String[] otherMultimedia;

  protected PerformingArtist(
      Name name,
      Integer age,
      String[] genres,
      String[] awards,
      String[] movies,
      String[] series,
      String[] otherMultimedia
  ) {
    super(name, age, genres, awards);

    if (movies == null) {
      throw new IllegalArgumentException("movies cannot be null");
    }
    if (series == null) {
      throw new IllegalArgumentException("series cannot be null");
    }
    if (otherMultimedia == null) {
      throw new IllegalArgumentException("otherMultimedia cannot be null");
    }

    this.movies = Arrays.copyOf(movies, movies.length);
    this.series = Arrays.copyOf(series, series.length);
    this.otherMultimedia = Arrays.copyOf(otherMultimedia, otherMultimedia.length);
  }

  public String[] getMovies() {
    return Arrays.copyOf(movies, movies.length);
  }

  public String[] getSeries() {
    return Arrays.copyOf(series, series.length);
  }

  public String[] getOtherMultimedia() {
    return Arrays.copyOf(otherMultimedia, otherMultimedia.length);
  }
}

