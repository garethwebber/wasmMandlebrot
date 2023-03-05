import kotlinx.browser.document
import org.w3c.dom.*
import org.w3c.dom.events.*

class Canvas {
  val canvas = document.getElementById("display") as HTMLCanvasElement
  val ctx = canvas.getContext("2d")!! as CanvasRenderingContext2D

  fun draw() {
    ctx.save()
    ctx.clearRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
    ctx.font = "32px sans-serif"
    ctx.fillText("Mandlebrot set", 0.0, 30.0)
    ctx.restore()
  }
}