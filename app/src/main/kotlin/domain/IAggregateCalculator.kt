package domain

interface IAggregateCalculator {
    fun aggregate(measurements: Iterable<Measurement>): Measurement
}
