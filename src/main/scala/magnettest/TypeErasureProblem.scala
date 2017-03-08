package magnettest

import magnettest.model.{A, B, Wrapper}

/**
  * Created by Bart Buijse on 08-Mar-17.
  */
class TypeErasureProblem {
  
  // Overload not possible because of type erasure.
  // Compiler sees the following twice:
  // test1(wrapper: Wrapper): Unit
  
  /* Uncomment to show type erasure problem.
  def test1(wrapper: Wrapper[A]): String = {
    wrapper.obj.someText
  }
  
  def test1(wrapper: Wrapper[B]): String  = {
    wrapper.obj.otherText
  }
  
  def execute(): Unit = {
    test1(new Wrapper(new A())) // Should output: A class :)
    test1(new Wrapper(new B())) // Should output: 12
  }*/
}
