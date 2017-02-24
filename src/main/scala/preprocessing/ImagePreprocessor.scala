import java.io.File
import scala.collection.mutable.ArrayBuffer
import com.sksamuel.scrimage._;
import com.sksamuel.scrimage.nio.JpegWriter;
import com.sksamuel.scrimage.filter.GrayscaleFilter;
import com.sksamuel.scrimage.filter.ThresholdFilter;

class ImagePreprocessor(val inFile:String) {
  var image = Image.fromFile(new File(inFile));
  var array = Array.ofDim[Int](32, 42);
  var counterh = 0;
  var counterw = 0;
  
  def preprocessor() : Image = {
    image = image.scaleTo(32, 42);
    image = image.map(grayscaleThreshold);
    

    return image
  }
  
  
  private def grayscaleThreshold(x: Int, y: Int, pixel: Pixel) : Pixel = {
    var result = pixel;
    var value = (pixel.red * 0.21 + pixel.green * 0.72 + pixel.blue * 0.07)/255
    if (value > 0.5) {
      array(counterh)(counterw) = 0;
      result = Pixel(0, 0, 0, 255)
    } else {
      array(counterh)(counterw) = 1;
      result = Pixel(255, 255, 255, 255)
    }
     counterw += 1;
      if (counterw == image.height) {
        counterh += 1;
        counterw = 0;
      }
      
     
    return result;
  }
 
  
}