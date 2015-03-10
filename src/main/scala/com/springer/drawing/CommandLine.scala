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
      case "C" :: Int(width) :: Int(height) :: Nil                => NewCanvas(width, height)
      case "L" :: Int(x1) :: Int(y1) :: Int(x2) :: Int(y2) :: Nil => Line((x1, y1), (x2, y2))
      case "R" :: Int(x1) :: Int(y1) :: Int(x2) :: Int(y2) :: Nil => Rectangle((x1, y1), (x2, y2))
      case "B" :: Int(x) :: Int(y) :: Char(colour) :: Nil         => Fill((x, y), colour)
      case "Q" :: Nil                                             => Quit()
      case _                                                      => DrawNothing()
    }
  }
}




