import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BookTest {

  private Book book1;
  private Book book2;
  private Book book3;

  @BeforeEach
  void setUp() {
    this.book1 = new Book("The Story of Art", "Gombrich", "688");
    this.book2 = new Book("The Story of Art: Chinese Pocket Edition", "Gombrich and Others", "1006");
    this.book3 = new Book("Understanding and Insights from Gombrich", "Lirui Liu", "10");
  }

  @Test
  void getTitle() {
    Assertions.assertEquals("The Story of Art", this.book1.getTitle());
    Assertions.assertEquals("The Story of Art: Chinese Pocket Edition", this.book2.getTitle());
    Assertions.assertEquals("Understanding and Insights from Gombrich", this.book3.getTitle());
  }

  @Test
  void getAuthor() {
    Assertions.assertEquals("Gombrich", this.book1.getAuthor());
    Assertions.assertEquals("Gombrich and Others", this.book2.getAuthor());
    Assertions.assertEquals("Lirui Liu", this.book3.getAuthor());
  }

  @Test
  void getPages() {
    Assertions.assertEquals("688", this.book1.getPages());
    Assertions.assertEquals("1006", this.book2.getPages());
    Assertions.assertEquals("10", this.book3.getPages());
  }
}