package bad.robot.drawing

object Coordinate {

  def range(start: Coordinate, end: Coordinate): Seq[Coordinate] = {
    for {
      x <- start.x to end.x
      y <- start.y to end.y
    } yield {
      Coordinate(x, y)
    }
  }

  implicit def tupleToCoordinate(coordinate: (Int, Int)): Coordinate = Coordinate(coordinate._1, coordinate._2)
}

case class Coordinate(x: Int, y: Int) {
  def above = (x, y - 1)
  def rightOf = (x + 1, y)
  def below = (x, y + 1)
  def leftOf = (x - 1, y)
  def <(coordinate: Coordinate) = x < coordinate.x || y < coordinate.y
  def >(coordinate: Coordinate) = x > coordinate.x || y > coordinate.y
  def outside(bounds: RectangleBounds) = this < bounds.upperLeft || this > bounds.lowerRight

  override def toString: String = s"($x, $y)"
}