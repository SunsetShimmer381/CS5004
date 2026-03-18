package problem2;

public class Music extends Item {
  private final Creator creator;

  public Music(String title, int year, Creator creator) {
    super(title, year);
    if (creator == null) {
      throw new IllegalArgumentException("Creator cannot be null.");
    }
    if (!(creator instanceof RecordingArtist) && !(creator instanceof Band)) {
      throw new IllegalArgumentException("Music creator must be a RecordingArtist or Band.");
    }
    this.creator = creator;
  }

  @Override
  public Creator getCreator() {
    return creator;
  }
}