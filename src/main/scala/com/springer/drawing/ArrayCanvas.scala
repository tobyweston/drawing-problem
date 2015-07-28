package com.springer.drawing

object ArrayCanvas {
  def apply(width: Int, height: Int) = new ArrayCanvas(width + 2, height + 2)
}

class ArrayCanvas private(columns: Int, rows: Int) extends Canvas {

  private val canvas = Array.fill(rows, columns)(' ')

  Border().applyTo(canvas)

  def drawCharacter(coordinate: Coordinate, char: Char) = {
    if (valid(coordinate))
      canvas(coordinate.y)(coordinate.x) = char
  }

  private def valid(coordinate: Coordinate): Boolean = {
    def validX = coordinate.x > 0 && coordinate.x < columns -1
    def validY = coordinate.y > 0 && coordinate.y < rows -1

    validX && validY
  }

  def tiles: Tiles = {
    val tiles = for {
      x <- 0 until columns
      y <- 0 until rows
    } yield {
      Coordinate(x, y) -> canvas(y)(x)
    }
    new Tiles(tiles:_*)
  }

  override def bounds = RectangleBounds(Coordinate(1, 1), Coordinate(columns, rows))

  override def toString: String = {
    val newline = sys.props("line.separator")
    canvas.map(row => row.mkString("")).mkString(newline)
  }
}
