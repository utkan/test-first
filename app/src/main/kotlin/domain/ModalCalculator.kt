package domain

class ModalCalculator : IAggregateCalculator {

    override fun aggregate(measurements: Iterable<Measurement>): Measurement {
        val groupedHighValue = measurements.groupBy { it.highValue }
        val maxedHighValue = groupedHighValue.maxByOrNull { it.value.size }
        val highValue = maxedHighValue?.value?.first()?.highValue ?: 0.0

        val groupedLowValue = measurements.groupBy { it.lowValue }
        val maxedLowValue = groupedLowValue.maxByOrNull { it.value.size }
        val lowValue = maxedLowValue?.value?.first()?.lowValue ?: 0.0
        return Measurement(highValue = highValue, lowValue = lowValue)
    }
}
