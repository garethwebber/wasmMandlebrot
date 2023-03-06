import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.*
import org.w3c.dom.events.*

// Nasty hack as calling ctx.fillStyle hits a type bug
@JsFun("x => x")
external fun stringToDynamic(value: String) : Dynamic

class Canvas {
  val canvas = document.getElementById("display") as HTMLCanvasElement
  val ctx = canvas.getContext("2d")!! as CanvasRenderingContext2D
  private fun cols(c: Color): String = "rgb(${c.r},${c.g},${c.b})"

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
    ctx.font = "24px sans-serif"
    ctx.fillText("Mandlebrot Set", 10.0, 32.0)
    ctx.restore()
  }

  fun getSize() : Int {
    // Pretend we have an 800x800 grid
    return 800
  }

  fun draw(x: Int, y: Int, color: Int) {
    val X = canvas.width.toDouble() / 800.0
    val Y = canvas.height.toDouble() / 800.0
 
    ctx.save()
    when(color) {
      in 0..4   -> ctx.fillStyle = stringToDynamic(cols(Color.YELLOW))
      in 5..9  -> ctx.fillStyle = stringToDynamic(cols(Color.GREEN))
      in 10..14 -> ctx.fillStyle = stringToDynamic(cols(Color.ORANGE))
      in 15..19 -> ctx.fillStyle = stringToDynamic(cols(Color.BLUE))
      else      -> ctx.fillStyle = stringToDynamic(cols(Color.BLACK))
     }
     ctx.fillRect((x.toDouble() * X), (y.toDouble() * Y), 1.0, 1.0) 
    ctx.restore()
  }
}