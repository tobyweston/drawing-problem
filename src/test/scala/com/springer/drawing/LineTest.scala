package com.springer.drawing

import org.specs2.mutable.Specification
import org.scalamock.specs2.MockContext

class LineTest extends Specification {

  "Veritical line is applied to canvas" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(Coordinate(1, 1), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 3), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 4), 'x')

    val line = Line(Coordinate(1, 1), Coordinate(1, 4))
    line.applyTo(canvas)
  }

  "Horizontal line is applied to canvas" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(2, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(3, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(4, 2), 'x')

    val line = Line(Coordinate(1, 2), Coordinate(4, 2))
    line.applyTo(canvas)
  }
}
