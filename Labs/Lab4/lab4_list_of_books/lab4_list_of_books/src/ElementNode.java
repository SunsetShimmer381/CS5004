public class ElementNode implements IListOfBooks {
  private final Book first;
  private final IListOfBooks rest;

  public ElementNode(Book first, IListOfBooks rest) {
    this.first = first;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + this.rest.count();
  }

  @Override
  public float totalPrice() {
    return this.first.getPrice() + this.rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (this.first.before(year)) {
      return new ElementNode(this.first, this.rest.allBefore(year));
    }
    return this.rest.allBefore(year);
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(this.first, this.rest.addAtEnd(book));
  }

  @Override
  public String toString() {
    return "[" + this.first.toString() + ", " + this.rest.toString() + "]";
  }
}

