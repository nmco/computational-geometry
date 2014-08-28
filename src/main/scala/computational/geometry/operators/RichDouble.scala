package computational.geometry.operators

/**
 * @author Nuno Oliveira
 */
object RichDouble {

  implicit class DoubleEqualWithPrecisionError(val doubleA: Double) extends AnyVal {
    def =~(doubleB: Double, precisionError: Double = 1e-8) = (doubleA - doubleB).abs < precisionError
  }
}
