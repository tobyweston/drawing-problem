package com.springer.drawing

import com.springer.drawing.Coordinate._

object Line {
  def apply(start: Coordinate, end: Coordinate) = {
    if (Coordinates(range(start, end): _*).onSingleAxis) new Line(start, end) else new DrawNothing
  }
}

class Line private(start: Coordinate, end: Coordinate) extends Drawable {
  def applyTo(canvas: Canvas) = {
    range(start, end).foreach(canvas.drawCharacter(_, 'x'))
    canvas
  }
}
