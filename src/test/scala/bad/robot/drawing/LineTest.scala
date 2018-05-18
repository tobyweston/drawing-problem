package bad.robot.drawing

import org.specs2.mutable.Specification
import org.scalamock.specs2.MockContext

class LineTest extends Specification {

  "Vertical line is applied to canvas" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(Coordinate(1, 1), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 3), 'x')
    (canvas.drawCharacter _).expects(Coordinate(1, 4), 'x')

    Line(Coordinate(1, 1), Coordinate(1, 4)).applyTo(canvas)
  }

  "Horizontal line is applied to canvas" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(2, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(3, 2), 'x')
    (canvas.drawCharacter _).expects(Coordinate(4, 2), 'x')

    Line(Coordinate(1, 2), Coordinate(4, 2)).applyTo(canvas)
  }

  "Coordinates that don't make a line are still valid, ie, you can draw a single point" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(Coordinate(2, 2), 'x')
    Line(Coordinate(2, 2), Coordinate(2, 2)).applyTo(canvas)
  }

  "Lines that span multiple axis have no affect on the canvas" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(*, *).never()
    Line(Coordinate(1, 1), Coordinate(2, 2)).applyTo(canvas)
  }

  "Drawing lines backwards has no affect" in new MockContext {
    val canvas = mock[Canvas]
    (canvas.drawCharacter _).expects(*, *).never()
    Line(Coordinate(1, 4), Coordinate(1, 1)).applyTo(canvas)
  }
}