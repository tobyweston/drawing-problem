package com.springer.drawing

import java.awt.Color._

import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn
import com.springer.drawing.RaspberryPi.colourFrom

object RaspberryPi {
  def apply() = new RaspberryPi()

  private def colourFrom(char: Char) = {
    char match {
      case '-' | '|' => red
      case 'x' => blue
      case 'g' => green
      case _ => magenta
    }
  }
}

class RaspberryPi extends Display {
  def apply(canvas: Canvas) {
    val unicorn = new Ws2811Unicorn()
    canvas.tiles.foreach(tile => {
      unicorn.setPixelColor(tile._1.x, tile._1.y, colourFrom(tile._2))
    })
    unicorn.show()
  }
}
