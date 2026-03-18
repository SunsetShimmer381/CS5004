package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Band extends Group {
  private final String name;
  private final List<RecordingArtist> members;

  public Band(String name, List<RecordingArtist> members) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Band name cannot be null or blank.");
    }
    if (members == null) {
      throw new IllegalArgumentException("Members cannot be null.");
    }
    this.name = name;
    this.members = new ArrayList<>(members);
  }

  public String getName() {
    return name;
  }

  public List<RecordingArtist> getMembers() {
    return new ArrayList<>(members);
  }

  public boolean hasMember(RecordingArtist artist) {
    return members.contains(artist);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Band)) return false;
    Band band = (Band) o;
    return name.equals(band.name) && members.equals(band.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }

  @Override
  public String toString() {
    return name;
  }
}
