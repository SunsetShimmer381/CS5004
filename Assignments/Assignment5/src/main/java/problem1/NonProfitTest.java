package problem1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NonProfitTest {

  @Test
  public void testOneTimeDonationIncludedOnlyInCreationYear() {
    OneTimeDonation donation =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 2, 10, 12, 0));

    assertEquals(100.0, donation.getDonationsForYear(2026), 0.001);
    assertEquals(0.0, donation.getDonationsForYear(2025), 0.001);
    assertEquals(0.0, donation.getDonationsForYear(2027), 0.001);
  }

  @Test
  public void testMonthlyDonationWithoutCancellation() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 12, 0));

    assertEquals(110.0, donation.getDonationsForYear(2026), 0.001);
  }

  @Test
  public void testMonthlyDonationWithCancellation() {
    MonthlyDonation donation =
        new MonthlyDonation(25.0, LocalDateTime.of(2026, 2, 15, 17, 45));

    donation.setCancellationDateTime(LocalDateTime.of(2026, 5, 20, 0, 0));

    assertEquals(100.0, donation.getDonationsForYear(2026), 0.001);
  }

  @Test
  public void testMonthlyDonationCancellationBeforeCreationThrowsException() {
    MonthlyDonation donation =
        new MonthlyDonation(25.0, LocalDateTime.of(2026, 2, 15, 17, 45));

    assertThrows(IllegalArgumentException.class, () ->
        donation.setCancellationDateTime(LocalDateTime.of(2026, 1, 1, 0, 0)));
  }

  @Test
  public void testPledgeWithoutProcessingDateNotIncluded() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    assertEquals(0.0, pledge.getDonationsForYear(2026), 0.001);
    assertEquals(0.0, pledge.getDonationsForYear(2027), 0.001);
  }

  @Test
  public void testPledgeIncludedInProcessingYear() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    pledge.setProcessingDateTime(LocalDateTime.of(2027, 6, 1, 9, 0));

    assertEquals(0.0, pledge.getDonationsForYear(2026), 0.001);
    assertEquals(500.0, pledge.getDonationsForYear(2027), 0.001);
  }

  @Test
  public void testPledgeProcessingDateBeforeCreationThrowsException() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    assertThrows(IllegalArgumentException.class, () ->
        pledge.setProcessingDateTime(LocalDateTime.of(2026, 2, 1, 10, 0)));
  }

  @Test
  public void testNonProfitTotalDonationsForYear() {
    NonProfit nonProfit = new NonProfit("Helping Hands");

    OneTimeDonation oneTime =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 1, 10, 10, 0));

    MonthlyDonation monthly =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 12, 0));

    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 3, 1, 10, 0));
    pledge.setProcessingDateTime(LocalDateTime.of(2026, 7, 1, 9, 0));

    nonProfit.addDonation(oneTime);
    nonProfit.addDonation(monthly);
    nonProfit.addDonation(pledge);

    assertEquals(710.0, nonProfit.getTotalDonationsForYear(2026), 0.001);
  }

  @Test
  public void testNonProfitTotalDonationsForDifferentYear() {
    NonProfit nonProfit = new NonProfit("Helping Hands");

    OneTimeDonation oneTime =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 1, 10, 10, 0));

    MonthlyDonation monthly =
        new MonthlyDonation(20.0, LocalDateTime.of(2025, 11, 10, 12, 0));
    monthly.setCancellationDateTime(LocalDateTime.of(2026, 3, 15, 0, 0));

    Pledge pledge =
        new Pledge(300.0, LocalDateTime.of(2025, 5, 1, 10, 0));
    pledge.setProcessingDateTime(LocalDateTime.of(2026, 8, 1, 10, 0));

    nonProfit.addDonation(oneTime);
    nonProfit.addDonation(monthly);
    nonProfit.addDonation(pledge);

    assertEquals(460.0, nonProfit.getTotalDonationsForYear(2026), 0.001);
  }
}