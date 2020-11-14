package domain

class AveragingCalculator : IAggregateCalculator {

    override fun aggregate(measurements: Iterable<Measurement>): Measurement {
        val highAvg = measurements.map { it.highValue }.average()
        val lowAvg = measurements.map { it.lowValue }.average()
        return Measurement(
            highValue = highAvg,
            lowValue = lowAvg
        )
    }
}