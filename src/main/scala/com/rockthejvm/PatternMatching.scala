package com.rockthejvm

object PatternMatching extends App {
//  switch expression
  val anInteger = 35
  val order = anInteger match {
    // match is a keyword
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order)

//  Pattern matching is an expression
  // only available for case classes

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 2) // do not need to be instanced with new keyword as have companion class with an apply method Person.apply("Bob", 2)

  val personGreeting = bob match {
    case Person(n,a) => s"Hi, my name's $n and I'm $a years old."
    case _ => "Something else" // if you get something else that does not match then return this
  }
//    the case: case Person(n,a) is not necessarily matching against a definitive value it is matching bob against a structure, if bob matched Person(n,a) then let n and a be the corresponding parts of bob (name, age)

  //deconstructing tuples
  val aTuple =("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"The band $band belongs to the $genre genre"
    case _ => "I do not know that band"
  }
//  if the aTuple conforms to this (band, genre) structure then these (band, genre) should become the corresponding parts in aTuple (band will be first part, genre will be second part) these can then be used on the right hand side of the =>

//  decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_,2,_) => "This list contains a 2 at index position 1"
    case _ => "Unknown List" // this in not necessary but if the pattern match does not find anything it will throw an error and crash your program so better to include it
  }
//  pattern matching will try all cases in sequence, if the case _ (wildcard case which applies to everything) comes first then that will be printed rather than going to next case to see if that applies



}
