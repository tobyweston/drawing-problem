package bad.robot.drawing

case class Tiles private(values: Map[Coordinate, Char]) {

  private val tiles = values

  def this(values: (Coordinate, Char)*) = {
    this(values.toMap)
  }

  def -(coordinate: Coordinate) = Tiles(tiles - coordinate)

  def -(coordinates: Seq[Coordinate]) = Tiles(tiles.filterNot(t => coordinates.contains(t._1)))

  def contains(coordinate: Coordinate) = tiles.keySet.contains(coordinate)

  def apply(coordinate: Coordinate) = tiles.apply(coordinate)

}
