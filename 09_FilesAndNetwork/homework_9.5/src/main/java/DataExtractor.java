import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataExtractor {
  private static final Logger logger = LogManager.getRootLogger();

  public static void readStationsFromFileAndPrint(String filePath) {
    try {
      JSONParser parser = new JSONParser();
      JSONObject jsonData = (JSONObject) parser.parse(getJsonFile(filePath));
      Map<String, Integer> stations = parseStations(jsonData);
      Map<String, String> lines = parseLines(jsonData);

      System.out.println("Станции Московского метро:");
      stations.forEach((key, value) -> System.out.println(lines.get(key) + ": " + value + " станций"));
    } catch (ParseException e) {
      logger.error(e);
    }
  }

  private static Map<String, String> parseLines(JSONObject jsonData) {
    JSONArray parseStations = (JSONArray) jsonData.get("lines");
    return (Map<String,String>) parseStations.stream()
        .collect(Collectors.toMap(o -> ((JSONObject)o).get("number"), o -> ((JSONObject)o).get("name")));
  }

  private static Map<String, Integer> parseStations(JSONObject jsonData) {
    JSONObject parseStations = (JSONObject) jsonData.get("stations");
    return (Map<String, Integer>) parseStations.keySet().stream()
        .collect(Collectors.toMap(Object::toString, o -> ((ArrayList<String>) parseStations.get(o))
            .size()));
  }

  private static String getJsonFile(String filePath) {
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      lines.forEach(builder::append);
    } catch (Exception ex) {
      logger.error(ex);
    }
    return builder.toString();
  }
}
