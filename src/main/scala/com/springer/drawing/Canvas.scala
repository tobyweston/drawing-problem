package com.springer.drawing

trait Canvas  {
  def drawCharacter(coordinate: Coordinate, char: Char)
  def tiles: Tiles
  def bounds: RectangleBounds
}
