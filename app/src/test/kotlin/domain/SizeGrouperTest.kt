package domain

import mother.MeasurementMother
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SizeGrouperTest {

    private lateinit var groupedMeasurements: Iterable<Iterable<Measurement>>
    private lateinit var sizeGrouper: SizeGrouper
    private val groupSize: Int = 2
    private lateinit var measurements: List<Measurement>

    @Before
    fun setUp() {
        measurements = MeasurementMother.MEASUREMENTS
        sizeGrouper = SizeGrouper(groupSize)
        groupedMeasurements = sizeGrouper.group(measurements)
    }

    @Test
    fun `grouping list of one by one produces group of size one`() {
        val measurements = createMeasurementListOfSize(1)

        val grouper = SizeGrouper(1)
        val groupedResults = grouper.group(measurements)

        assertEquals(1, groupedResults.count())
    }

    @Test
    fun `grouping list of two by one produces group of size two`() {
        val measurements = createMeasurementListOfSize(2)

        val grouper = SizeGrouper(1)
        val groupedResults = grouper.group(measurements)

        assertEquals(2, groupedResults.count())
    }

    @Test
    fun `grouping list of four by two produces group of size two`() {
        val measurements = createMeasurementListOfSize(4)

        val grouper = SizeGrouper(2)
        val groupedResults = grouper.group(measurements)

        assertEquals(2, groupedResults.count())
        groupedResults.forEach {
            assertTrue(it.count() == 2)
        }
    }

    @Test
    fun when_grouping_then_all_groups_are_the_correct_size() {
        groupedMeasurements.forEach { measurementGroup ->
            assertEquals(groupSize, measurementGroup.count())
        }
    }

    private fun createMeasurementListOfSize(size: Int): List<Measurement> {
        val results = mutableListOf<Measurement>()
        (0 until size).forEach { _ ->
            results.add(Measurement(highValue = 10.0, lowValue = 1.0))
        }
        return results
    }
}