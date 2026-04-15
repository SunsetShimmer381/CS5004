import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrendingTopics {

  /**
   * Counts the number of occurrences of each topic in the input list.
   *
   * @param topics the list of topic strings
   * @return a map where each distinct topic is associated with its count
   */
  public Map<String, Long> countTopics(List<String> topics) {
    return topics.stream()
        .collect(Collectors.groupingBy(
            topic -> topic,
            Collectors.counting()
        ));
  }
}
