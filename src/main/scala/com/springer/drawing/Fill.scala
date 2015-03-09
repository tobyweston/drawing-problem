package com.springer.drawing

import scala.collection.mutable

object Fill {
  def apply(groundZero: Coordinate, colour: Char, ignored: Seq[Char] = Seq('|', '-', 'x')) = new Fill(groundZero, colour, colour +: ignored)
}

class Fill(groundZero: Coordinate, colour: Char, ignored: Seq[Char]) extends Drawable {

  def applyTo(canvas: Canvas) = {
    val coordinates = mutable.MutableList[Coordinate]()
    fill(groundZero, canvas.tiles)(coordinates, canvas.bounds)
    coordinates.foreach(coordinate => canvas.drawCharacter(coordinate, colour))
  }

  private def fill(coordinate: Coordinate, tiles: Tiles)(implicit coordinates: mutable.MutableList[Coordinate], bounds: RectangleBounds) {
    if (!paintable(coordinate, tiles, bounds))
      return

    coordinates += coordinate

    val remaining = tiles.filter(!coordinates.contains(_))
    fill(coordinate.above, remaining)
    fill(coordinate.rightOf, remaining)
    fill(coordinate.below, remaining)
    fill(coordinate.leftOf, remaining)
  }

  private def paintable(coordinate: Coordinate, tiles: Tiles, bounds: RectangleBounds): Boolean = {
    if (coordinate.outSide(bounds))
      return false
    if (!tiles.contains(coordinate))
      return false
    if (ignored.contains(tiles(coordinate)))
      return false
    true
  }
}