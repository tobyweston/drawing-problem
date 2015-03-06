package com.springer.drawing

object Rectangle {
  def apply(upperLeft: Coordinate, lowerRight: Coordinate) = new Rectangle(upperLeft, lowerRight)
}

class Rectangle(upperLeft: Coordinate, lowerRight: Coordinate) extends Shape {
  def applyTo(canvas: Canvas): Unit = {
    Line(upperLeft, Coordinate(lowerRight.x, upperLeft.y)).applyTo(canvas)
    Line(Coordinate(lowerRight.x, upperLeft.y), lowerRight).applyTo(canvas)
    Line(upperLeft, Coordinate(upperLeft.x, lowerRight.y)).applyTo(canvas)
    Line(Coordinate(upperLeft.x, lowerRight.y), lowerRight).applyTo(canvas)
  }
}
