package magnettest

import magnettest.model.{A, B, Wrapper}

/**
  * Created by Bart Buijse on 08-Mar-17.
  */
class MagnetSolution {
  // Solution to overloading with generics.
  def test(magnet: CompletionMagnet): magnet.Result = {
    magnet()
  }
  
  def execute(): Unit = {
    // The argument in test is now implicitly converted to a CompletionMagnet.
    val a = test(new Wrapper(new A())) // Output: A class :)
    val b = test(new Wrapper(new B())) // Output: 12
    println(s"a: $a")
    println(s"b: $b")
  }
}

sealed trait CompletionMagnet {
  type Result // Optional. You can also write def apply(): Int, for example.
  def apply(): Result
}

object CompletionMagnet {
  implicit def fromHttpResponseFuture(wrapper: Wrapper[A]): CompletionMagnet =
    new CompletionMagnet {
      type Result = String
      def apply(): Result = {
         wrapper.obj.someText
      }
    }
  implicit def fromStatusCodeFuture(wrapper: Wrapper[B]): CompletionMagnet =
    new CompletionMagnet {
      type Result = Int
      def apply(): Result = {
        //wrapper.obj.otherText
        12
      }
    }
}