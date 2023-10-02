import kotlin.math.sqrt

//Complex number representation x + yi for example 4 + 5i
data class ComplexNumber(
    val x: Double,
    val y: Double
) {
    operator fun plus(other: ComplexNumber) =
        ComplexNumber(
            x = this.x + other.x,
            y = this.y + other.y
        )

    operator fun minus(other: ComplexNumber) =
        ComplexNumber(
            x = this.x - other.x,
            y = this.y - other.y
        )

    operator fun times(other: ComplexNumber): ComplexNumber {
        val a = this.x * other.x - this.y * other.y
        val b = this.x * other.y + this.y * other.x
        return ComplexNumber(x = a, y = b)
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        val a = this.x * other.x - this.y * (-other.y)
        val b = this.x * (-other.y) + this.y * other.x
        val denominator = other.x * other.x - other.y * (-other.y)
        return ComplexNumber(x = a / denominator, y = b / denominator)
    }

    fun abs(): Double = sqrt(this.x * this.x + this.y * this.y)

    override fun toString(): String {
        val a = if (x == 0.0) "" else x.toString()
        val sign = if (this.y > 0.0) "+" else ""
        val b = if (y == 0.0) "" else this.y
        return "$a$sign${b}i"
    }
}