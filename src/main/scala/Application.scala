import java.io.File

import translator.BinaryToLetter;

object Application extends App {
	val imagePreprocessor = new ImagePreprocessor(getClass.getResource("/0.jpg").getPath)
	val image = imagePreprocessor.preprocessor()
	image.output(new File("C://Users/Windows/Downloads/result.png"))
	val binary = new BinaryToLetter()
	println(binary.getLetter(Array(0,1,1,1,1,0)))
}
