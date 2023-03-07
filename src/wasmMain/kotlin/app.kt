import kotlinx.browser.window
import org.w3c.dom.events.*
import Canvas
import mandelbrot 

val canvas = Canvas()

fun drawSet() {
  canvas.clear()
  val matrix: Array<IntArray> = calculateSet(canvas.getSize(), 20)
  canvas.drawMatrix(matrix)
  canvas.title()
}

fun myEventListner(event: Event): Unit {
  drawSet()
}

fun main(){
  drawSet()
//  window.addEventListener("resize", {event -> myEventListner(event)});
}
