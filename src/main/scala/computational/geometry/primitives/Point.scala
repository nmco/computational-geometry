package computational.geometry.primitives

import computational.geometry.operators.RichDouble.DoubleEqualWithPrecisionError

/**
 * @author Nuno Oliveira
 */
case class Point(x: Double, y: Double, z: Double) {

  override def equals(that: Any) = {
    that match {
      case point: Point => point.x =~ x && point.y =~ y && point.z =~ z
      case _ => false
    }
  }
}

object Point {

  def apply(x: Double, y: Double) = new Point(x, y, 0.0)
}