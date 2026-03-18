package problem1;

import java.time.LocalDateTime;

public class OneTimeDonation extends Donation {

  public OneTimeDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  @Override
  public double getDonationsForYear(int year) {
    return getCreationDateTime().getYear() == year ? getAmount() : 0.0;
  }
}
