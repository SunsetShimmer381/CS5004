import org.junit.jupiter.api.Assertions;

class PersonTest {

  private Person alex;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    this.alex = new Person("Alex White", "alex.white@gmail.com", "San Jose, CA, USA");
  }

  @org.junit.jupiter.api.Test
  void getName() {
    Assertions.assertEquals("Alex White", this.alex.getName());
  }

  @org.junit.jupiter.api.Test
  void getEmail() {
    Assertions.fail("Not yet implemented");
  }

  @org.junit.jupiter.api.Test
  void getAddress() {
    Assertions.fail("Not yet implemented");
  }
}