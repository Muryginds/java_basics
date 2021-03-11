import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static long calculateFolderSize(String path)
    {
        long result = 0;
        try {
            result =  Files.walk(Path.of(path))
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
