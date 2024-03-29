package bad.robot.drawing

import org.specs2.mutable.Specification
import bad.robot.drawing.Coordinate.tupleToCoordinate
import org.scalamock.specs2.MockContext

class FillTest extends Specification {

  "fill entire bounds" in new MockContext {
    val canvas = mock[Canvas]
    val tiles = new Tiles(Seq(
      Coordinate(0, 0) -> '1', Coordinate(1, 0) -> '2', Coordinate(2, 0) -> '3',
      Coordinate(0, 1) -> '4', Coordinate(1, 1) -> '5', Coordinate(2, 1) -> '6',
      Coordinate(0, 2) -> '7', Coordinate(1, 2) -> '8', Coordinate(2, 2) -> '9'
    ): _*)

    (canvas.tiles _).expects().anyNumberOfTimes().returning(tiles)
    (canvas.bounds _).expects().anyNumberOfTimes().returning(RectangleBounds((0, 0), (2, 2)))
    (canvas.drawCharacter _).expects(Coordinate(1, 1), 'o')
    (canvas.drawCharacter _).expects(Coordinate(1, 0), 'o')
    (canvas.drawCharacter _).expects(Coordinate(2, 0), 'o')
    (canvas.drawCharacter _).expects(Coordinate(2, 1), 'o')
    (canvas.drawCharacter _).expects(Coordinate(2, 2), 'o')
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'o')
    (canvas.drawCharacter _).expects(Coordinate(0, 2), 'o')
    (canvas.drawCharacter _).expects(Coordinate(0, 1), 'o')
    (canvas.drawCharacter _).expects(Coordinate(0, 0), 'o')

    Fill((1, 1), 'o').applyTo(canvas)
  }

  "fill partial bounds" in new MockContext {
    val canvas = mock[Canvas]
    val tiles = new Tiles(Seq(
      Coordinate(0, 0) -> ' ', Coordinate(1, 0) -> 'x', Coordinate(2, 0) -> '3',
      Coordinate(0, 1) -> 'x', Coordinate(1, 1) -> 'x', Coordinate(2, 1) -> '6',
      Coordinate(0, 2) -> '7', Coordinate(1, 2) -> '8', Coordinate(2, 2) -> '9'
    ): _*)

    (canvas.tiles _).expects().anyNumberOfTimes().returning(tiles)
    (canvas.bounds _).expects().anyNumberOfTimes().returning(RectangleBounds((0, 0), (2, 2)))
    (canvas.drawCharacter _).expects(Coordinate(2, 0), 'o')
    (canvas.drawCharacter _).expects(Coordinate(2, 1), 'o')
    (canvas.drawCharacter _).expects(Coordinate(2, 2), 'o')
    (canvas.drawCharacter _).expects(Coordinate(1, 2), 'o')
    (canvas.drawCharacter _).expects(Coordinate(0, 2), 'o')

    Fill((2, 2), 'o').applyTo(canvas)
  }

  "don't fill if the starting coordinate is already occupied" >> {
    val colour = 'Z'
    val ignore = 'X'
    val tiles = new Tiles(Seq(
      Coordinate(0, 0) -> ignore, Coordinate(1, 0) -> ' ',
      Coordinate(0, 1) -> ' ',    Coordinate(1, 1) -> colour
    ): _*)

    "when occupied cell has already been drawn on (for example, by another shape)" in new MockContext {
      val canvas = mock[Canvas]
      (canvas.tiles _).expects().anyNumberOfTimes().returning(tiles)
      (canvas.bounds _).expects().anyNumberOfTimes().returning(RectangleBounds((0, 0), (1, 1)))
      (canvas.drawCharacter _).expects(*, *).never()

      Fill((0, 0), colour, Seq(ignore)).applyTo(canvas)
    }

    "when occupied cell has already been filled (painted the colour)" in new MockContext {
      val canvas = mock[Canvas]
      (canvas.tiles _).expects().anyNumberOfTimes().returning(tiles)
      (canvas.bounds _).expects().anyNumberOfTimes().returning(RectangleBounds((0, 0), (1, 1)))
      (canvas.drawCharacter _).expects(*, *).never()

      Fill((1, 1), colour, Seq(ignore)).applyTo(canvas)
    }
  }
}