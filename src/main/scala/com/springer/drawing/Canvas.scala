package com.springer.drawing

object Canvas {
  def apply(width: Int, height: Int) = new Canvas(width + 2, height + 2)
}

class Canvas private(columns: Int, rows: Int) {

  private val canvas: Array[Array[Char]] = Array.ofDim(rows, columns)

  addBorder()

  def addBorder() {
    addHorizontalBorders()
    addVerticalBorders()
  }

  def addHorizontalBorders() {
    (0 until columns).foreach(column => {
      canvas(0)(column) = '-'
      canvas(rows - 1)(column) = '-'
    })
  }

  def addVerticalBorders() {
    (1 until rows - 1).foreach(row => {
      canvas(row)(0) = '|'
      canvas(row)(columns - 1) = '|'
    })
  }

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



