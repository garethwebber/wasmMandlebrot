import complex 

fun mandelbrot(z0: Complex, max: Int): Int {
    var z = z0

    repeat(max) {
        if (z.mod > 2.0) return it
        z = z * z + z0
    }

    return max
}

fun calculateSet(xStart: Double, yStart: Double, xEnd:Double, yEnd:Double, size: Int, max: Int): Array<IntArray> {
  var matrix: Array<IntArray> = Array(size) { IntArray(size) }
  var x = 0
  var y = 0
  val yStep : Double = yEnd / size 

  while(y < size){
    val xStep = xEnd / size
    x=0

    while(x < size) {
     matrix[x][y] = mandelbrot(complex((xStart + (x*xStep)), (yStart + (y*yStep))), max)
      x += 1 
    }
    y += 1  
  }
  return matrix
}