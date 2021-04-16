import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

public class MyThread implements Runnable {

private File[] files;
private String dstFolder;
private int newWidth;
private long start;

public MyThread(File[] files, String dstFolder, int newWidth, long start) {
  this.files = files;
  this.dstFolder = dstFolder;
  this.newWidth = newWidth;
  this.start = start;
}

  @Override
  public void run() {
    try {
      for (File file : files) {

        BufferedImage image = ImageIO.read(file);
        int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
        BufferedImage newImage = resize(image, newWidth, newHeight);

        File newFile = new File(dstFolder + "/" + file.getName());
        ImageIO.write(newImage, "jpg", newFile);
      }
      System.out.println("runtime: " + (System.currentTimeMillis() - start));
    } catch (IOException ex) {
          ex.printStackTrace();
    }
  }
  public BufferedImage resize(BufferedImage src, int targetWidth, int targetHeight, BufferedImageOp... ops) {
    return Scalr.resize(src, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
  }
}

