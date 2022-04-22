package com.rockthejvm

object Basics extends App{
// define a value
  val meaningOfLife: Int = 42 // in Java this is equivalent to const int meaningOfLife = 42

  val aBoolean = false // type mentioning is optional
  // types include Int, Boolean, Char, Double, Float, String

  // strings and string operations
  val aStringExample = "I love Scala"
  // you can also compose a string
  val aComposedStringExample = "I" + " " + "love" + " " + "Scala"
  // you can have an interpolated string where you inject other things into a string
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expressions = structures that can be reduced to a value, think in terms of values rather than instructions values are composes to form new values
  val exampleExpression = 2 + 7

  // if-expression
  val exampleOfIfExpression = if (meaningOfLife > 43) 56 else 666
  // this is reduced to two values either 56 or 666
  // in other languages = meaningOfLife > 43 ? 56 : 666
  // you can chain if-expressions
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 666) 999
    else 0
  }
  // this is reduced to either 56, -2, 999 or 0

  // code block
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67
    //last value of the code block it the value of the code block
    aLocalValue + 3
  }

    // define a function
    def myFunction(x: Int, y: String): String = y + " " + x
    // the single expression y + " " + x is the return value for this function
    // use code block for larger functions
    def myFunctionWithCodeBlock(x: Int, y: String): String = {
      y + " " + x
    }

    // functions can depend on their own definition and are therefore recursive
    def factorial(n: Int): Int =
      if (n <=1) 1
      else n * factorial(n - 1)

  // scala does not use loops or iteration use on RECURSION

  // the Unit type = no meaningful value === "void" equivalent
  // it is a type of side effects, are operations that have nothing to do with meaningful information, it has to do with printing or showing something on a screen, storing something somewhere...
  println("I love Scala") // similar to System.out.println, console.log
  // have no meaningful unit to return
  def myUnitReturningFunction(): Unit = {
    println("I do NOT love returning Unit")
  }
    }


