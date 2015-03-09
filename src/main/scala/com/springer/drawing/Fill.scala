package com.springer.drawing

import scala.collection.mutable

object Fill {
  def apply(groundZero: Coordinate, colour: Char, ignored: Seq[Char] = Seq('|', '-', 'x')) = new Fill(groundZero, colour, colour +: ignored)
}

class Fill(groundZero: Coordinate, colour: Char, ignored: Seq[Char]) extends Drawable {

  def applyTo(canvas: Canvas) = {
    def fillRegion(coordinate: Coordinate, tiles: Tiles)(implicit region: mutable.MutableList[Coordinate]) {
      if (!paintable(coordinate, tiles, canvas.bounds))
        return

      region += coordinate

      val remaining = tiles.filter(!region.contains(_))
      fillRegion(coordinate.above, remaining)
      fillRegion(coordinate.rightOf, remaining)
      fillRegion(coordinate.below, remaining)
      fillRegion(coordinate.leftOf, remaining)
    }

    val coordinates = mutable.MutableList[Coordinate]()
    fillRegion(groundZero, canvas.tiles)(coordinates)
    coordinates.foreach(coordinate => canvas.drawCharacter(coordinate, colour))
  }

  def paintable(coordinate: Coordinate, tiles: Tiles, bounds: RectangleBounds): Boolean = {
    if (coordinate.outSide(bounds))
      return false
    if (!tiles.contains(coordinate))
      return false
    if (ignored.contains(tiles(coordinate)))
      return false
    true
  }
}