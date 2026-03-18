package problem1;

import java.time.LocalDateTime;

public abstract class Donation {
  private final double amount;
  private final LocalDateTime creationDateTime;

  public Donation(double amount, LocalDateTime creationDateTime) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative.");
    }
    if (creationDateTime == null) {
      throw new IllegalArgumentException("Creation date/time cannot be null.");
    }
    this.amount = amount;
    this.creationDateTime = creationDateTime;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  public abstract double getDonationsForYear(int year);
}
