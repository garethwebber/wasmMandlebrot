import kotlinx.browser.document
import org.w3c.dom.*
import org.w3c.dom.events.*

class Canvas {
  val canvas = document.getElementById("display") as HTMLCanvasElement
  val ctx = canvas.getContext("2d")!! as CanvasRenderingContext2D

  fun clear() {
    ctx.save()
    ctx.clearRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
    ctx.restore()
  }

  fun title() {
    ctx.save()
    ctx.font = "16px sans-serif"
    ctx.fillText("Mandlebrot Set", 0.0, 16.0)
    ctx.restore()
  }

 fun draw(x: Int, y: Int) {
    ctx.save()
    val X = canvas.width.toDouble() / 80.0
    val Y = canvas.height.toDouble() / 80.0
 
    ctx.font = "8px sans-serif"
    ctx.fillText("X", (x.toDouble() * X), (y.toDouble() * Y))
    ctx.restore()
  }
}