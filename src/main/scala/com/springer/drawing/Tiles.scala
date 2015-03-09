package com.springer.drawing

case class Tiles private(values: Map[Coordinate, Char]) {

  private val tiles = values

  def this(values: (Coordinate, Char)*) = {
    this(values.toMap)
  }

  def filter(function: Coordinate => Boolean): Tiles = new Tiles(tiles.filterKeys(function))

  def contains(coordinate: Coordinate) = tiles.keySet.contains(coordinate)

  def apply(coordinate: Coordinate) = tiles.apply(coordinate)

}
