package problem2;

public abstract class Item {
  private final String title;
  private final int year;

  public Item(String title, int year) {
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("Title cannot be null or blank.");
    }
    this.title = title;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  public abstract Creator getCreator();
}
