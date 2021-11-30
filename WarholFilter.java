import java.awt.Color;
/**
 * Applies a warhol image filter
 *
 * @author Matthew Lee
 * @version 11.29.21
 */
public class WarholFilter extends Filter
{
    

    /**
     * Constructor for objects of class WarholFIlter
     */
    public WarholFilter(String name)
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
        int height = image.getHeight() / 2;
        int width = image.getWidth() / 2;
        OFImage orginal = new OFImage(image);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = orginal.getPixel(x * 2, y * 2);
                image.setPixel(x,y, pixel);
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width * 2; x++) {
                Color pixel = orginal.getPixel((width - (x - width)) * 2 - 1, y * 2);
                int redAmount = pixel.getRed();
                image.setPixel(x,y, new Color(redAmount, 0, 0));
            }
        }
        for(int y = 0; y < height * 2; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = orginal.getPixel(x * 2, (height - (y - height)) * 2 - 1);
                int greenAmount = pixel.getGreen();
                image.setPixel(x,y, new Color(0, greenAmount, 0));
            }
        }  
        for(int y = 0; y < height * 2; y++) {
            for(int x = 0; x < width * 2; x++) {
                Color pixel = orginal.getPixel((width - (x - width)) * 2 - 1, (height - (y - height)) * 2 - 1);
                int blueAmount = pixel.getBlue();
                image.setPixel(x,y, new Color(0, 0, blueAmount));
            }
        }
    }
}
