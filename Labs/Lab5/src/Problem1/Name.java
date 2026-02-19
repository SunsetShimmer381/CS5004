package Problem1;

/**
 * Represents an Artist's name (first + last).
 */
public class Name {
  private final String firstName;
  private final String lastName;

  public Name(String firstName, String lastName) {
    if (firstName == null || firstName.trim().isEmpty()) {
      throw new IllegalArgumentException("firstName cannot be null/empty");
    }
    if (lastName == null || lastName.trim().isEmpty()) {
      throw new IllegalArgumentException("lastName cannot be null/empty");
    }
    this.firstName = firstName.trim();
    this.lastName = lastName.trim();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}

