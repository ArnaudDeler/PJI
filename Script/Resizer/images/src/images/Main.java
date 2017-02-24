package images;

import java.awt.*;

/**
 * @author Marion Noirbent.
 */
public class Main {

    public static void setHint(Graphics2D g){
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void main(String[] args) {
        String dir;
        if (args.length > 0){
            dir = args[1];
        } else {
            dir = "/home/spirita/M1S2/PJI/images/";
            // DIR = Paths.get("$PWD");
        }
        ImageResizer resizer = new ImageResizer(50, dir);
        Rotater rotater = new Rotater(dir);
        resizer.loopOnDir();
        rotater.loopOnDir();
    }
}
