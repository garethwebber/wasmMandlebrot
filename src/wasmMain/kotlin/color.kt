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


    val w1  = Color (66, 30, 15);
    val w2  = Color (25, 7, 26);
    val w3  = Color (9, 1, 47);
    val w4  = Color (4, 4, 73);
    val w5  = Color (0, 7, 100);
    val w6  = Color (12, 44, 138);
    val w7  = Color (24, 82, 177);
    val w8  = Color (57, 125, 209);
    val w9  = Color (134, 181, 229);
    val w10 = Color (211, 236, 248);
    val w11 = Color (241, 233, 191);
    val w12 = Color (248, 201, 95);
    val w13 = Color (255, 170, 0);
    val w14 = Color (204, 128, 0);
    val w15 = Color (153, 87, 0);
    val w16 = Color (106, 52, 3);
  }
  
  constructor(rgb: Int) : 
    this(rgb shr 16, (rgb shr 8) and 0xff, rgb and 0xff) { }
}