package images;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * @author mkyong, Marion Noirbent
 * (http://www.mkyong.com/java/how-to-resize-an-image-in-java/)
 * Modified by Marion Noirbent
 */
public class ImageResizer {

    // Attribute

    private int imgSize = 50;
    private String dir;
    private String pathIn = "origin";
    private String pathOut = "resized/";

    // Constructor

    public ImageResizer(int imgSize, String dir) {
        this.imgSize = imgSize;
        this.dir = dir;
    }

    public ImageResizer(int imgSize, String dir, String pathIn, String pathOut) {
        this.imgSize = imgSize;
        this.dir = dir;
        this.pathIn = pathIn;
        this.pathOut = pathOut;
    }

    // Methods

    public BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(imgSize, imgSize, type); // if imgWidth and imgHeight, wigth first
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imgSize, imgSize, null);
        g.dispose();
        Main.setHint(g);
        return resizedImage;
    }

    public void loopOnDir(){
        File[] images = Paths.get(dir + pathIn).toFile().listFiles();
        for (File img : images) {
            try {
                BufferedImage originalImage = ImageIO.read(img);
                int type = originalImage.getType();
                if (type == BufferedImage.TYPE_CUSTOM) { // int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
                    type = BufferedImage.TYPE_INT_ARGB;
                }
                BufferedImage resizeImageHintPng = this.resizeImageWithHint(originalImage, type);
                ImageIO.write(resizeImageHintPng, "png", new File(dir +pathOut + "50px-" + img.getName()));
            } catch (IOException e) {}
        }
    }
}