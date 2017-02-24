import java.io.File
import neural.Perceptron
import translator.BinaryToLetter;

object Application extends App {
	val imagePreprocessor = new ImagePreprocessor(getClass.getResource("/m.jpg").getPath)
	val image = imagePreprocessor.preprocessor()
	val perceptron = new Perceptron(imagePreprocessor.array);
	val result = perceptron.frontPropagation();
  //	image.output(new File("C://Users/Windows/Downloads/result.png"))
	val binary = new BinaryToLetter()
	println(binary.getLetter(result));
}
