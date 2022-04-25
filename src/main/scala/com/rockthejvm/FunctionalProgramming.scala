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

  // for comprehensions
  // for means for comprehension NOT for loops
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number - $letter"
    // this is equivalent to the allPairs value above using map and flatmap

// collections
  //lists
    //head and tail are the fundamental operations of list
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val theRest = aList.tail
  val aPreparedList = 0 :: aList // return = List(0,1,2,3,4,5)
  val aExtendedList = 0 +: aList :+ 6 // return = List(0,1,2,3,4,5,6)

  //sequences
  val aSequence : Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) // the element at index position 1 which is 2

  //vectors
    // fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  //sets
    //do not allow duplicates
  val aSet = Set(1,2,3,4,1,2,3) //return Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // return false contain method returns true or false
  val anAddedSet = aSet + 5 //return Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // returns Set(1,2,4) as the 3 has now been removed

  //ranges
    //useful for iteration
    //does not contain all the numbers between what the range implies but is acts as if it does
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // to =List converts a collection to a list, return List(2,4,6,8...998,1000)

  //tuples
    //group of values under the same value
  val aTuple =("Bon Jovi", "Rock", 1982)


  //maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Robyn", 32435456),
    ("Sarina", 23432435),
    "Connie" -> 2345808 // this is equivalent to lines above
  )
}
