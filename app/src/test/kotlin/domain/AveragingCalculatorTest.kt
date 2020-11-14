package domain

import mother.MeasurementMother
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


internal class AveragingCalculatorTest {

    private var highAvg: Double = 0.0
    private var lowAvg: Double = 0.0
    private lateinit var result: Measurement
    private lateinit var measurements: List<Measurement>
    private lateinit var averagingCalculator: AveragingCalculator

    @Before
    fun setUp() {
        highAvg = 0.0
        lowAvg = 0.0
        averagingCalculator = AveragingCalculator()
        measurements = MeasurementMother.MEASUREMENTS
        result = averagingCalculator.aggregate(measurements)
    }

    @Test
    fun when_averaging_4_numbers_then_the_high_average_is_correct() {
        val expectedAverage: Double = averageHigh(measurements)
        assertEquals(expectedAverage, result.highValue)
    }

    @Test
    fun when_averaging_4_numbers_then_the_low_average_is_correct() {
        val expectedAverage: Double = averageLow(measurements)
        assertEquals(expectedAverage, result.lowValue)
    }

    @Test
    fun when_averaging_several_numbers_then_low_average_is_correct() {
        severalNumbers()
        assertEquals(lowAvg, result.lowValue);
    }

    @Test
    fun when_averaging_several_numbers_hen_high_average_is_correct() {
        severalNumbers()
        assertEquals(highAvg, result.highValue);
    }

    private fun averageHigh(measurements: List<Measurement>): Double {
        return average(measurements)
    }

    private fun averageLow(measurements: List<Measurement>): Double {
        return average(measurements, false)
    }

    private fun average(measurements: List<Measurement>, high: Boolean = true): Double {
        return sumValue(measurements, high) / measurements.size
    }

    private fun sumValue(measurements: List<Measurement>, high: Boolean = true): Double {
        return measurements.sumByDouble { if (high) it.highValue else it.lowValue }
    }

    private fun severalNumbers() {
        measurements = listOf(
            Measurement(highValue = 42.0, lowValue = 36.0),
            Measurement(highValue = 10.0, 20.0),
        )
        highAvg = averageHigh(measurements)
        lowAvg = averageLow(measurements)
        result = averagingCalculator.aggregate(measurements)
    }
}