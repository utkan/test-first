package domain

data class SizeGrouper(
    private val groupSize: Int
) : IGrouper {
    override fun group(measurements: List<Measurement>): Iterable<Iterable<Measurement>> {

        val result = mutableListOf<List<Measurement>>()
        var total = 0
        while (total < measurements.size) {
            val group = measurements.subList(total, groupSize + total)
            result.add(group)
            total += groupSize
        }
        return result
    }
}
