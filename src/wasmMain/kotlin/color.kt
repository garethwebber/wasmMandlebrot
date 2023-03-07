data class Color(val r: Int, val g: Int, val b: Int) {
  companion object {
    val WHITE = Color(255, 255, 255)
    val BLACK = Color(0, 0, 0)
    val RED = Color(255, 0, 0)
    val GREEN = Color(0, 255, 0)
    val BLUE = Color(0, 0, 255)
    val MAGENTA = Color(255, 0, 255)
    val CYAN = Color(0, 255, 255)
    val YELLOW = Color(255, 255, 0)
    val ORANGE = Color(255, 200, 0)
    val GRAY = Color(128, 128, 128)
    val DARK_GRAY = Color(64, 64, 64)
    val LIGHT_GRAY = Color(192, 192, 192)
    val PINK = Color(255, 175, 175)

    val u1 = Color (  0,   7, 100)
    val u2 = Color ( 32, 107, 203)
    val u3 = Color (237, 255, 255)
    val u4 = Color (255, 170,   0)
    val u5 = Color (  0,   2,   0)
  }
  
  constructor(rgb: Int) : 
    this(rgb shr 16, (rgb shr 8) and 0xff, rgb and 0xff) { }
}