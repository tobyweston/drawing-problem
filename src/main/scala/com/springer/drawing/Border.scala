package com.springer.drawing

object Border {
  def apply(horizontal: Char, vertical: Char) = new Border(horizontal, vertical)
}

class Border(horizontal: Char, vertical: Char) {

  def applyTo(array: Array[Array[Char]]) {
    if (array.map(_.length).toSet.size > 1)
      throw new CannotApplyBorder
    addHorizontalBorders(array)
    addVerticalBorders(array)
  }

  private def addHorizontalBorders(array: Array[Array[Char]]) {
    val rows = array.length
    val columns = array.head.length

    (0 until columns).foreach(column => {
      array(0)(column) = horizontal
      array(rows - 1)(column) = horizontal
    })
  }

  private def addVerticalBorders(array: Array[Array[Char]]) {
    val rows = array.length
    val columns = array.head.length

    (1 until rows - 1).foreach(row => {
      array(row)(0) = vertical
      array(row)(columns - 1) = vertical
    })
  }
}

class CannotApplyBorder extends Exception("Can not apply a border to an irregular sized 2D array. Each nested array must have the same size")