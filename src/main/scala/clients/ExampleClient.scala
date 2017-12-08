package clients

import javax.inject.Singleton

import com.google.inject.ImplementedBy

@ImplementedBy(classOf[ExampleClientImpl])
trait ExampleClient {
  def foo: String
}


@Singleton
class ExampleClientImpl extends ExampleClient {
  override def foo: String = "bar"
}
