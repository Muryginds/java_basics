import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        Path destination = Path.of(destinationDirectory);
        Path source = Path.of(sourceDirectory);
        try {
            Files.walkFileTree(Path.of(sourceDirectory), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
                {
                    Path newd = destination.resolve(source.relativize(dir));
                    Files.copy(dir, newd, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
                {
                    Path newd = destination.resolve(source.relativize(file));
                    Files.copy(file, newd, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("Files copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
