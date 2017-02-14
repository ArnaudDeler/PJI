package images;

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
        ImageResizer resizer = new ImageResizer(50, dir);
        resizer.loopOnDir();
    }
}
