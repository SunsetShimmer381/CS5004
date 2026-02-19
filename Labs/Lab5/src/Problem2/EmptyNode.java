package Problem2;

public class EmptyNode implements IListOfStrings {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean contains(String s) {
    if (s == null) {
      throw new IllegalArgumentException("String cannot be null");
    }
    return false;
  }

  @Override
  public boolean containsAll(IListOfStrings other) {
    if (other == null) {
      throw new IllegalArgumentException("other cannot be null");
    }
    // empty contains all of other only if other is empty
    return other.isEmpty();
  }

  @Override
  public IListOfStrings filterLargerThan(int maxLen) {
    return this;
  }

  @Override
  public boolean hasDuplicates() {
    return false;
  }

  @Override
  public IListOfStrings removeDuplicates() {
    return this;
  }
}

