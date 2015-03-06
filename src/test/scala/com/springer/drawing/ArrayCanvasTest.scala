package com.springer.drawing

import org.specs2.mutable.Specification

class ArrayCanvasTest extends Specification {

  "A newly created canvas can be displayed" >> {
    val canvas = ArrayCanvas(10, 4)
    canvas.toString must_==(
      """------------
        *|          |
        *|          |
        *|          |
        *|          |
        *------------""".stripMargin('*'))
  }

  "Can draw a single character" >> {
    val canvas = ArrayCanvas(10, 4)
    canvas.drawCharacter(Coordinate(1, 2), 'x')
    canvas.toString must_==(
      """------------
        *|          |
        *|x         |
        *|          |
        *|          |
        *------------""".stripMargin('*'))
  }

  "drawing characters on border region" >> {
    val canvas = ArrayCanvas(10, 4)
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(0, 2), '?')
    canvas.toString must_== original
    canvas.drawCharacter(Coordinate(2, 0), '?')
    canvas.toString must_== original
  }

  "drawing characters outside region width" >> {
    val canvas = ArrayCanvas(10, 4)
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(11, 1), '?')
    canvas.toString must_==(original)
  }

  "drawing characters outside region height" >> {
    val canvas = ArrayCanvas(10, 4)
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(1, 5), '?')
    canvas.toString must_==(original)
  }
 
}
