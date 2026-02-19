package Problem1;

import java.util.Arrays;

/**
 * Shared abstract class for Painter and Photographer.
 *
 * Required extra field:
 * - Exhibits: String[]
 */
public abstract class VisualArtist extends Artist {
  private final String[] exhibits;

  protected VisualArtist(Name name, Integer age, String[] genres, String[] awards, String[] exhibits) {
    super(name, age, genres, awards);

    if (exhibits == null) {
      throw new IllegalArgumentException("exhibits cannot be null");
    }
    this.exhibits = Arrays.copyOf(exhibits, exhibits.length);
  }

  public String[] getExhibits() {
    return Arrays.copyOf(exhibits, exhibits.length);
  }
}

