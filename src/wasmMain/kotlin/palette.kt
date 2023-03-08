 import Color

 object Palette {
   fun getPalette(): List<List<Color>> {
     return listOf(
       defaultPalette,
       ultraPalette,
       wikiPalette
     )
   }

   val defaultPalette: List<Color> = listOf(
    Color.RED,
    Color.ORANGE,
    Color.YELLOW,
    Color.GREEN,
    Color.BLUE,
    Color.MAGENTA,
    Color.BLACK
  )

  val ultraPalette: List<Color> = listOf(
    Color.u1,
    Color.u2,
    Color.u3,
    Color.u4,
    Color.u5
  )

  val wikiPalette: List<Color> = listOf(
    Color.w1,
    Color.w2,
    Color.w3,
    Color.w4,
    Color.w5,
    Color.w6,
    Color.w7,
    Color.w8,
    Color.w9,
    Color.w10,
    Color.w11,
    Color.w12,
    Color.w13,
    Color.w14,
    Color.w15,
    Color.w16,
    Color.BLACK
 )}