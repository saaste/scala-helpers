package services

import javax.inject.{Inject, Singleton}

import clients.ExampleClient

@Singleton
class ExampleService @Inject()(exampleClient: ExampleClient) {

  def getFoo: String = exampleClient.foo

}
