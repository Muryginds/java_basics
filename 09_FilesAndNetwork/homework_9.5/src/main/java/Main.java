public class Main {
  private static final String DATA_FILE = "src/main/resources/map.json";

  public static void main(String[] args) {
    DataImporter.parseInfoAndImportToFile(DATA_FILE);
    DataExtractor.readStationsFromFileAndPrint(DATA_FILE);
  }
}