package com.springer.drawing

import org.specs2.mutable.Specification

class ArrayCanvasTest extends Specification {

  "A newly created canvas can be displayed" >> {
    val canvas = ArrayCanvas(10, 4)
    canvas.toString must_== """------------
                              *|          |
                              *|          |
                              *|          |
                              *|          |
                              *------------""".stripMargin2('*')
  }

  "Can draw a single character" >> {
    val canvas = ArrayCanvas(10, 4)
    canvas.drawCharacter(Coordinate(1, 2), 'x')
    canvas.toString must_== """------------
                              *|          |
                              *|x         |
                              *|          |
                              *|          |
                              *------------""".stripMargin2('*')
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
    canvas.toString must_== original
  }

  "drawing characters outside region height" >> {
    val canvas = ArrayCanvas(10, 4)
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(1, 5), '?')
    canvas.toString must_== original
  }

  "get the coordinates and values for a canvas" >> {
    val canvas = ArrayCanvas(3, 2)
    val expected = Map(
      Coordinate(0, 0) -> '-', Coordinate(1, 0) -> '-', Coordinate(2, 0) -> '-', Coordinate(3, 0) -> '-', Coordinate(4, 0) -> '-',
      Coordinate(0, 1) -> '|', Coordinate(1, 1) -> ' ', Coordinate(2, 1) -> ' ', Coordinate(3, 1) -> ' ', Coordinate(4, 1) -> '|',
      Coordinate(0, 2) -> '|', Coordinate(1, 2) -> ' ', Coordinate(2, 2) -> ' ', Coordinate(3, 2) -> ' ', Coordinate(4, 2) -> '|',
      Coordinate(0, 3) -> '-', Coordinate(1, 3) -> '-', Coordinate(2, 3) -> '-', Coordinate(3, 3) -> '-', Coordinate(4, 3) -> '-'
    )
    canvas.getTiles must_== expected
  }

}
