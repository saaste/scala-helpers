package testhelpers

import org.mockito.Mockito._
import org.mockito.stubbing.OngoingStubbing
import org.scalatest.mockito.MockitoSugar

import scala.language.implicitConversions

trait MockitoHelper extends MockitoSugar {

  implicit def toWhenOps[R](mockMethod: R): WhenClause[R] = {
    new WhenClause(when(mockMethod))
  }

  class WhenClause[T](whenClause: OngoingStubbing[T]) {
    def returns(result: T) = whenClause.thenReturn(result)
    def throws(result: Throwable) = whenClause.thenThrow(result)
  }

}