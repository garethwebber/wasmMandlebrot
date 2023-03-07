import complex 

fun mandelbrot(z0: Complex, max: Int): Int {
    var z = z0

    repeat(max) {
        if (z.mod > 2.0) return it
        z = z * z + z0
    }

    return max
}

fun calculateSet(size: Int, max: Int): Array<IntArray> {
  var matrix: Array<IntArray> = Array(size) { IntArray(size) }
  var x = 0
  var y = 0
  val yStart : Double = 1.0 
  val yStep : Double = 2.0 / size

  while(y < size){
    val xStart : Double = -2.0 
    val xStep = 2.5 / size 
    x=0

    while(x < size) {
     matrix[x][y] = mandelbrot(complex((xStart + (x*xStep)), (yStart - (y*yStep))), max)
      x += 1 
    }
    y += 1  
  }
  return matrix
}