import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {
  private Shoe mySneaker;
  private Shoe myBoots;

  @BeforeEach
  void setUp(){
    mySneaker = new Shoe(Kind.SNEAKER, Brand.NIKE, Color.WHITE, 9.5);
    myBoots = new Shoe(Kind.BOOTS, Brand.PUMA, Color.BROWN, 10.0);
  }

  @Test
  void testConstructor(){
    assertNotNull(mySneaker);
    assertEquals(Kind.SNEAKER, mySneaker.getKind());
    assertThrows(IllegalArgumentException.class, () -> {
      new Shoe(Kind.DRESS, Brand.NIKE, Color.BLACK, 8.0);
    }, "Should throw exception when creating Nike Dress shoes");
  }

  @org.junit.jupiter.api.Test
  void testGetKind() {
    assertEquals(Kind.SNEAKER, mySneaker.getKind());
    assertEquals(Kind.BOOTS, myBoots.getKind());
  }

  @org.junit.jupiter.api.Test
  void testGetBrand() {
    assertEquals(Brand.NIKE, mySneaker.getBrand());
    assertEquals(Brand.PUMA, myBoots.getBrand());
  }

  @org.junit.jupiter.api.Test
  void testGetColor() {
    assertEquals(Color.WHITE, mySneaker.getColor());
    assertEquals(Color.BROWN, myBoots.getColor());
  }

  @org.junit.jupiter.api.Test
  void testGetSize() {
    assertEquals(9.5, mySneaker.getSize(), 0.01);
    assertEquals(10.0, myBoots.getSize(), 0.01);
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    String sneakerString = mySneaker.toString();
    assertTrue(sneakerString.contains("NIKE"));
    assertTrue(sneakerString.contains("SNEAKER"));
    assertTrue(sneakerString.contains("Clean White") || sneakerString.contains("WHITE"));
  }
}