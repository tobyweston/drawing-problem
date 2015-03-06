package com.springer.drawing

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._

class CanvasTest {

  @Test
  def displayEmptyCanvas() {
    val canvas = Canvas(8, 5)
    assertThat(canvas.toString, is(
      """----------
        *|        |
        *|        |
        *|        |
        *|        |
        *|        |
        *----------
        *""".stripMargin('*')))
  }

}
