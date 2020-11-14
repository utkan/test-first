package domain

import mother.MeasurementMother
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


internal class MeasurementAggregatorTest {

    private lateinit var aggregator: MeasurementAggregator

    @Before
    fun setUp() {
        aggregator = MeasurementAggregator(MeasurementMother.MEASUREMENTS)
    }

    @Test
    fun `grouping by 4 should produce single result`() {
        val aggregated = aggregator.aggregate(SizeGrouper(4), AveragingCalculator())
        assertEquals(1, aggregated.count())
    }

    @Test
    fun grouping_by_2_should_produce_two_results() {
        val result = aggregator.aggregate(SizeGrouper(2), AveragingCalculator())
        assertEquals(2, result.count());
    }

    @Test
    fun averaging_should_calculate_average_high_andlow_values() {
        val result = aggregator.aggregate(SizeGrouper(2), AveragingCalculator())

        val first = result.first()
        assertEquals(7.5, first.highValue, "0.005")
        assertEquals(1.5, first.lowValue, "0.005")

        val second = result.elementAt(1)
        assertEquals(6.0, second.highValue, "0.005")
        assertEquals(2.5, second.lowValue, "0.005")
    }

    @Test
    fun mode_should_calculate_average_high_and_low_values() {
        val result = aggregator.aggregate(SizeGrouper(4), ModalCalculator())
        val first = result.elementAt(0)

        assertEquals(10.0, first.highValue, "0.005")
        assertEquals(1.0, first.lowValue, "0.005")
    }
}

