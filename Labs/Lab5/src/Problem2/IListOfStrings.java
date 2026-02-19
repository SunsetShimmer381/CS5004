package Problem2;

/**
 * List of Strings ADT (linked list).
 *
 * Operations required by lab handout:
 * 1) isEmpty
 * 2) size
 * 3) contains
 * 4) containsAll
 * 5) filterLargerThan
 * 6) hasDuplicates
 * 7) removeDuplicates
 */
public interface IListOfStrings {
  boolean isEmpty();

  int size();

  boolean contains(String s);

  boolean containsAll(IListOfStrings other);

  /**
   * Returns a list with all elements whose length is greater than maxLen removed.
   * (i.e., keep strings with length <= maxLen)
   */
  IListOfStrings filterLargerThan(int maxLen);

  boolean hasDuplicates();

  /**
   * Returns the list with duplicates removed (keeps first occurrence).
   */
  IListOfStrings removeDuplicates();
}

