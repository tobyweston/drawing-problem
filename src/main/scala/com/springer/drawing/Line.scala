package com.springer.drawing

import com.springer.drawing.Line.range

object Line {
  def apply(start: Coordinate, end: Coordinate) = {
    if (Coordinates(range(start, end): _*).onSingleAxis) new Line(start, end) else new NullShape
  }

  private def range(start: Coordinate, end: Coordinate): Seq[Coordinate] = {
    for {
      x <- start.x to end.x
      y <- start.y to end.y
    } yield {
      Coordinate(x, y)
    }
  }
}

class Line private(start: Coordinate, end: Coordinate) extends Shape {
  def applyTo(canvas: Canvas): Unit = {
    range(start, end).foreach(canvas.drawCharacter(_, 'x'))
  }
}
