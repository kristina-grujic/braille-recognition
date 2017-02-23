import java.io.File
import scala.collection.mutable.ArrayBuffer
import com.sksamuel.scrimage._;
import com.sksamuel.scrimage.nio.JpegWriter;
import com.sksamuel.scrimage.filter.GrayscaleFilter;
import com.sksamuel.scrimage.filter.ThresholdFilter;

class ImagePreprocessor(val inFile:String) {
  var image = Image.fromFile(new File(inFile));
  var array = new ArrayBuffer[Int]();
  
  def preprocessor() : Image = {
    image = image.map(grayscaleThreshold);
    return image
  }
  
  private def grayscaleThreshold(x: Int, y: Int, pixel: Pixel) : Pixel = {
    var value = (pixel.red * 0.21 + pixel.green * 0.72 + pixel.blue * 0.07)/255
    if (value > 0.5) {
      array += 0;
      return Pixel(0, 0, 0, 255)
    } else {
      array += 1;
      return Pixel(255, 255, 255, 255)
    }
    return pixel;
  }
 
  
}