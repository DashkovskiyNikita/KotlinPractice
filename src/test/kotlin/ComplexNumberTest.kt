import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ComplexNumberTest {

    companion object {

        @JvmStatic
        fun plusOperatorTestDataSource() = listOf(
            Arguments.of(
                ComplexNumber(x = 52.0, y = 48.0),
                ComplexNumber(x = 17.0, y = 78.0),
                ComplexNumber(x = 69.0, y = 126.0),
            ),
            Arguments.of(
                ComplexNumber(x = 2.0, y = -3.0),
                ComplexNumber(x = -5.0, y = 4.0),
                ComplexNumber(x = -3.0, y = 1.0),
            )
        )

        @JvmStatic
        fun minusOperatorTestDataSource() = listOf(
            Arguments.of(
                ComplexNumber(x = 52.0, y = 48.0),
                ComplexNumber(x = 17.0, y = 78.0),
                ComplexNumber(x = 35.0, y = -30.0),
            ),
            Arguments.of(
                ComplexNumber(x = 2.0, y = -3.0),
                ComplexNumber(x = -5.0, y = 4.0),
                ComplexNumber(x = 7.0, y = -7.0),
            )
        )

        @JvmStatic
        fun timesOperatorTestDataSource() = listOf(
            Arguments.of(
                ComplexNumber(x = 7.0, y = 3.0),
                ComplexNumber(x = 5.0, y = -8.0),
                ComplexNumber(x = 59.0, y = -41.0),
            ),
            Arguments.of(
                ComplexNumber(x = -10.0, y = -4.0),
                ComplexNumber(x = 8.0, y = 1.0),
                ComplexNumber(x = -76.0, y = -42.0),
            )
        )

        @JvmStatic
        fun divOperatorTestDataSource() = listOf(
            Arguments.of(
                ComplexNumber(x = 23.0, y = 1.0),
                ComplexNumber(x = 2.0, y = 1.0),
                ComplexNumber(x = 9.4, y = -4.2),
            ),
            Arguments.of(
                ComplexNumber(x = 2.0, y = 7.0),
                ComplexNumber(x = 10.0, y = 0.0),
                ComplexNumber(x = 0.2, y = 0.7),
            )
        )

        @JvmStatic
        fun absOperatorTestDataSource() = listOf(
            Arguments.of(
                ComplexNumber(x = 3.0, y = -4.0),
                5.0
            ),
            Arguments.of(
                ComplexNumber(x = 0.0, y = 3.0),
                3.0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("plusOperatorTestDataSource")
    fun plus(a: ComplexNumber, b: ComplexNumber, result: ComplexNumber) {
        Assertions.assertEquals(result, a + b)
    }

    @ParameterizedTest
    @MethodSource("minusOperatorTestDataSource")
    fun minus(a: ComplexNumber, b: ComplexNumber, result: ComplexNumber) {
        Assertions.assertEquals(result, a - b)
    }

    @ParameterizedTest
    @MethodSource("timesOperatorTestDataSource")
    fun times(a: ComplexNumber, b: ComplexNumber, result: ComplexNumber) {
        Assertions.assertEquals(result, a * b)
    }

    @ParameterizedTest
    @MethodSource("divOperatorTestDataSource")
    fun div(a: ComplexNumber, b: ComplexNumber, result: ComplexNumber) {
        Assertions.assertEquals(result, a / b)
    }

    @ParameterizedTest
    @MethodSource("absOperatorTestDataSource")
    fun abs(a: ComplexNumber, result: Double) {
        Assertions.assertEquals(result, a.abs())
    }
}