import clients.ExampleClient
import org.scalatest.{BeforeAndAfterEach, FlatSpec, MustMatchers}
import services.ExampleService
import testhelpers.{AutoMocks, MockitoHelper}

class ExampleSpec extends FlatSpec with BeforeAndAfterEach with MustMatchers with AutoMocks with MockitoHelper {

  override def beforeEach(): Unit = resetAllMocks()

  private val srv = createClassUnderTest(classOf[ExampleService])
  private val client = getMock(classOf[ExampleClient])

  "ExampleService" should "return clients response" in {
    client.foo returns "mock-bar"
    srv.getFoo mustBe "mock-bar"
  }

  it should "return something different now" in {
    client.foo returns "something different now"
    srv.getFoo mustBe "something different now"
  }

}
