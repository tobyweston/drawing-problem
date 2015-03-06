package com.springer.drawing

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.rules.ExpectedException

class CanvasTest {

  val canvas = Canvas(10, 4)

  @Test
  def displayEmptyCanvas() {
    assertThat(canvas.toString, is(
      """------------
        *|          |
        *|          |
        *|          |
        *|          |
        *------------""".stripMargin('*')))
  }

  @Test
  def canDrawSingleCharacter() {
    canvas.drawCharacter(Coordinate(1, 2), 'x')
    assertThat(canvas.toString, is(
      """------------
        *|          |
        *|x         |
        *|          |
        *|          |
        *------------""".stripMargin('*')))
  }

}
