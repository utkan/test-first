package domain

interface IGrouper {
    fun group(measurements: List<Measurement>): Iterable<Iterable<Measurement>>
}