package Problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IListOfStringsTest {

  private IListOfStrings empty() {
    return new EmptyNode();
  }

  private IListOfStrings list(String... items) {
    IListOfStrings acc = empty();
    // build from back to front
    for (int i = items.length - 1; i >= 0; i--) {
      acc = new ElementNode(items[i], acc);
    }
    return acc;
  }

  @Test
  public void testIsEmptyAndSize() {
    assertTrue(empty().isEmpty());
    assertEquals(0, empty().size());

    IListOfStrings xs = list("a", "bb", "ccc");
    assertFalse(xs.isEmpty());
    assertEquals(3, xs.size());
  }

  @Test
  public void testContains() {
    IListOfStrings xs = list("a", "bb", "ccc");
    assertTrue(xs.contains("a"));
    assertTrue(xs.contains("bb"));
    assertFalse(xs.contains("dddd"));

    assertThrows(IllegalArgumentException.class, () -> xs.contains(null));
    assertThrows(IllegalArgumentException.class, () -> empty().contains(null));
  }

  @Test
  public void testContainsAll() {
    IListOfStrings xs = list("a", "bb", "ccc", "bb");
    assertTrue(xs.containsAll(empty()));
    assertTrue(xs.containsAll(list("a")));
    assertTrue(xs.containsAll(list("bb", "ccc")));
    assertFalse(xs.containsAll(list("bb", "zzz")));

    assertThrows(IllegalArgumentException.class, () -> xs.containsAll(null));
    assertThrows(IllegalArgumentException.class, () -> empty().containsAll(null));
  }

  @Test
  public void testFilterLargerThan() {
    IListOfStrings xs = list("a", "bb", "ccc", "dddd", "ee");
    // keep length <= 2 -> "a", "bb", "ee"
    IListOfStrings filtered = xs.filterLargerThan(2);

    assertEquals(3, filtered.size());
    assertTrue(filtered.contains("a"));
    assertTrue(filtered.contains("bb"));
    assertTrue(filtered.contains("ee"));
    assertFalse(filtered.contains("ccc"));
    assertFalse(filtered.contains("dddd"));

    // filtering an empty list stays empty
    assertTrue(empty().filterLargerThan(10).isEmpty());
  }

  @Test
  public void testHasDuplicates() {
    assertFalse(empty().hasDuplicates());
    assertFalse(list("a", "bb", "ccc").hasDuplicates());
    assertTrue(list("a", "bb", "a").hasDuplicates());
    assertTrue(list("x", "y", "y", "z").hasDuplicates());
  }

  @Test
  public void testRemoveDuplicatesKeepsFirstOccurrence() {
    IListOfStrings xs = list("a", "bb", "a", "ccc", "bb", "bb");
    IListOfStrings dedup = xs.removeDuplicates();

    // expected order keeping first occurrences: a, bb, ccc
    assertEquals(3, dedup.size());
    assertTrue(dedup.contains("a"));
    assertTrue(dedup.contains("bb"));
    assertTrue(dedup.contains("ccc"));

    // no duplicates remain
    assertFalse(dedup.hasDuplicates());

    // already unique stays same size and still contains all
    IListOfStrings ys = list("p", "q", "r");
    IListOfStrings ys2 = ys.removeDuplicates();
    assertEquals(3, ys2.size());
    assertTrue(ys2.containsAll(ys));
  }
}

