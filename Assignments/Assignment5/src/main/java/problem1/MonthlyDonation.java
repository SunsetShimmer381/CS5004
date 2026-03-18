package problem1;

import java.time.LocalDateTime;

public class MonthlyDonation extends Donation {
  private LocalDateTime cancellationDateTime;

  public MonthlyDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.cancellationDateTime = null;
  }

  public LocalDateTime getCancellationDateTime() {
    return cancellationDateTime;
  }

  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (cancellationDateTime != null
        && cancellationDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException(
          "Cancellation date/time cannot be before creation date/time.");
    }
    this.cancellationDateTime = cancellationDateTime;
  }

  @Override
  public double getDonationsForYear(int year) {
    int count = 0;
    LocalDateTime current = getCreationDateTime();

    while (current.getYear() <= year) {
      if (cancellationDateTime != null && current.isAfter(cancellationDateTime)) {
        break;
      }

      if (current.getYear() == year) {
        count++;
      }

      current = current.plusMonths(1);
    }

    return count * getAmount();
  }
}