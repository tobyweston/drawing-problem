package com.springer.drawing

import StringDrawing._

object Canvas {
  def apply(width: Int, height: Int) = new Canvas(width, height)
}

class Canvas private(width: Int, height: Int) {

  override def toString: String = {

    val string = new StringBuilder
    addHorizontalBorderTo(string, width)
    addVerticalBordersTo(string, width, height)
    addHorizontalBorderTo(string, width)
    string.mkString
  }
}

object StringDrawing {

  private val newline = sys.props("line.separator")

  def addHorizontalBorderTo(string: StringBuilder, width: Int) = {
    (-2 until width).foreach(_ => string ++= "-")
    string ++= newline
  }

  def addVerticalBordersTo(string: StringBuilder, width: Int, height: Int) = {
    (0 until height).foreach(_ => string ++= "|".padTo(width + 1, " ").mkString ++= "|" ++= newline)
  }

}

