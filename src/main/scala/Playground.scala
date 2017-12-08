import com.google.inject.Guice
import testhelpers.Extensions._
import services.ExampleService

object Playground extends App {

  val guiceBuilder = Guice.createInjector()
  val exampleService = guiceBuilder.getInstance(classOf[ExampleService])

  println("Example".toFuture)
  println("Example".toOption)

  println(Some("Right").toEither("This will be the left value"))
  println(None.toEither("This will be the left value"))

  println(exampleService.getFoo)

}
