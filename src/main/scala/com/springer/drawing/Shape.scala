package com.springer.drawing

trait Shape {
  def applyTo(canvas: Canvas)
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

object Test extends App {
  val canvas = Canvas(10, 4)
  new Line(Coordinate(1, 2), Coordinate(6, 2)).applyTo(canvas)
  new Line(Coordinate(6, 3), Coordinate(6, 4)).applyTo(canvas)
  println(canvas.toString)
}

