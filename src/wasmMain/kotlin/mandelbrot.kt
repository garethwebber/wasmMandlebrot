import kotlinx.browser.document
import kotlinx.dom.appendElement
import kotlinx.dom.appendText
import complex 

val size = 50
val max  = 20

fun toSymbol(value: Int) : String {
  if (value == max) {
    return "*"
  }

  return " "
}

fun mandelbrot(z0: Complex, max: Int): Int {
    var z = z0

    repeat(max) {
        if (z.mod > 2.0) return it
        z = z * z + z0
    }

    return max
}

fun main() {
    document.body?.appendText("Running mandlebrot computation")
    val code = document.createElement("div") 
    code.className = "ascii-art"
    document.body?.appendChild(code)
    var y : Double = 1.0 
    var yStep : Double = 2.0 / size

    while(y >= -1){
      var x : Double = -2.0 
      var xStep = 2.5 / (size * 2.0)

      while(x <= 0.5) {
        code.appendText(toSymbol(mandelbrot(complex(x, y), 20)))
        x += xStep 
      }

      code.appendText("\n")
      y -= yStep 
    }
}
