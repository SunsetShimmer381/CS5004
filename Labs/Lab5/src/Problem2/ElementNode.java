package Problem2;

public class ElementNode implements IListOfStrings {
  private final String first;
  private final IListOfStrings rest;

  public ElementNode(String first, IListOfStrings rest) {
    if (first == null) {
      throw new IllegalArgumentException("first cannot be null");
    }
    if (rest == null) {
      throw new IllegalArgumentException("rest cannot be null");
    }
    this.first = first;
    this.rest = rest;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 1 + rest.size();
  }

  @Override
  public boolean contains(String s) {
    if (s == null) {
      throw new IllegalArgumentException("String cannot be null");
    }
    return this.first.equals(s) || this.rest.contains(s);
  }

  @Override
  public boolean containsAll(IListOfStrings other) {
    if (other == null) {
      throw new IllegalArgumentException("other cannot be null");
    }
    // Check every element in "other" is contained in "this"
    if (other instanceof EmptyNode) {
      return true;
    }
    if (other instanceof ElementNode o) {
      return this.contains(o.first) && this.containsAll(o.rest);
    }
    // Fallback (shouldn't happen in this lab)
    return false;
  }

  @Override
  public IListOfStrings filterLargerThan(int maxLen) {
    if (this.first.length() > maxLen) {
      return this.rest.filterLargerThan(maxLen);
    }
    return new ElementNode(this.first, this.rest.filterLargerThan(maxLen));
  }

  @Override
  public boolean hasDuplicates() {
    // duplicate exists if "first" appears in rest OR rest has duplicates
    return this.rest.contains(this.first) || this.rest.hasDuplicates();
  }

  @Override
  public IListOfStrings removeDuplicates() {
    // Keep FIRST occurrence:
    // 1) keep first
    // 2) remove all later occurrences of first from rest
    // 3) recursively remove duplicates from the cleaned rest
    IListOfStrings cleanedRest = removeAllFrom(this.rest, this.first);
    return new ElementNode(this.first, cleanedRest.removeDuplicates());
  }

  // Removes ALL occurrences of target from list
  private static IListOfStrings removeAllFrom(IListOfStrings list, String target) {
    if (list instanceof EmptyNode) {
      return list;
    }
    if (list instanceof ElementNode e) {
      if (e.first.equals(target)) {
        return removeAllFrom(e.rest, target);
      }
      return new ElementNode(e.first, removeAllFrom(e.rest, target));
    }
    return list;
  }
}

