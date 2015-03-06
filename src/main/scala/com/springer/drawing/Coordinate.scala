package com.springer.drawing

object Coordinate {
  def apply(x: Int, y: Int) = new Coordinate(x, y)
}

class Coordinate(val x: Int, val y: Int)
