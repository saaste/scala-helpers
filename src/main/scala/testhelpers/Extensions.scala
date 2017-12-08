package testhelpers

import scala.concurrent.Future

object Extensions {

  implicit class RichAny[T](o: T) {
    def toFuture: Future[T] = Future.successful(o)

    def toOption: Option[T] = Some(o)
  }

  implicit class RichOption[T](o: Option[T]) {
    def toEither[L](left: L): Either[L, T] = o.map(Right(_)).getOrElse(Left(left))
  }

}