import java.io.File

object Application extends App {
	println("Hello")
	val imagePreprocessor = new ImagePreprocessor()
	val image = imagePreprocessor.preprocessor(getClass.getResource("/0.jpg").getPath)
	image.output(new File("C://Users/Windows/Downloads/result.png"))
	println(image.toString())
}
