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
    val expected = Seq(
      Tile((0, 0), '-'), Tile((1, 0), '-'), Tile((2, 0), '-'), Tile((3, 0), '-'), Tile((4, 0), '-'),
      Tile((0, 1), '|'), Tile((1, 1), ' '), Tile((2, 1), ' '), Tile((3, 1), ' '), Tile((4, 1), '|'),
      Tile((0, 2), '|'), Tile((1, 2), ' '), Tile((2, 2), ' '), Tile((3, 2), ' '), Tile((4, 2), '|'),
      Tile((0, 3), '-'), Tile((1, 3), '-'), Tile((2, 3), '-'), Tile((3, 3), '-'), Tile((4, 3), '-')
    ) 
    canvas.getTiles must containTheSameElementsAs(expected)
  }

}
