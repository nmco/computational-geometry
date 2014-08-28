package computational.geometry.primitives

import computational.geometry.operators.RichDouble.DoubleEqualWithPrecisionError

import scala.math.sqrt
import scala.math.pow

/**
 * @author Nuno Oliveira
 */
case class Segment(pointA: Point, pointB: Point) {

  lazy val vector = new Vector(pointB.x - pointA.x, pointB.y - pointA.y, pointB.z - pointA.z)

  lazy val length = vector.length

  def isOnLeft(point: Point): Boolean = {
    val dotProduct = vector.dotProduct(Vector(pointA, point))
    return dotProduct > 0.0 && !(dotProduct =~ 0.0)
  }

  def isCollinear(point: Point): Boolean = {
    return vector.dotProduct(Vector(pointA, point)) =~ 0.0
  }

  def isOnRight(point: Point): Boolean = {
    val dotProduct = vector.dotProduct(Vector(pointA, point))
    return dotProduct < 0.0 && !(dotProduct =~ 0.0)
  }

  def pointAlong(position: Double): Point = {
    val positionX = pointA.x + (pointB.x - pointA.x) * position
    val positionY = pointA.y + (pointB.y - pointA.y) * position
    val positionZ = pointA.z + (pointB.z - pointA.z) * position
    return Point(positionX, positionY, positionZ)
  }

  override def equals(that: Any) = {
    that match {
      case segment: Segment => segment.pointA == pointA && segment.pointB == pointB
      case _ => false
    }
  }
}

object Segment {

  def apply(pointAX: Double, pointAY: Double, pointBX: Double, pointBY: Double) = {
    new Segment(Point(pointAX, pointAY), Point(pointBX, pointBY))
  }

  def apply(pointAX: Double, pointAY: Double, pointAZ: Double, pointBX: Double, pointBY: Double, pointBZ: Double) = {
    new Segment(Point(pointAX, pointAY, pointAZ), Point(pointBX, pointBY, pointBZ))
  }
}