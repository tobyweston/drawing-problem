package com.springer.drawing

trait Shape {
  def applyTo(canvas: Canvas)
}

object Line {
  def apply(start: Coordinate, end: Coordinate) = new Line(start, end)
}

class Line(start: Coordinate, end: Coordinate) extends Shape {
  def applyTo(canvas: Canvas): Unit = {
    val line = for {
      x <- start.x to end.x
      y <- start.y to end.y
    } yield {
      Coordinate(x, y)
    }
    line.foreach(canvas.drawCharacter(_, 'x'))
  }
}
