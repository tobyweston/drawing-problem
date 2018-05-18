package bad.robot.drawing

trait Display {
  def apply(canvas: Canvas)
}

object Console {
  def apply(): Display = new Console()
}

class Console extends Display {
  def apply(canvas: Canvas) = println(canvas)
}

