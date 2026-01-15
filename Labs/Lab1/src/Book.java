
  /**
   * CS50004 CSA 2025Fall
   * Lirui Liu
   * Lab 1
   */

  public class Book {
    private String title;
    private String author;
    private String pages;

    public Book(String title, String author, String pages) {
      this.title = title;
      this.author = author;
      this.pages = pages;
    }

    public String getTitle() { return this.title;}
    public String getAuthor() { return this.author;}
    public String getPages() { return this.pages;}
  }
