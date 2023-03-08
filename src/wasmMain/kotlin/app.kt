import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.appendText
import org.w3c.dom.events.*
import Canvas
import mandelbrot 
import time

val canvas = Canvas()
val timeDiv = document.createElement("div") 
var startX: Double = -2.0
var startY: Double = -1.2
var endX: Double = 2.55
var endY: Double = 2.4
var zoom: Double = 1.0

fun drawSet() {
  canvas.clear()
  
  val matrix: Array<IntArray> = measureTimeMillis({ time -> timeDiv.appendText("Calculation time: $time ms, ") }) {
    calculateSet(startX, startY, endX, endY, canvas.getSize(), 20)
  }
  measureTimeMillis({ dtime -> timeDiv.appendText("draw time: $dtime ms.") }) {
    canvas.drawMatrix(matrix)
  }
  canvas.title()
}

fun zoomListner(event: Event): Unit {
  val em = event as MouseEvent

  var lengthX = endX - startX
  var lengthY = endY - startY
  
  var relX = canvas.pixelToValueX(em.offsetX) 
  var relY = canvas.pixelToValueY(em.offsetY)
  var clickX = startX + (lengthX * relX)
  var clickY = startY + (lengthY * relY)
  
  var newstartX = clickX - (lengthX * 0.25)
  var newstartY = clickY - (lengthY * 0.25)
  var newendX   = clickX + (lengthX * 0.25)
  var newendY   = clickY + (lengthY * 0.25)
  
  startX = newstartX
  startY = newstartY
  endX = newendX
  endY = newendY
  drawSet()
}

fun resizeListner(event: Event): Unit {
  canvas.resetSize()
  drawSet()
}

fun main(){
  document.body?.appendChild(timeDiv)
  drawSet()
  
  window.addEventListener("mousedown", {event -> zoomListner(event)});
  window.addEventListener("resize",  {event -> resizeListner(event)});
}
