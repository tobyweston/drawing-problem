package com.springer.drawing

trait Canvas {
  def drawCharacter(coordinate: Coordinate, char: Char)
  def tiles: Tiles
  def bounds: RectangleBounds
  def display(displays: Display*) = displays.foreach(_(this))
}

class NullCanvas extends Canvas {
  def drawCharacter(coordinate: Coordinate, char: Char): Unit = ()
  def tiles: Tiles = new Tiles()
  def bounds: RectangleBounds = RectangleBounds(Coordinate(0, 0), Coordinate(0, 0))
  override def display(display: Display*) = ()
  override def toString: String = ""
}