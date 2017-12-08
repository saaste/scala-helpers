package testhelpers

import org.mockito.Mockito

/**
  * Automatically mocks constructor parameters of the class under test. How to use:
  * 1. Mix in this trait in your test class
  * 2. Instead of using "new", instantiate your class by calling createClassUnderTest. Don't pass a trait; pass the implementing class.
  *    Mocks will automatically be created for your class's dependencies.
  * 3. Instead of creating mocks using Mockito.mock(...), call getMock.
  */
trait AutoMocks {

  private var mocksMap: Map[Class[_], Object] = Map.empty

  def getMock[T](clazz: Class[T]): T = {
    mocksMap
      .getOrElse(
        clazz,
        throw new RuntimeException(
          s"Mock for ${clazz.getSimpleName} not found. Did you call createClassUnderTest first?"))
      .asInstanceOf[T]
  }

  def createClassUnderTest[T](clazz: Class[T]): T = {
    val ctor = clazz.getConstructors.headOption.getOrElse(throw new RuntimeException(
      s"${clazz.getSimpleName} has no constructor. If it is a trait, pass in the class that implements the trait instead"))

    val mocks = ctor.getParameterTypes.map { clazz =>
      if (clazz == classOf[String])
        clazz -> "example-string"
      else
        clazz -> Mockito.mock(clazz).asInstanceOf[Object]
    }

    mocksMap = mocks.toMap
    ctor.newInstance(mocks.map(_._2): _*).asInstanceOf[T]
  }

  def resetAllMocks(): Unit = {
    val mocksToReset = mocksMap.values
      .filterNot(_.getClass == classOf[String])
      .toSeq
    Mockito.reset(mocksToReset: _*)
  }

}