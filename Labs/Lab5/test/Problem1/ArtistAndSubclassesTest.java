package Problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistAndSubclassesTest {

  private static Name mkName() {
    return new Name("Taylor", "Swift");
  }

  private static String[] mkGenres() {
    return new String[] {"Pop", "Country"};
  }

  private static String[] mkAwards() {
    return new String[] {"Grammy"};
  }

  private static String[] mkMovies() {
    return new String[] {"MovieA"};
  }

  private static String[] mkSeries() {
    return new String[] {"SeriesA"};
  }

  private static String[] mkOther() {
    return new String[] {"MusicVideoA"};
  }

  private static String[] mkExhibits() {
    return new String[] {"ExhibitA", "ExhibitB"};
  }

  @Test
  public void testArtistAgeLowerBoundOk() {
    Actor a = new Actor(mkName(), 0, mkGenres(), mkAwards(), mkMovies(), mkSeries(), mkOther());
    assertEquals(0, a.getAge());
  }

  @Test
  public void testArtistAgeUpperBoundOk() {
    Actor a = new Actor(mkName(), 128, mkGenres(), mkAwards(), mkMovies(), mkSeries(), mkOther());
    assertEquals(128, a.getAge());
  }

  @Test
  public void testArtistAgeOutOfRangeThrows() {
    assertThrows(IllegalArgumentException.class,
        () -> new Actor(mkName(), -1, mkGenres(), mkAwards(), mkMovies(), mkSeries(), mkOther()));

    assertThrows(IllegalArgumentException.class,
        () -> new Actor(mkName(), 129, mkGenres(), mkAwards(), mkMovies(), mkSeries(), mkOther()));
  }

  @Test
  public void testReceiveAwardAppendsAndGrowsArray() {
    Actor a = new Actor(mkName(), 25, mkGenres(), mkAwards(), mkMovies(), mkSeries(), mkOther());

    assertArrayEquals(new String[] {"Grammy"}, a.getAwards());

    a.receiveAward("  Billboard  ");
    assertArrayEquals(new String[] {"Grammy", "Billboard"}, a.getAwards());

    a.receiveAward("AMA");
    assertArrayEquals(new String[] {"Grammy", "Billboard", "AMA"}, a.getAwards());
  }

  @Test
  public void testReceiveAwardInvalidInputThrows() {
    Actor a = new Actor(mkName(), 25, mkGenres(), mkAwards(), mkMovies(), mkSeries(), mkOther());
    assertThrows(IllegalArgumentException.class, () -> a.receiveAward(null));
    assertThrows(IllegalArgumentException.class, () -> a.receiveAward(""));
    assertThrows(IllegalArgumentException.class, () -> a.receiveAward("   "));
  }

  @Test
  public void testDefensiveCopyGenresNotExternallyMutable() {
    String[] genres = mkGenres();
    Actor a = new Actor(mkName(), 25, genres, mkAwards(), mkMovies(), mkSeries(), mkOther());

    // Mutate original array after construction
    genres[0] = "Hacked";
    assertArrayEquals(new String[] {"Pop", "Country"}, a.getGenres());

    // Mutate the returned array from getter
    String[] g2 = a.getGenres();
    g2[1] = "Hacked2";
    assertArrayEquals(new String[] {"Pop", "Country"}, a.getGenres());
  }

  @Test
  public void testDefensiveCopyAwardsNotExternallyMutable() {
    String[] awards = mkAwards();
    Actor a = new Actor(mkName(), 25, mkGenres(), awards, mkMovies(), mkSeries(), mkOther());

    // Mutate original awards after construction should not affect internal
    awards[0] = "HackedAward";
    assertArrayEquals(new String[] {"Grammy"}, a.getAwards());

    // Mutate returned awards array should not affect internal
    String[] a2 = a.getAwards();
    a2[0] = "HackedAward2";
    assertArrayEquals(new String[] {"Grammy"}, a.getAwards());
  }

  @Test
  public void testSubclassExtraFieldsStored() {
    Painter p = new Painter(mkName(), 40, mkGenres(), mkAwards(), mkExhibits());
    assertArrayEquals(new String[] {"ExhibitA", "ExhibitB"}, p.getExhibits());

    Musician m = new Musician(mkName(), 30, mkGenres(), mkAwards(), "Republic Records", "1989");
    assertEquals("Republic Records", m.getRecordingCompany());
    assertEquals("1989", m.getLastRecordAlbum());

    Poet poet = new Poet(mkName(), 35, mkGenres(), mkAwards(), "Penguin", "Collected Poems");
    assertEquals("Penguin", poet.getPublishingCompany());
    assertEquals("Collected Poems", poet.getLastPublishedCollection());
  }

  @Test
  public void testMusicianAndPoetInvalidStringsThrow() {
    assertThrows(IllegalArgumentException.class,
        () -> new Musician(mkName(), 30, mkGenres(), mkAwards(), null, "Album"));
    assertThrows(IllegalArgumentException.class,
        () -> new Musician(mkName(), 30, mkGenres(), mkAwards(), "  ", "Album"));
    assertThrows(IllegalArgumentException.class,
        () -> new Musician(mkName(), 30, mkGenres(), mkAwards(), "Label", null));
    assertThrows(IllegalArgumentException.class,
        () -> new Musician(mkName(), 30, mkGenres(), mkAwards(), "Label", "   "));

    assertThrows(IllegalArgumentException.class,
        () -> new Poet(mkName(), 35, mkGenres(), mkAwards(), null, "Collection"));
    assertThrows(IllegalArgumentException.class,
        () -> new Poet(mkName(), 35, mkGenres(), mkAwards(), "   ", "Collection"));
    assertThrows(IllegalArgumentException.class,
        () -> new Poet(mkName(), 35, mkGenres(), mkAwards(), "Publisher", null));
    assertThrows(IllegalArgumentException.class,
        () -> new Poet(mkName(), 35, mkGenres(), mkAwards(), "Publisher", "   "));
  }
}

