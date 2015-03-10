package com.springer.drawing

import com.springer.drawing.Validation._

class NewCanvas(width: Int, height: Int) extends Drawable {
  override def applyTo(canvas: Canvas) = ArrayCanvas(width, height)
}

object NewCanvas {
  def apply(width: Int, height: Int) = new NewCanvas(width: Int, height: Int)

  def unapply(options: List[String]): Option[(Int, Int)] = {
    options match {
      case "C" :: width :: height :: Nil if numbers(width, height) => Some((width.toInt, height.toInt))
      case _ => None
    }
  }
}