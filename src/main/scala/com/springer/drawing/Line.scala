package com.springer.drawing


import com.springer.drawing.Coordinate._
import com.springer.drawing.Validation._

object Line {
  def apply(start: Coordinate, end: Coordinate) = {
    if (Coordinates(range(start, end): _*).onSingleAxis) new Line(start, end) else new DrawNothing
  }

  def unapply(options: List[String]): Option[(Int, Int, Int, Int)] = {
    options match {
      case "L" :: x1 :: y1 :: x2 :: y2 :: Nil if numbers(x1, y1, x2, y2) => Some((x1.toInt, y1.toInt, x2.toInt, y2.toInt))
      case _ => None
    }
  }
}

class Line private(start: Coordinate, end: Coordinate) extends Drawable {
  def applyTo(canvas: Canvas) = {
    range(start, end).foreach(canvas.drawCharacter(_, 'x'))
    canvas
  }
}
