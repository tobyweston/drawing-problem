package com.springer.drawing

import com.springer.drawing.Validation._

object Rectangle {
  def apply(upperLeft: Coordinate, lowerRight: Coordinate) = new Rectangle(upperLeft, lowerRight)

  def unapply(options: List[String]): Option[(Int, Int, Int, Int)] = {
    options match {
      case "R" :: x1 :: y1 :: x2 :: y2 :: Nil if numbers(x1, y1, x2, y2) => Some((x1.toInt, y1.toInt, x2.toInt, y2.toInt))
      case _ => None
    }
  }
}

class Rectangle(upperLeft: Coordinate, lowerRight: Coordinate) extends Drawable {
  def applyTo(canvas: Canvas) = {
    Line(upperLeft, Coordinate(lowerRight.x, upperLeft.y)).applyTo(canvas)
    Line(Coordinate(lowerRight.x, upperLeft.y), lowerRight).applyTo(canvas)
    Line(upperLeft, Coordinate(upperLeft.x, lowerRight.y)).applyTo(canvas)
    Line(Coordinate(upperLeft.x, lowerRight.y), lowerRight).applyTo(canvas)
    canvas
  }
}
