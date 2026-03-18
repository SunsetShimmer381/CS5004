package problem2;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
  private final List<Item> items;

  public Catalog() {
    this.items = new ArrayList<>();
  }

  public Catalog(List<Item> items) {
    if (items == null) {
      throw new IllegalArgumentException("Items cannot be null.");
    }
    this.items = new ArrayList<>(items);
  }

  public void addItem(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null.");
    }
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public List<Item> getItems() {
    return new ArrayList<>(items);
  }

  public List<Item> search(String keyword) {
    List<Item> results = new ArrayList<>();
    if (keyword == null) {
      return results;
    }

    String lowerKeyword = keyword.toLowerCase();
    for (Item item : items) {
      if (item.getTitle().toLowerCase().contains(lowerKeyword)) {
        results.add(item);
      }
    }
    return results;
  }

  public List<Item> search(Author author) {
    List<Item> results = new ArrayList<>();
    if (author == null) {
      return results;
    }

    for (Item item : items) {
      if (item instanceof Book) {
        Book book = (Book) item;
        if (book.getAuthor().equals(author)) {
          results.add(book);
        }
      }
    }
    return results;
  }

  public List<Item> search(RecordingArtist artist) {
    List<Item> results = new ArrayList<>();
    if (artist == null) {
      return results;
    }

    for (Item item : items) {
      if (item instanceof Music) {
        Music music = (Music) item;
        Creator creator = music.getCreator();

        if (creator instanceof RecordingArtist) {
          if (creator.equals(artist)) {
            results.add(music);
          }
        } else if (creator instanceof Band) {
          Band band = (Band) creator;
          if (band.hasMember(artist)) {
            results.add(music);
          }
        }
      }
    }
    return results;
  }
}