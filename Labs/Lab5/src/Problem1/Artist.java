package Problem1;

import java.util.Arrays;

/**
 * Base abstract class for all artists.
 *
 * Required fields (per handout):
 * - Name
 * - Age: Integer in [0, 128]
 * - Genres: String[]
 * - Awards: String[]
 *
 * Required behavior:
 * - void receiveAward(String award)
 */
public abstract class Artist {
  private final Name name;
  private final Integer age;     // strictly Integer, per requirements
  private final String[] genres; // strictly String[]
  private String[] awards;       // must be mutable because receiveAward appends

  protected Artist(Name name, Integer age, String[] genres, String[] awards) {
    if (name == null) {
      throw new IllegalArgumentException("name cannot be null");
    }
    if (age == null) {
      throw new IllegalArgumentException("age cannot be null");
    }
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("age must be in [0, 128]");
    }
    if (genres == null) {
      throw new IllegalArgumentException("genres cannot be null");
    }
    if (awards == null) {
      throw new IllegalArgumentException("awards cannot be null");
    }

    this.name = name;
    this.age = age;
    this.genres = Arrays.copyOf(genres, genres.length);
    this.awards = Arrays.copyOf(awards, awards.length);
  }

  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String[] getGenres() {
    return Arrays.copyOf(genres, genres.length);
  }

  public String[] getAwards() {
    return Arrays.copyOf(awards, awards.length);
  }

  /**
   * Adds a new award to the current awards array (arrays are fixed-size).
   */
  public void receiveAward(String award) {
    if (award == null || award.trim().isEmpty()) {
      throw new IllegalArgumentException("award cannot be null/empty");
    }
    String[] newAwards = new String[this.awards.length + 1];
    for (int i = 0; i < this.awards.length; i++) {
      newAwards[i] = this.awards[i];
    }
    newAwards[this.awards.length] = award.trim();
    this.awards = newAwards;
  }
}

