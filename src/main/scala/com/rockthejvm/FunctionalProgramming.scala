package com.rockthejvm

object FunctionalProgramming extends App{
  class Person(name: String){
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) //invoking bob as a function which is equivalent to above line

  //Scala runs on the JVM
  /*
  functional programming:
  compose functions
  pass functions as args
  return functions as results
  functionX = Function1, Function2,... Function57
  */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(23) // output of 24
  simpleIncrementer(23) // same as above
  //defined a function above
  // all Scala functions are instances of these function_x types

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcatenator("I love", "Scala")

  // syntax sugars
  // this means the syntax is designed so it is easier to read it is sweeter for humans to read
  val doubler: (Int) => Int = (x: Int) => 2 * x
  doubler(4)

  /*
  this is the same as writing above
   val doubler: Function1[Int, Int] = (x: Int) => 2 * x
   OR
  new Function1[Int, Int] {
    override def apply(x: Int) = 2 * x
  }
   */
  // higher-order functions - take functions as args and return functions as output
  val aMappedList = List(1,2,3).map(x => x + 1) // the map method is the higher order function and the return type is a list of int
  // this anonymous function (x => x + 1) is equivalent to Function1[Int, Int] = (x: Int) => x + 1
 // a flat map
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x)) // flat map concatenates all the smaller lists into a bigger list
  /*
  alternative syntax
  val aFlatMappedList = List(1,2,3).flatMap { x =>
  List(x, 2 * x)
  }
   */
  // the flatmap method first does the map method then the flatten method, which removes the inner grouping of items and generates a sequence connected by comers

  //using a filter
  val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3)
  /*
  alternative method
  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3)
   */
// using map, filter or flatMap each application will return a instance - as everything is immutable you cannot chance the list you are applying these .things to so you are returning a new list

  // you can chain applications to each other
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  print(allPairs)
}
