import java.awt.Color;
/**
 * Applies a red tint to the image
 *
 * @author Matthew Lee
 * @version 11.29.21
 */
public class RedTintFilter extends Filter
{


    /**
     * Constructor for objects of class RedTintFilter
     */
    public RedTintFilter(String name)
    {
        super(name);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                int redAmount = pixel.getBlue();
                image.setPixel(x,y, new Color(redAmount, 0, 0));
            }
        }
    }
}
