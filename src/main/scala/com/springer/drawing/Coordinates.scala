package com.springer.drawing

case class Coordinates(coordinates: Coordinate*) {
  def onSingleAxis: Boolean = {
    val xs = coordinates.map(_.x).toSet
    val ys = coordinates.map(_.y).toSet
    xs.size == 1 || ys.size == 1
  }
}
