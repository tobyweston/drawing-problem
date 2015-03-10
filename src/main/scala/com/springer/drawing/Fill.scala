package com.springer.drawing

import com.springer.drawing.Validation._

import scala.collection.mutable

object Fill {
  def apply(groundZero: Coordinate, colour: Char, ignored: Seq[Char] = Seq('|', '-', 'x')) = new Fill(groundZero, colour, colour +: ignored)

  def unapply(options: List[String]): Option[(Int, Int, Char)] = {
    options match {
      case "B" :: x :: y :: c :: Nil if numbers(x, y) && char(c) => Some((x.toInt, y.toInt, c.charAt(0)))
      case _ => None
    }
  }
}

class Fill(groundZero: Coordinate, colour: Char, ignored: Seq[Char]) extends Drawable {

  def applyTo(canvas: Canvas) = {
    val coordinates = mutable.MutableList[Coordinate]()
    fill(groundZero, canvas.tiles)(coordinates, canvas.bounds)
    coordinates.foreach(coordinate => canvas.drawCharacter(coordinate, colour))
    canvas
  }

  private def fill(coordinate: Coordinate, tiles: Tiles)(implicit found: mutable.MutableList[Coordinate], bounds: RectangleBounds) {
    implicit val remaining = tiles - found

    if (coordinate.outside(bounds) || alreadyMatched(coordinate) || alreadyFilled(coordinate))
      return

    found += coordinate

    fill(coordinate.above, remaining)
    fill(coordinate.rightOf, remaining)
    fill(coordinate.below, remaining)
    fill(coordinate.leftOf, remaining)
  }

  private def alreadyMatched(coordinate: Coordinate)(implicit remaining: Tiles) = !remaining.contains(coordinate)

  private def alreadyFilled(coordinate: Coordinate)(implicit remaining: Tiles) = ignored.contains(remaining(coordinate))

}