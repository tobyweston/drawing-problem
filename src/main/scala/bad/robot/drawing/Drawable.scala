package bad.robot.drawing

trait Drawable {
  def applyTo(canvas: Canvas): Canvas
}
