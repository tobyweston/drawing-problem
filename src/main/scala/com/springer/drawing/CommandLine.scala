package com.springer.drawing

import scala.io.StdIn


object CommandLine extends App {

  var canvas: Canvas = new NullCanvas
  while (true) {
    val drawable = command(StdIn.readLine("enter command: "))
    canvas = drawable.applyTo(canvas)
    canvas.display(Console())
  }

  def command(command: String): Drawable = {
    command.split(" ").toList match {
      case NewCanvas(width, height)   => NewCanvas(width, height)
      case Line(x1, y1, x2, y2)       => Line(Coordinate(x1, y1), Coordinate(x2, y2))
      case Rectangle(x1, y1, x2, y2)  => Rectangle(Coordinate(x1, y1), Coordinate(x2, y2))
      case Fill(x, y, colour)         => Fill(Coordinate(x, y), colour)
      case "Q" :: Nil                 => Quit()
      case _                          => DrawNothing()
    }
  }
}




