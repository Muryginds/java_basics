import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main
{
  private static final String SITE_ADDRESS = "https://www.moscowmap.ru/metro.html#lines";
  private static final Pattern CONNECTED_STATION = Pattern.compile("class=\"t-icon-metroln ln-(.+?)\" .+? станцию «(.+?)»");
  private static final String CONNECTION_STATION_NAME = ".+class=\"name\">(.+?)<.+";
  private static final String DATA_FILE = "resources/map.json";


  public static void main(String[] args)
  {
    try {
      Elements elements = Jsoup.connect(SITE_ADDRESS).maxBodySize(0).get().select("div[id=metrodata]");
      Map<Object, Object> stations = elements.select("div[class =js-metro-stations t-metrostation-list-table]")
          .stream().collect(Collectors.toMap(element -> element.attr("data-line"),
              element -> element.select("span.name").stream().map(Element::text).collect(Collectors.toList())));

      Map<String, String> lines = elements.select("span[class ~=js-metro-line t-metrostation-list-header t-icon-metroln]")
          .stream().collect(Collectors.toMap(element -> element.attr("data-line"), Element::text));

      Map<Object, List<Object>> connections = elements.select("div[class =js-metro-stations t-metrostation-list-table]")
            .stream().collect(Collectors.toMap(element -> element.attr("data-line"),
              element -> element.select("a").stream()
                  .filter(element1 -> element1.toString().contains("переход")).collect(Collectors.toList())));

      JSONObject obj = new JSONObject();
      obj.put("stations", stations);

      List<JSONObject> linesList = lines.entrySet().stream().map(entry -> {
        JSONObject object = new JSONObject();
        object.put("number", entry.getKey());
        object.put("name", entry.getValue());
        return  object;
      }).collect(Collectors.toList());
      obj.put("lines" , linesList);

      Set<List<JSONObject>> connectionList = connections.entrySet().stream().flatMap(oe -> oe.getValue().stream().map(o -> {
        String element = o.toString();
        String stName = element.replaceAll(CONNECTION_STATION_NAME, "$1");
        List<JSONObject> conObjList = new ArrayList<>();
        JSONObject firstConObject = new JSONObject();
        firstConObject.put("line", oe.getKey());
        firstConObject.put("name", stName);
        conObjList.add(firstConObject);

        conObjList.addAll(CONNECTED_STATION.matcher(element).results().map(matchResult -> {

          JSONObject conObj = new JSONObject();
          conObj.put("line", matchResult.group(1));
          conObj.put("name", matchResult.group(2));
          return conObj;
        }).collect(Collectors.toList()));

        conObjList.sort(Comparator.comparing(JSONObject::toString));
       return conObjList;
      })).collect(Collectors.toSet());

      obj.put("connections", connectionList);

      Files.newBufferedWriter(Paths.get(DATA_FILE)).append(obj.toJSONString()).close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    readFileAndCountStations();
  }

  private static void readFileAndCountStations()
  {
    JSONParser parser = new JSONParser();
    JSONObject jsonData = null;
    try {
      jsonData = (JSONObject) parser.parse(getJsonFile());
    } catch (ParseException e) {
      e.printStackTrace();
    }

    JSONObject parseStations = (JSONObject) jsonData.get("stations");
    parseStations(parseStations);
  }

  private static void parseStations(JSONObject stationsObject) {
    Map<String, List<String>> list = (Map<String,List<String>>) stationsObject.keySet().stream()
        .collect(Collectors.toMap(Object::toString, o -> ((ArrayList<String>) stationsObject.get(o))
            .size()));
    System.out.println(list);
  }

  private static String getJsonFile() {
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
      lines.forEach(line -> builder.append(line));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return builder.toString();
  }
}
