import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {

  private final Book b1 = new Book("A", "Auth1", 1999, 10.00f);
  private final Book b2 = new Book("B", "Auth2", 2005, 20.00f);
  private final Book b3 = new Book("C", "Auth3", 1980, 5.50f);

  private final IListOfBooks empty = new EmptyNode();
  private final IListOfBooks list1 = new ElementNode(b1, new EmptyNode());
  private final IListOfBooks list2 = new ElementNode(b1, new ElementNode(b2, new EmptyNode()));
  private final IListOfBooks list3 = new ElementNode(b1, new ElementNode(b2, new ElementNode(b3, new EmptyNode())));

  // ---------------- count(): 4 assertions total (2 tests x 2 assertions) ----------------

  @Test
  public void testCount_empty_basic() {
    assertEquals(0, empty.count());
    assertNotEquals(1, empty.count());
  }

  @Test
  public void testCount_nonEmpty_basic() {
    assertEquals(2, list2.count());
    assertEquals(3, list3.count());
  }

  // ---------------- totalPrice(): 4 assertions total ----------------

  @Test
  public void testTotalPrice_empty_basic() {
    assertEquals(0.0f, empty.totalPrice(), 0.0001f);
    assertTrue(empty.totalPrice() <= 0.0f);
  }

  @Test
  public void testTotalPrice_nonEmpty_basic() {
    assertEquals(30.0f, list2.totalPrice(), 0.0001f);
    assertEquals(35.5f, list3.totalPrice(), 0.0001f);
  }

  // ---------------- allBefore(int): 4 assertions total ----------------

  @Test
  public void testAllBefore_empty_basic() {
    IListOfBooks filtered = empty.allBefore(2000);
    assertEquals(0, filtered.count());
    assertEquals("[]", filtered.toString());
  }

  @Test
  public void testAllBefore_nonEmpty_filtersCorrectly() {
    // before 2000 should keep b1(1999) and b3(1980), remove b2(2005)
    IListOfBooks filtered = list3.allBefore(2000);
    assertEquals(2, filtered.count());
    assertTrue(filtered.toString().contains("Year: 1999") && filtered.toString().contains("Year: 1980"));
  }

  // ---------------- addAtEnd(Book): 4 assertions total ----------------

  @Test
  public void testAddAtEnd_empty_basic() {
    IListOfBooks result = empty.addAtEnd(b1);
    assertEquals(1, result.count());
    assertEquals(10.0f, result.totalPrice(), 0.0001f);
  }

  @Test
  public void testAddAtEnd_nonEmpty_basic() {
    IListOfBooks result = list2.addAtEnd(b3);
    assertEquals(3, result.count());
    assertEquals(35.5f, result.totalPrice(), 0.0001f);
  }

  // ---------------- toString(): 4 assertions total ----------------

  @Test
  public void testToString_empty_basic() {
    assertEquals("[]", empty.toString());
    assertTrue(empty.toString().startsWith("[") && empty.toString().endsWith("]"));
  }

  @Test
  public void testToString_nonEmpty_basic() {
    String s = list1.toString();
    assertTrue(s.contains("Title: A") && s.contains("Year: 1999"));
    assertTrue(s.startsWith("[") && s.endsWith("]"));
  }
}

