package mother

import domain.Measurement

object MeasurementMother {
    val MEASUREMENTS = listOf(
        Measurement(highValue = 10.0, lowValue = 1.0),
        Measurement(highValue = 5.0, lowValue = 2.0),
        Measurement(highValue = 2.0, lowValue = 1.0),
        Measurement(highValue = 10.0, lowValue = 4.0)
    )
}