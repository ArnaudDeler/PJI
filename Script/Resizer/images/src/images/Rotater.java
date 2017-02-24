package images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Marion Noirbent.
 */
public class Rotater {

    // Attribute

    private double imgAngle = Math.PI;
    private String dir;
    private String pathIn = "resized";
    private String pathOut = "rotated/";

    // Constructor

    public Rotater(String dir) {
        this.dir = dir;
    }

    public Rotater(int imgAngle, String dir) {
        this.imgAngle = imgAngle;
        this.dir = dir;
    }

    public Rotater(int imgAngle, String dir, String pathIn, String pathOut) {
        this.imgAngle = imgAngle;
        this.dir = dir;
        this.pathIn = pathIn;
        this.pathOut = pathOut;
    }

    // Methods

    public BufferedImage rotateImageWithHint(BufferedImage originalImage, int type) {
        Graphics2D g = originalImage.createGraphics();
        if (imgAngle % (2*Math.PI) != 0) {
            AffineTransform transform = AffineTransform.getRotateInstance(imgAngle);
            g.transform(transform);
            g.drawImage(originalImage, originalImage.getWidth(), originalImage.getHeight(), null);
        }
        g.dispose();
        Main.setHint(g);
        return originalImage;
    }

    public void loopOnDir(){
        File[] images = Paths.get(dir + pathIn).toFile().listFiles();
        for (File img : images) {
            try {
                BufferedImage originalImage = ImageIO.read(img);
                int type = originalImage.getType();
                if (type == BufferedImage.TYPE_CUSTOM) {
                    type = BufferedImage.TYPE_INT_ARGB;
                }
                BufferedImage resizeImageHintPng = this.rotateImageWithHint(originalImage, type);
                ImageIO.write(resizeImageHintPng, "png", new File(dir +pathOut + "rotate-" + img.getName()));
            } catch (IOException e) {}
        }
    }
}
