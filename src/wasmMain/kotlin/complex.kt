import kotlin.math.*

interface Complex {
    val re: Double
    val im: Double

    val mod: Double
        get() {
            return kotlin.math.sqrt(re * re + im * im)
        }

    operator fun plus(z: Complex): Complex {
        return complex(re + z.re, im + z.im)
    }

    operator fun times(z: Complex): Complex {
        return complex(re * z.re - im * z.im, im * z.re + re * z.im)
    }

}

/**
 * Creates a complex number from real and imaginary part.
 */
var complex: (re: Number, im: Number) -> Complex = { re, im -> DefaultComplex(re.toDouble(), im.toDouble()) }

/**
 * A default implementation of the interface <code>Complex</code>
 */
open class DefaultComplex(override val re: Double, override val im: Double = 0.0) : Complex {
    constructor(z: Complex) : this(z.re, z.im)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other === null) return false
        if (other is Complex) {
            if (re != other.re) return false
            if (im != other.im) return false
            return true
        }
        return false
    }

    override fun hashCode(): Int {
        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        return result
    }
}
