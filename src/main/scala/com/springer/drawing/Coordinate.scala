package com.springer.drawing

object Coordinate {
  def apply(x: Int, y: Int) = new Coordinate(x, y)
}

class Coordinate(val x: Int, val y: Int) {
  if (x < 1 || y < 1)
    throw new InvalidCoordinate(x, y)
}

class InvalidCoordinate(x: Int, y: Int) extends Exception(s"Coordinates must start at (0, 0), you tried to create ($x, $y)")