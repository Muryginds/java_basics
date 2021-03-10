import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path)
    {
        try {
            File file = new File(path);
            return calculateAllElements(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private static long calculateAllElements(File file)
    {
        long result = 0;
        if (file.isDirectory()) {
            File[] files = null;

            try {
                files = file.listFiles();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (files == null || files.length == 0) {
                return result;
            }
            for (File element : files) {
                result += calculateAllElements(element);
            }
        } else {
            result = file.length();
        }
        return result;
    }
}
