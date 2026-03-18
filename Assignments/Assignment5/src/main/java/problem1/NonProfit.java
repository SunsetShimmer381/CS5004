package problem1;

import java.util.ArrayList;
import java.util.List;

public class NonProfit {
  private final String name;
  private final List<Donation> donations;

  public NonProfit(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Organization name cannot be null or blank.");
    }
    this.name = name;
    this.donations = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void addDonation(Donation donation) {
    if (donation == null) {
      throw new IllegalArgumentException("Donation cannot be null.");
    }
    donations.add(donation);
  }

  public void removeDonation(Donation donation) {
    donations.remove(donation);
  }

  public List<Donation> getDonations() {
    return new ArrayList<>(donations);
  }

  public double getTotalDonationsForYear(int year) {
    double total = 0.0;
    for (Donation donation : donations) {
      total += donation.getDonationsForYear(year);
    }
    return total;
  }
}
