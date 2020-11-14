package domain

import mother.MeasurementMother
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


internal class ModalCalculatorTest {

    private lateinit var calculator: ModalCalculator
    private lateinit var measurements: List<Measurement>
    private lateinit var result: Measurement

    @Before
    fun setUp() {
        calculator = ModalCalculator()
        measurements = MeasurementMother.MEASUREMENTS
        result = calculator.aggregate(measurements)
    }

    @Test
    fun when_finding_the_mode_on_4_measurements_then_the_high_mode_is_correct() {
        val groupedBy = measurements.groupBy { it.highValue }
        val expectedResult = getMode(groupedBy)
        assertEquals(expectedResult, result.highValue)
    }

    @Test
    fun when_finding_the_mode_on_4_measurements_then_the_low_mode_is_correct() {
        val groupedBy = measurements.groupBy { it.lowValue }
        val expectedResult = getMode(groupedBy)
        assertEquals(expectedResult, result.lowValue)
    }

    private fun getMode(groupedBy: Map<Double, List<Measurement>>): Double {
        val sizeMax = groupedBy.maxByOrNull { it.value.size }
        return sizeMax?.key ?: 0.0
    }
}
