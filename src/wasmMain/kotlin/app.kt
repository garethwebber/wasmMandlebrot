import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.appendText
import org.w3c.dom.events.*
import Canvas
import mandelbrot 
import time

val canvas = Canvas()
val timeDiv = document.createElement("div") 

fun drawSet() {
  canvas.clear()
  
  val matrix: Array<IntArray> = measureTimeMillis({ time -> timeDiv.appendText("Calculation time: $time ms, ") }) {
    calculateSet(canvas.getSize(), 20)
  }
  measureTimeMillis({ dtime -> timeDiv.appendText("draw time: $dtime ms.") }) {
    canvas.drawMatrix(matrix)
  }
  canvas.title()
}

fun myEventListner(event: Event): Unit {
  canvas.resetSize()
  drawSet()
}

fun main(){
  document.body?.appendChild(timeDiv)
  drawSet()
  
  window.addEventListener("resize", {event -> myEventListner(event)});
}
