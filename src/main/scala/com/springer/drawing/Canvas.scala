package com.springer.drawing

trait Canvas {
  def drawCharacter(coordinate: Coordinate, char: Char)
}

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

  override def toString: String = {
    val newline = sys.props("line.separator")
    canvas.map(row => row.mkString("")).mkString(newline)
  }
}