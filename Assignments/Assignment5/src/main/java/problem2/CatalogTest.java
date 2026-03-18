package problem2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogTest {

  @Test
  public void testSearchByKeywordCaseInsensitive() {
    Author author = new Author("Jane", "Austen");
    RecordingArtist artist = new RecordingArtist("Taylor", "Swift");

    Book book = new Book("Pride and Prejudice", 1813, author);
    Music music = new Music("All Too Well", 2021, artist);

    Catalog catalog = new Catalog();
    catalog.addItem(book);
    catalog.addItem(music);

    List<Item> results = catalog.search("a");

    assertEquals(2, results.size());
    assertTrue(results.contains(book));
    assertTrue(results.contains(music));
  }

  @Test
  public void testSearchByKeywordReturnsOnlyMatchingTitles() {
    Author author = new Author("George", "Orwell");
    RecordingArtist artist = new RecordingArtist("Adele", "Adkins");

    Book book = new Book("1984", 1949, author);
    Music music = new Music("Hello", 2015, artist);

    Catalog catalog = new Catalog();
    catalog.addItem(book);
    catalog.addItem(music);

    List<Item> results = catalog.search("hell");

    assertEquals(1, results.size());
    assertTrue(results.contains(music));
  }

  @Test
  public void testSearchByAuthor() {
    Author author1 = new Author("Jane", "Austen");
    Author author2 = new Author("George", "Orwell");

    Book book1 = new Book("Emma", 1815, author1);
    Book book2 = new Book("1984", 1949, author2);

    Catalog catalog = new Catalog();
    catalog.addItem(book1);
    catalog.addItem(book2);

    List<Item> results = catalog.search(author1);

    assertEquals(1, results.size());
    assertTrue(results.contains(book1));
  }

  @Test
  public void testSearchByRecordingArtistAsSoloCreator() {
    RecordingArtist artist1 = new RecordingArtist("Taylor", "Swift");
    RecordingArtist artist2 = new RecordingArtist("Adele", "Adkins");

    Music music1 = new Music("Lover", 2019, artist1);
    Music music2 = new Music("Hello", 2015, artist2);

    Catalog catalog = new Catalog();
    catalog.addItem(music1);
    catalog.addItem(music2);

    List<Item> results = catalog.search(artist1);

    assertEquals(1, results.size());
    assertTrue(results.contains(music1));
  }

  @Test
  public void testSearchByRecordingArtistAsBandMember() {
    RecordingArtist artist1 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist2 = new RecordingArtist("Paul", "McCartney");
    Band band = new Band("The Beatles", Arrays.asList(artist1, artist2));

    Music music = new Music("Hey Jude", 1968, band);

    Catalog catalog = new Catalog();
    catalog.addItem(music);

    List<Item> results = catalog.search(artist1);

    assertEquals(1, results.size());
    assertTrue(results.contains(music));
  }

  @Test
  public void testAddAndRemoveItem() {
    Author author = new Author("F. Scott", "Fitzgerald");
    Book book = new Book("The Great Gatsby", 1925, author);

    Catalog catalog = new Catalog();
    catalog.addItem(book);
    assertEquals(1, catalog.getItems().size());

    catalog.removeItem(book);
    assertEquals(0, catalog.getItems().size());
  }

  @Test
  public void testCatalogConstructorWithItems() {
    Author author = new Author("J.R.R.", "Tolkien");
    RecordingArtist artist = new RecordingArtist("Ed", "Sheeran");

    Book book = new Book("The Hobbit", 1937, author);
    Music music = new Music("Shape of You", 2017, artist);

    Catalog catalog = new Catalog(Arrays.asList(book, music));

    assertEquals(2, catalog.getItems().size());
    assertTrue(catalog.getItems().contains(book));
    assertTrue(catalog.getItems().contains(music));
  }
}