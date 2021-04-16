import java.io.File;

public class Main {

    private static final String SRC_FOLDER = "E:/src";
    public static final String DST_FOLDER = "E:/dst";

    public static void main(String[] args) {

        File srcDir = new File(SRC_FOLDER);

        long start = System.currentTimeMillis();
        int newWidth = 400;

        File[] files = srcDir.listFiles();

        int processors = Runtime.getRuntime().availableProcessors();
        for(int i = 0; i < processors; i++) {
            int newArraySize = i == processors - 1 ? files.length % processors : files.length / processors;
            File[] separatedFiles = new File[newArraySize];
            System.arraycopy(files, i * files.length / processors, separatedFiles, 0, newArraySize);
            MyThread thread = new MyThread(files, DST_FOLDER, newWidth, start);
            new Thread(thread).start();
        }
    }
}
