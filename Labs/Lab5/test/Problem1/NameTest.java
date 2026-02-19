package Problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {

  @Test
  public void testValidNameStoresAndTrims() {
    Name n = new Name("  Ada ", " Lovelace  ");
    assertEquals("Ada", n.getFirstName());
    assertEquals("Lovelace", n.getLastName());
    assertEquals("Ada Lovelace", n.toString());
  }

  @Test
  public void testNullOrEmptyFirstNameThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Name(null, "Smith"));
    assertThrows(IllegalArgumentException.class, () -> new Name("", "Smith"));
    assertThrows(IllegalArgumentException.class, () -> new Name("   ", "Smith"));
  }

  @Test
  public void testNullOrEmptyLastNameThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Name("John", null));
    assertThrows(IllegalArgumentException.class, () -> new Name("John", ""));
    assertThrows(IllegalArgumentException.class, () -> new Name("John", "   "));
  }
}

