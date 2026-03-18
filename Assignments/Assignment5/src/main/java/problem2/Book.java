package problem2;

public class Book extends Item {
  private final Author author;

  public Book(String title, int year, Author author) {
    super(title, year);
    if (author == null) {
      throw new IllegalArgumentException("Author cannot be null.");
    }
    this.author = author;
  }

  @Override
  public Author getCreator() {
    return author;
  }

  public Author getAuthor() {
    return author;
  }
}
