package com.springer.drawing

case class Rectangle(upperLeft: Coordinate, lowerRight: Coordinate) extends Drawable {
  def applyTo(canvas: Canvas) = {
    Line(upperLeft, Coordinate(lowerRight.x, upperLeft.y)).applyTo(canvas)
    Line(Coordinate(lowerRight.x, upperLeft.y), lowerRight).applyTo(canvas)
    Line(upperLeft, Coordinate(upperLeft.x, lowerRight.y)).applyTo(canvas)
    Line(Coordinate(upperLeft.x, lowerRight.y), lowerRight).applyTo(canvas)
    canvas
  }
}
