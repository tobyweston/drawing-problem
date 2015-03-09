package com.springer.drawing

import scala.collection.mutable

object Fill {
  def apply(groundZero: Coordinate, colour: Char) = new Fill(groundZero, colour)
}

class Fill(groundZero: Coordinate, colour: Char) extends Drawable {

  def applyTo(canvas: Canvas) = {
    def fillRegion(coordinate: Coordinate, tiles: Tiles)(implicit region: mutable.MutableList[Coordinate]) {
      if (!paintable(coordinate, tiles, canvas.width, canvas.height))
        return

      region += coordinate

      val remaining = tiles.filter(!region.contains(_))
      fillRegion(coordinate.above, remaining)
      fillRegion(coordinate.rightOf, remaining)
      fillRegion(coordinate.below, remaining)
      fillRegion(coordinate.leftOf, remaining)
    }

    val coordinates = mutable.MutableList[Coordinate]()
    fillRegion(groundZero, canvas.getTiles)(coordinates)
    coordinates.foreach(coordinate => canvas.drawCharacter(coordinate, colour))
  }

  def paintable(coordinate: Coordinate, tiles: Tiles, width: Int, height: Int): Boolean = {
    if (coordinate.outSide(RectangleBounds(Coordinate(0,0), Coordinate(width, height))))
      return false
    if (!tiles.contains(coordinate))
      return false
    if (Seq(colour, '|', '-', 'x').contains(tiles(coordinate)))
      return false
    true
  }
}