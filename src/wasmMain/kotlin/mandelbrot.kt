import kotlinx.browser.document
import kotlinx.dom.appendElement
import kotlinx.dom.appendText
import Canvas
import complex 

val max  = 20

fun mandelbrot(z0: Complex, max: Int): Int {
    var z = z0

    repeat(max) {
        if (z.mod > 2.0) return it
        z = z * z + z0
    }

    return max
}

fun main() {
  val canvas = Canvas()
  canvas.clear()
  val size = canvas.getSize()
 
  var x = 0
  var y = 0
  val yStart : Double = 1.0 
  val yStep : Double = 2.0 / size

  while(y < size){
    val xStart : Double = -2.0 
    val xStep = 2.5 / size 
    x=0

    while(x < size) {
      canvas.draw(x, y, mandelbrot(complex((xStart + (x*xStep)), (yStart - (y*yStep))), 20))
      x += 1 
    }
    y += 1  
  }
  canvas.title()
}
