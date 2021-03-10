import core.Line;
import core.Station;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouterCalculatorTest {
  private static RouteCalculator routeCalculator;
  private static StationIndex stationIndex;
  private static final String DATA_FILE = "src/main/resources/map.json";
  private List<Station> expectedForRouteWithNoConnections;
  private List<Station> expectedForRouteWithOneConnection;
  private List<Station> expectedForRouteWithTwoConnections;
  private List<Station> expectedForRouteWithSameStations;

  @Before
  public void init()
  {
    createStationIndex();
    routeCalculator = new RouteCalculator(stationIndex);

    expectedForRouteWithNoConnections = new ArrayList<>();
    expectedForRouteWithNoConnections.add(stationIndex.getStation("Василеостровская"));
    expectedForRouteWithNoConnections.add(stationIndex.getStation("Гостиный двор"));
    expectedForRouteWithNoConnections.add(stationIndex.getStation("Маяковская"));
    expectedForRouteWithNoConnections.add(stationIndex.getStation("Площадь Александра Невского"));
    expectedForRouteWithNoConnections.add(stationIndex.getStation("Елизаровская"));

    expectedForRouteWithOneConnection = new ArrayList<>();
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Василеостровская"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Гостиный двор"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Маяковская"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Площадь Восстания"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Владимирская"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Пушкинская"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Технологический институт"));
    expectedForRouteWithOneConnection.add(stationIndex.getStation("Балтийская"));

    expectedForRouteWithTwoConnections = new ArrayList<>();
    expectedForRouteWithTwoConnections.add(stationIndex.getStation("Адмиралтейская"));
    expectedForRouteWithTwoConnections.add(stationIndex.getStation("Садовая"));
    expectedForRouteWithTwoConnections.add(stationIndex.getStation("Сенная площадь"));
    expectedForRouteWithTwoConnections.add(stationIndex.getStation("Невский проспект"));
    expectedForRouteWithTwoConnections.add(stationIndex.getStation("Гостиный двор"));
    expectedForRouteWithTwoConnections.add(stationIndex.getStation("Василеостровская"));

    expectedForRouteWithSameStations = new ArrayList<>();
    expectedForRouteWithSameStations.add(stationIndex.getStation("Василеостровская"));
  }

  @After
  public void tearDown()
  {
    expectedForRouteWithNoConnections.clear();
    expectedForRouteWithOneConnection.clear();
    expectedForRouteWithTwoConnections.clear();
    expectedForRouteWithSameStations.clear();
  }

  @Test
  public void testGetShortestRouteWithOneConnection()
  {
    Station from = expectedForRouteWithOneConnection.get(0);
    Station to = expectedForRouteWithOneConnection.get(expectedForRouteWithOneConnection.size()-1);
    List<Station> actual = routeCalculator.getShortestRoute(from, to);

    Assert.assertEquals(expectedForRouteWithOneConnection, actual);
  }

  @Test
  public void testGetShortestRouteWithSameStations()
  {
    Station from = expectedForRouteWithSameStations.get(0);
    Station to = expectedForRouteWithSameStations.get(expectedForRouteWithSameStations.size()-1);
    List<Station> actual = routeCalculator.getShortestRoute(from, to);

    Assert.assertEquals(expectedForRouteWithSameStations, actual);
  }

  @Test
  public void testGetShortestRouteWithNoConnections()
  {
    Station from = expectedForRouteWithNoConnections.get(0);
    Station to = expectedForRouteWithNoConnections.get(expectedForRouteWithNoConnections.size()-1);
    List<Station> actual = routeCalculator.getShortestRoute(from, to);

    Assert.assertEquals(expectedForRouteWithNoConnections, actual);
  }

  @Test
  public void testGetShortestRouteWithTwoConnections()
  {
    Station from = expectedForRouteWithTwoConnections.get(0);
    Station to = expectedForRouteWithTwoConnections.get(expectedForRouteWithTwoConnections.size()-1);
    List<Station> actual = routeCalculator.getShortestRoute(from, to);

    Assert.assertEquals(expectedForRouteWithTwoConnections, actual);
  }

  @Test
  public void testCalculateDuration0()
  {
    double actual = RouteCalculator.calculateDuration(expectedForRouteWithNoConnections);
    double expected = 10;
    Assert.assertEquals(expected, actual, 0);
  }

  @Test
  public void testCalculateDuration1()
  {
    double actual = RouteCalculator.calculateDuration(expectedForRouteWithOneConnection);
    double expected = 18.5;
    Assert.assertEquals(expected, actual, 0);
  }

  @Test
  public void testCalculateDuration2()
  {
    double actual = RouteCalculator.calculateDuration(expectedForRouteWithTwoConnections);
    double expected = 14.5;
    Assert.assertEquals(expected, actual, 0);
  }

  @Test
  public void testCalculateDuration3()
  {
    double actual = RouteCalculator.calculateDuration(expectedForRouteWithSameStations);
    double expected = 0.0;
    Assert.assertEquals(expected, actual, 0);
  }

  private static void createStationIndex() {
    stationIndex = new StationIndex();
    try {
      JSONParser parser = new JSONParser();
      JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

      JSONArray linesArray = (JSONArray) jsonData.get("lines");
      parseLines(linesArray);

      JSONObject stationsObject = (JSONObject) jsonData.get("stations");
      parseStations(stationsObject);

      JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
      parseConnections(connectionsArray);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void parseConnections(JSONArray connectionsArray) {
    connectionsArray.forEach(connectionObject ->
    {
      JSONArray connection = (JSONArray) connectionObject;
      List<Station> connectionStations = new ArrayList<>();
      connection.forEach(item ->
      {
        JSONObject itemObject = (JSONObject) item;
        int lineNumber = ((Long) itemObject.get("line")).intValue();
        String stationName = (String) itemObject.get("station");

        Station station = stationIndex.getStation(stationName, lineNumber);
        if (station == null) {
          throw new IllegalArgumentException("core.Station " +
              stationName + " on line " + lineNumber + " not found");
        }
        connectionStations.add(station);
      });
      stationIndex.addConnection(connectionStations);
    });
  }

  private static void parseStations(JSONObject stationsObject) {
    stationsObject.keySet().forEach(lineNumberObject ->
    {
      int lineNumber = Integer.parseInt((String) lineNumberObject);
      Line line = stationIndex.getLine(lineNumber);
      JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
      stationsArray.forEach(stationObject ->
      {
        Station station = new Station((String) stationObject, line);
        stationIndex.addStation(station);
        line.addStation(station);
      });
    });
  }

  private static void parseLines(JSONArray linesArray) {
    linesArray.forEach(lineObject -> {
      JSONObject lineJsonObject = (JSONObject) lineObject;
      Line line = new Line(
          ((Long) lineJsonObject.get("number")).intValue(),
          (String) lineJsonObject.get("name")
      );
      stationIndex.addLine(line);
    });
  }

  private static String getJsonFile() {
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
      lines.forEach(builder::append);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return builder.toString();
  }
}
