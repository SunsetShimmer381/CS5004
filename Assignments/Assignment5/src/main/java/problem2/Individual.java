package problem2;

import java.util.Objects;

public abstract class Individual extends Creator {
  private final String firstName;
  private final String lastName;

  public Individual(String firstName, String lastName) {
    if (firstName == null || lastName == null
        || firstName.isBlank() || lastName.isBlank()) {
      throw new IllegalArgumentException("Names cannot be null or blank.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Individual that = (Individual) o;
    return firstName.equals(that.firstName) && lastName.equals(that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, getClass());
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
