package bad.robot.drawing

import org.scalamock.specs2.MockContext
import org.specs2.mutable.Specification

class RectangleTest extends Specification {

  "Draw a rectangle" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(Coordinate(1, 1), 'x').atLeastOnce()
    (canvas.drawCharacter _).expects(Coordinate(2, 1), 'x')
    (canvas.drawCharacter _).expects(Coordinate(3, 1), 'x').atLeastOnce()
    (canvas.drawCharacter _).expects(Coordinate(3, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(3, 3), 'x').atLeastOnce()
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 3), 'x').atLeastOnce()
    (canvas.drawCharacter _).expects(Coordinate(2, 3), 'x')

    Rectangle(Coordinate(1, 1), Coordinate(3, 3)).applyTo(canvas)
  }

  "Drawing an invalid rectangle region" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(*, *).never()
    Rectangle(Coordinate(3, 3), Coordinate(1, 1)).applyTo(canvas)
  }
}
