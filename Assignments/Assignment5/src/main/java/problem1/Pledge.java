package problem1;

import java.time.LocalDateTime;

public class Pledge extends Donation {
  private LocalDateTime processingDateTime;

  public Pledge(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.processingDateTime = null;
  }

  public Pledge(double amount, LocalDateTime creationDateTime, LocalDateTime processingDateTime) {
    super(amount, creationDateTime);
    setProcessingDateTime(processingDateTime);
  }

  public LocalDateTime getProcessingDateTime() {
    return processingDateTime;
  }

  public void setProcessingDateTime(LocalDateTime processingDateTime) {
    if (processingDateTime != null
        && processingDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException(
          "Processing date/time cannot be before creation date/time.");
    }
    this.processingDateTime = processingDateTime;
  }

  @Override
  public double getDonationsForYear(int year) {
    if (processingDateTime != null && processingDateTime.getYear() == year) {
      return getAmount();
    }
    return 0.0;
  }
}
