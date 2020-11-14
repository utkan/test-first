package domain


data class MeasurementAggregator constructor(
    private val measurements: List<Measurement>
) {

    fun aggregate(
        grouper: IGrouper,
        calculator: IAggregateCalculator
    ): Iterable<Measurement> {
        return grouper.group(measurements).map { calculator.aggregate(it) }
//        val partitions = grouper.group(measurements)
//        val aggregateList = mutableListOf<Measurement>()
//        partitions.forEach {
//            val aggregated = calculator.aggregate(it)
//            aggregateList.add(aggregated)
//        }
//        return aggregateList
    }
}