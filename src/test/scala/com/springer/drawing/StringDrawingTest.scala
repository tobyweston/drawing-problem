package com.springer.drawing

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._

class StringDrawingTest {

  val newline = sys.props("line.separator")
  val string = new StringBuilder

  @Test
  def drawHorizontalBorder() {
    StringDrawing.addHorizontalBorderTo(string, 5)
    assertThat(string.mkString, is("-------" + newline))
  }

  @Test
  def drawVerticalBorder() {
    StringDrawing.addVerticalBordersTo(string, 10, 2)
    assertThat(string.mkString, is("|          |" + newline + "|          |" + newline))
  }


}
