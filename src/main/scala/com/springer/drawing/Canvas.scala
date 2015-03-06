package com.springer.drawing

object Canvas {
  def apply(width: Int, height: Int) = new Canvas(width, height)
}

class Canvas private(width: Int, height: Int) {

  val columns = width + 2
  val rows = height + 2

  private val canvas: Array[Array[Char]] = Array.ofDim(rows, columns)

  addBorder()

  def addBorder() {
    addHorizontalBorders()
    addVerticalBorders()
  }

  def addHorizontalBorders() {
    (0 until columns).foreach(x => {
      canvas(0)(x) = '-'
      canvas(rows - 1)(x) = '-'
    })
  }

  def addVerticalBorders() {
    (1 until rows - 1).foreach(y => {
      canvas(y)(0) = '|'
      canvas(y)(columns - 1) = '|'
    })
  }

  def drawCharacter(coordinate: Coordinate, char: Char) = canvas(coordinate.y)(coordinate.x) = char

  override def toString: String = {
    val newline = sys.props("line.separator")
    canvas.map(row => row.mkString("")).mkString(newline)
  }
}



