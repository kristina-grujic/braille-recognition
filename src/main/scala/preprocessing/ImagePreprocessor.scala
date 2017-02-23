import java.io.File
import com.sksamuel.scrimage._;
import com.sksamuel.scrimage.nio.JpegWriter;
import com.sksamuel.scrimage.filter.GrayscaleFilter;
import com.sksamuel.scrimage.filter.ThresholdFilter;

class ImagePreprocessor {
  
  def preprocessor(inFile:String) : Image = {
    var image = Image.fromFile(new File(inFile))
    image = image.map(grayscaleThreshold);
    return image
  }
  
  private def grayscaleThreshold(x: Int, y: Int, pixel: Pixel) : Pixel = {
    var value = (pixel.red * 0.21 + pixel.green * 0.72 + pixel.blue * 0.07)/255
    if (value > 0.5) {
      return Pixel(0, 0, 0, 255)
    } else {
      return Pixel(255, 255, 255, 255)
    }
    return pixel;
  }
  
  
}