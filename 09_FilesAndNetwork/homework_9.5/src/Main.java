public class Main
{
  private static final String DATA_FILE = "resources/map.json";

  public static void main(String[] args)
  {
    DataImporter.parseInfoAndImportToFile(DATA_FILE);
    DataImporter.readStationsFromFileAndPrint(DATA_FILE);
  }
}
