package com.springer.drawing

import java.awt.Color._

import bad.robot.unicorn.neopixel.PlatformSafeUnicorn._
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn
import com.springer.drawing.RaspberryPi.colourFrom

object RaspberryPi {
  def apply() = new RaspberryPi()

  private def colourFrom(char: Char) = {
    char match {
      case '-' | '|' => red
      case 'x' => blue
      case 'g' => green
      case 'y' => yellow
      case 'o' => orange
      case ' ' => black
      case _ => magenta
    }
  }
}

class RaspberryPi extends Display {
  private val unicorn = createPlatformSafeUnicorn(new Ws2811Unicorn())

  unicorn.setBrightness(0.1)
  sys.addShutdownHook(unicorn.shutdown())

  def apply(canvas: Canvas) {
    canvas.tiles.foreach(tile => {
      unicorn.setPixelColor(tile._1.x, tile._1.y, colourFrom(tile._2))
    })
    unicorn.show()
  }
}
