package com.springer.drawing

object Quit {
  def apply() = new Quit
}

class Quit extends Drawable {
  def applyTo(canvas: Canvas): Canvas = sys.exit(0)
}
