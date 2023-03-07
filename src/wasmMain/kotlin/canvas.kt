import kotlinx.browser.document
import kotlinx.browser.window
import kotlin.math.floor
import kotlin.math.max
import org.w3c.dom.*
import org.w3c.dom.events.*
import Color
import Palette

// Nasty hack as calling ctx.fillStyle hits a type bug
@JsFun("x => x")
external fun stringToDynamic(value: String) : Dynamic

class Canvas {
  val canvas = document.getElementById("display") as HTMLCanvasElement
  val ctx = canvas.getContext("2d")!! as CanvasRenderingContext2D
  fun cols(c: Color): String = "rgb(${c.r},${c.g},${c.b})"

  init {
    resetSize()
   }

  fun resetSize() {
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
    ctx.fillStyle = stringToDynamic(cols(Color.WHITE))
    ctx.fillText("Mandlebrot Set", 10.0, 32.0)
    ctx.restore()
  }

  fun getSize() : Int {
     return max(canvas.width, canvas.height)
  }

  fun drawMatrix(matrix: Array<IntArray>){
    var x = 0
    for(line in matrix) {
      var y = 0
      for (value in line) {
        drawPixel(x, y, value)
        y += 1
      }
      x += 1
    }
  }

  fun drawPixel(x: Int, y: Int, value:Int) {
    val size = getSize()
    val X = canvas.width.toDouble() / size
    val Y = canvas.height.toDouble() / size
    
    ctx.save()
    
    val paletteSize:Int  = Palette.wikiPalette.size - 1 // Oxford array
    val cStep: Double = 20.0 / paletteSize.toDouble()
    val index: Int = (floor(value.toDouble() / cStep)).toInt()
    //val index = if(cindex > paletteSize - 1) { paletteSize -1 } else  { cindex }
    
    ctx.fillStyle = stringToDynamic(cols(Palette.wikiPalette[index]))
    ctx.fillRect(floor(x.toDouble() * X), floor(y.toDouble() * Y), 1.0, 1.0) 
    ctx.restore()
  }
}