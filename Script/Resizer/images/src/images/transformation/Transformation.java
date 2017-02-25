package images.transformation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Marion Noirbent.
 */
public abstract class Transformation {

    // Attribute

    protected String dir;
    protected String pathIn;
    protected String pathOut;
    protected String prefix;

    // Constructor

    public Transformation(String dir, String pathIn, String pathOut, String prefix) {
        this.dir = dir;
        this.pathIn = pathIn;
        this.pathOut = pathOut;
        this.prefix = prefix;
    }

    // Abstract Methods

    public abstract BufferedImage transform(BufferedImage originalImage);

    // Methods

    public int type(BufferedImage originalImage){
        int type = originalImage.getType();
        if (type == BufferedImage.TYPE_CUSTOM) {
            type = BufferedImage.TYPE_INT_ARGB;
        }
        return type;
    }

    public void setHint(Graphics2D g){
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void loopOnDir(){
        File[] images = Paths.get(dir + pathIn).toFile().listFiles();
        for (File img : images) {
            try {
                BufferedImage originalImage = ImageIO.read(img);
                BufferedImage transformedImage = this.transform(originalImage);
                ImageIO.write(transformedImage, "png", new File(dir +pathOut + prefix + img.getName()));
            } catch (IOException e) {}
        }
    }
}
