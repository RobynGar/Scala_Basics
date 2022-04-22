package com.rockthejvm

object ObjectOrientation extends App {
  //java equivalent public static void main(String[] args)
  class Animal{
    // define fields in the form of values
    val age: Int = 0
    // and define methods
    def eat() = println("I'm eating")
  }
  // animal can now be used throughout the code and this can be instanced using the keyword new
  // instance of the animal class
  val anAnimal = new Animal
  // inheritance means you can extend a class and inheriting all the methods of that class
  class Dog(name: String) extends Animal // you can leave the code block blank (do not include the {} after) if you just want to inherit things from the superclass without overriding anything
  //to pass arguments to the class you use a constructor argument (name: String) or the constructor definition this is not the same as a field you cannot see these outside the class e.g. you cannot write aDog.name
  val aDog = new Dog("Maple") // a class definition with arguments will provide space to input these when you create a new instance
  // constructor arguments need a val argument in front of them

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Moose")
  // on the left of the : an Animal is declared but the right a dog is being declared when calling on the methods if the dog class has any that overridden the animal class then these are used
  aDeclaredAnimal.eat() // called from the dog class if overrides but at runtime it will be called from the most derived class

  //abstract class
  abstract class WalkingAnimal{
    val hasLegs = true // by default these are public, type can be restricted by public or private
    def walk(): Unit
  }

  //"interface" is the ultimate type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait Philosopher {
    def ?!(thought: String): Unit //the ?! is valid for a name
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    //you can have single-class inheritance and multi-trait mixing e.g. extending animal class mixed with the carnivore trait (interface)
    override def eat(animal: Animal): Unit = println("Will eat you")

//    override def ?!(thought: String): Unit = println("I think therefore I am")
    override def ?! (thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  // two ways to call on the methods when it has a single argument
  aCroc.eat(aDog)
  aCroc eat aDog // second method is called infix notation which is a object method argument, only for methods with one arguments
  aCroc ?! "if humans are sentient beings do they feel pain if i eat them"

  // operators is Scala are actually methods
  val basicMath = 1+2
  val anotherBasicMath = 1.+(2) // this is equivalent to the above

  //anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("Anything I want")
  }
  // the above is like telling the compiler:
  // class Carnivore_Anonymous_35453 extends Carnivore {
  //  override def eat(animal: Animal): Unit = println("Anything I want")
  //  }
  // val dinosaur = new Carnivore_Anonymous_35453

  //singleton object
  object MySingleton { // for a singleton you are saying this is the only instance of this object
    val mySpecialValue = 3256
    def mySpecialMethod(): Int = 45656
    def apply(x: Int): Int = x +1 //the presence of an apply method in a class allows instances of this method to be called in a specific way, allows it to be invoked like a function
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(46)
  MySingleton(65) // this is equivalent to the above line

  // companions - companion object this has the same name as the class above therefore is call a companion
  object Animal{
    //companions can access each other's private fields/methods
    // but animal singleton object and instances of the animal class are different
    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  //case classes - lightweight data structure with boilerplate code
  //has sensible equals and hash code
  //serialization
  // companion with apply so you do not need the new keyword
  //pattern matching
  case class Person(name: String, age: Int)
// case classes do not need the keyword new
  val rob = Person("Rob", 109)

  // exceptions
  // - if object is thrown the JVM will interrupt its normal code flow execution use try and catch
  try {
    //code will throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "faulty error message"
  } finally {
    //execute some code no matter what this can be added on it addition
  }

  //generics
  abstract class MyList[T]{ //type argument passed inside [] so T can be Int, String...
    def head: T // T is can be used as method definitions or value definitions inside the class
    def tail: MyList[T] // T later becomes concrete when used again
  }
// using a generic with a concrete type
    // of Int
  val aList: List[Int] = List(1,2,3) //this is the list companion object List.apply(1,2,3)
  val first = aList.head // int type using head from the MyList abstract class
  val rest = aList.tail
    // list of String
  val aStringList = List("hello", "Scala")
  // purpose of generics is to reuse functionality for multiple types
  val firstString = aStringList.head // string type using head from the MyList abstract class

  //1. in Scala usually operate with immutable value/objects
  // any modification to an object must return another object
  //this is good for multi-threaded environment
  // helps reasoning about code (helps make sense of code)
  val reversedList = aList.reverse // this will return a new list

  //2. scala is closest to the 00 ideal true object oriented
}
