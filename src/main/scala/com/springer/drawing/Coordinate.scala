package com.springer.drawing

object Coordinate {
  implicit def tupleToCoordinate(coordinate: (Int, Int)): Coordinate = Coordinate(coordinate._1, coordinate._2)
}

case class Coordinate(x: Int, y: Int)