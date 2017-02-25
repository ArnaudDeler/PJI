package images.transformation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * @author Marion Noirbent.
 */
public class Rotater extends Transformation {

    // Attribute

    private double imgAngle;

    // Constructor

    public Rotater(double imgAngle, String dir) {
        super(dir,"2_resized","3_rotated/", Math.round(imgAngle / Math.PI) + "PIrad" + "_");
        this.imgAngle = imgAngle;
    }

    public Rotater(int imgAngle, String dir, String pathIn, String pathOut) {
        super(dir, pathIn, pathOut, imgAngle + "rad" + "_");
        this.imgAngle = imgAngle;
    }

    // Methods

    public BufferedImage transform(BufferedImage originalImage) {
        BufferedImage transformedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), this.type(originalImage));
        Graphics2D g = transformedImage.createGraphics();
        if (imgAngle % (2*Math.PI) != 0) {
            AffineTransform transform = AffineTransform.getRotateInstance(imgAngle);
            g.transform(transform);
        }
        g.drawImage(originalImage, transformedImage.getWidth(), transformedImage.getHeight(), null);
        g.dispose();
        this.setHint(g);
        return transformedImage;
    }
}
