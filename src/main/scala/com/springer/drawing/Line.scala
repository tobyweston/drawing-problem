package com.springer.drawing

import com.springer.drawing.Coordinate._

object Line {
  def apply(start: Coordinate, end: Coordinate) = {
    if (Coordinates(range(start, end): _*).onSingleAxis) new Line(start, end) else new NullShape
  }
}

class Line private(start: Coordinate, end: Coordinate) extends Shape {
  def applyTo(canvas: Canvas): Unit = {
    range(start, end).foreach(canvas.drawCharacter(_, 'x'))
  }
}
