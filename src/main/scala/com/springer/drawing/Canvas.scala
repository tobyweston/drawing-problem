package com.springer.drawing

trait Canvas  {
  def drawCharacter(coordinate: Coordinate, char: Char)
  def getTiles: Tiles
  def width: Int
  def height: Int
}
