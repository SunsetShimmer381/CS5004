package Problem1;

/**
 * Concrete artist type: Musician.
 *
 * Required extra fields:
 * - Recording company: String
 * - Last record album: String
 */
public class Musician extends Artist {
  private final String recordingCompany;
  private final String lastRecordAlbum;

  public Musician(
      Name name,
      Integer age,
      String[] genres,
      String[] awards,
      String recordingCompany,
      String lastRecordAlbum
  ) {
    super(name, age, genres, awards);

    if (recordingCompany == null || recordingCompany.trim().isEmpty()) {
      throw new IllegalArgumentException("recordingCompany cannot be null/empty");
    }
    if (lastRecordAlbum == null || lastRecordAlbum.trim().isEmpty()) {
      throw new IllegalArgumentException("lastRecordAlbum cannot be null/empty");
    }

    this.recordingCompany = recordingCompany.trim();
    this.lastRecordAlbum = lastRecordAlbum.trim();
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }
}

