package com.springer.drawing

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.rules.ExpectedException

class CanvasTest {

  @Test
  def displayEmptyCanvas() {
    val canvas = Canvas(10, 4)
    val x =

    assertThat(canvas.toString, is(
      """------------
        *|          |
        *|          |
        *|          |
        *|          |
        *------------""".stripMargin('*')))
  }

  @Test (expected = classOf[NotImplementedError])
  def canDrawLine() {
    val canvas = Canvas(10, 4)
    canvas.drawCharacter(Coordinate(1, 2), 'X')
  }

}
