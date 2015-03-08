package com.springer.drawing

object Example extends App {
  val canvas = ArrayCanvas(20, 4)
  Line((1, 2), (6, 2)).applyTo(canvas)
  Line((6, 3), (6, 4)).applyTo(canvas)
  Rectangle((16, 1), (20, 3)).applyTo(canvas)
  Fill((10, 2), 'o').applyTo(canvas)

  println(canvas)
}
