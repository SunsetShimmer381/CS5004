import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {

  private List<Vehicle> vehicles = new ArrayList<>();

  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Filters all vehicles manufactured before 1999 and returns a list
   * containing each vehicle's make, model, and year as a formatted string.
   *
   * @return a list of strings describing older vehicles
   */
  public List<String> filterOlderVehicles() {
    return vehicles.stream()
        .filter(vehicle -> vehicle.getYear() < 1999)
        .map(vehicle -> vehicle.getMake() + " "
            + vehicle.getModel() + " "
            + vehicle.getYear())
        .collect(Collectors.toList());
  }
}
