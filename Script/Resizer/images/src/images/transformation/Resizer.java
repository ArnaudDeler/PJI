package images.transformation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author mkyong, Marion Noirbent
 * (http://www.mkyong.com/java/how-to-resize-an-image-in-java/)
 * Modified by Marion Noirbent
 */
public class Resizer extends Transformation {

    // Attribute

    public static int IMG_SIZE = 50;

    private int imgSize;

    // Constructor

    public Resizer(String dir) {
        super(dir,"1_cutted","2_resized/", IMG_SIZE + "px" + "_");
        this.imgSize = IMG_SIZE;
    }

    public Resizer(int imgSize, String dir, String pathIn, String pathOut, String prefix) {
        super(dir, pathIn, pathOut, prefix);
        this.imgSize = imgSize;
    }

    // Methods

    public BufferedImage transform(BufferedImage originalImage) {
        BufferedImage transformedImage = new BufferedImage(imgSize, imgSize, this.type(originalImage));
        Graphics2D g = transformedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imgSize, imgSize, null);
        g.dispose();
        this.setHint(g);
        return transformedImage;
    }

}