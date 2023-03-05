import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.*
import org.w3c.dom.events.*

class Canvas {
  val canvas = document.getElementById("display") as HTMLCanvasElement
  val ctx = canvas.getContext("2d")!! as CanvasRenderingContext2D
  
  init {
    canvas.width = window.innerWidth.toInt() - 20
    canvas.height = window.innerHeight.toInt() - 50
  }

  fun clear() {
    ctx.save()
    ctx.clearRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
    ctx.restore()
  }

  fun title() {
    ctx.save()
    ctx.font = "16px sans-serif"
    ctx.fillText("Mandlebrot Set", 0.0, 32.0)
    ctx.restore()
  }

  fun getSize() : Int {
    // Pretend we have an 800x800 grid
    return 800
  }

  fun draw(x: Int, y: Int) {
    ctx.save()
    val X = canvas.width.toDouble() / 800.0
    val Y = canvas.height.toDouble() / 800.0
 
    ctx.font = "8px sans-serif"
    ctx.fillRect((x.toDouble() * X), (y.toDouble() * Y), 2.0, 2.0)
    //ctx.fillText("*", (x.toDouble() * X), (y.toDouble() * Y))
    ctx.restore()
  }
}