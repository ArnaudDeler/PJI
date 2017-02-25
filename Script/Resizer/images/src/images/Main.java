package images;

import images.transformation.Resizer;
import images.transformation.Rotater;

/**
 * @author Marion Noirbent.
 */
public class Main {

    public static void main(String[] args) {
        String dir;
        if (args.length > 0){
            dir = args[1];
        } else {
            dir = "/home/spirita/M1S2/PJI/images/";
            // DIR = Paths.get("$PWD");
        }
        Resizer resizer = new Resizer(dir);
        Rotater rotater = new Rotater(Math.PI, dir);
        resizer.loopOnDir();
        rotater.loopOnDir();
    }
}
