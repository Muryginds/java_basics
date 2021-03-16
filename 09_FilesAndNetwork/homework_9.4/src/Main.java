import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main
{
  private static final String ABSOLUTE_PATH_TO_IMAGES_FOLDER = System.getProperty("user.dir") + "/images";
  private static final String IMAGE_NAME_PATTERN = ".+/([^\\\\/]+).jpg";
  public static void main(String[] args)
  {
    try {
      Document doc = Jsoup.connect("https://lenta.ru/").get();
      doc.select("img.g-picture").stream()
          .map(element -> element.attr("src"))
          .collect(Collectors.toMap(s -> s, s -> s.replaceAll(IMAGE_NAME_PATTERN, "$1")))
          .forEach((s, s2) -> {
            try (InputStream in = new URL(s).openStream()){
              Files.copy(in, Paths.get(ABSOLUTE_PATH_TO_IMAGES_FOLDER + File.separator + s2 + ".jpg"),
                  StandardCopyOption.REPLACE_EXISTING);
              System.out.println(s2);
            } catch (IOException e) {
              e.printStackTrace();
            }
          });
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
