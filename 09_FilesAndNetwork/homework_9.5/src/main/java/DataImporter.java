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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataImporter {

  private static Elements elements;
  private static final Logger logger = LogManager.getRootLogger();
  private static final String SITE_ADDRESS = "https://www.moscowmap.ru/metro.html#lines";
  private static final Pattern CONNECTED_STATION = Pattern.compile("class=\"t-icon-metroln ln-(.+?)\" .+? станцию «(.+?)»");
  private static final String CONNECTION_STATION_NAME = ".+class=\"name\">(.+?)<.+";


  public static void parseInfoAndImportToFile(String filePath) {
    try {
      Document doc = Jsoup.connect(SITE_ADDRESS).maxBodySize(0).get();
      elements = doc.select("div[id=metrodata]");
      JSONObject dataObject = parseDataAndCreateJsonObject();
      Files.newBufferedWriter(Paths.get(filePath)).append(dataObject.toJSONString()).close();
    } catch (IOException e) {
      logger.error(e);
    }
  }

  private static JSONObject parseDataAndCreateJsonObject() {
    JSONObject obj = new JSONObject();

    importStationsToObject(obj);
    importLinesToObject(obj);
    importConnectionsToObject(obj);

    return obj;
  }

  private static void importConnectionsToObject(JSONObject obj) {
    Map<String, List<Object>> connections = connections();
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
  }

  private static void importLinesToObject(JSONObject obj) {
    Map<String, String> lines = lines();
    List<JSONObject> linesList = lines.entrySet().stream().map(entry -> {
      JSONObject object = new JSONObject();
      object.put("number", entry.getKey());
      object.put("name", entry.getValue());
      return  object;
    }).collect(Collectors.toList());
    obj.put("lines" , linesList);
  }

  private static void importStationsToObject(JSONObject obj) {
    Map<String, List<String>> stations = stations();
    obj.put("stations", stations);
  }

  private static Map<String, List<String>> stations() {
    return elements.select("div[class =js-metro-stations t-metrostation-list-table]")
        .stream().collect(Collectors.toMap(element -> element.attr("data-line"),
            element -> element.select("span.name").stream().map(Element::text).collect(Collectors.toList())));
  }

  private static Map<String, String> lines() {
    return elements.select("span[class ~=js-metro-line t-metrostation-list-header t-icon-metroln]")
        .stream().collect(Collectors.toMap(element -> element.attr("data-line"), Element::text));
  }

  private static Map<String, List<Object>> connections() {
    return elements.select("div[class =js-metro-stations t-metrostation-list-table]")
        .stream().collect(Collectors.toMap(element -> element.attr("data-line"),
            element -> element.select("a").stream()
                .filter(element1 -> element1.toString().contains("переход")).collect(Collectors.toList())));
  }
}