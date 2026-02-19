package Problem1;

/**
 * Concrete artist type: Poet.
 *
 * Required extra fields:
 * - Publishing company: String
 * - Last published collection: String
 */
public class Poet extends Artist {
  private final String publishingCompany;
  private final String lastPublishedCollection;

  public Poet(
      Name name,
      Integer age,
      String[] genres,
      String[] awards,
      String publishingCompany,
      String lastPublishedCollection
  ) {
    super(name, age, genres, awards);

    if (publishingCompany == null || publishingCompany.trim().isEmpty()) {
      throw new IllegalArgumentException("publishingCompany cannot be null/empty");
    }
    if (lastPublishedCollection == null || lastPublishedCollection.trim().isEmpty()) {
      throw new IllegalArgumentException("lastPublishedCollection cannot be null/empty");
    }

    this.publishingCompany = publishingCompany.trim();
    this.lastPublishedCollection = lastPublishedCollection.trim();
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }
}

