package computational.geometry.primitives

import java.lang.Math.{acos, pow, sqrt}

import computational.geometry.operators.RichDouble.DoubleEqualWithPrecisionError

/**
 * @author Nuno Oliveira
 */
case class Vector(x: Double, y: Double, z: Double) {

  lazy val length = sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2))

  lazy val normalizedX = x / length

  lazy val normalizedY = y / length

  lazy val normalizedZ = z / length

  def dotProduct(vector: Vector): Double = {
    return normalizedX * vector.normalizedX + normalizedY * vector.normalizedY + normalizedZ * vector.normalizedZ
  }

  def crossProduct(vector: Vector): Vector = {
    return Vector(normalizedY * vector.normalizedZ - normalizedZ * vector.normalizedY,
      normalizedZ * vector.normalizedX - normalizedX * vector.normalizedZ,
      normalizedX * vector.normalizedY - normalizedY * vector.normalizedX)
  }

  def angleBetween(vector: Vector): Double = {
    return acos(dotProduct(vector))
  }

  def quaternion(vector: Vector): (Double, Double, Double, Double) = {
    val angle = angleBetween(vector)
    if (angle =~ 0 || angle =~ Math.PI) return (0.0, 0.0, 1.0, angle)
    val axis = crossProduct(vector)
    return (axis.normalizedX, axis.normalizedY, axis.normalizedZ, angle)
  }
}

object Vector {

  def apply(pointA: Point, pointB: Point): Vector = {
    new Vector(pointB.x - pointA.x, pointB.y - pointA.y, pointB.z - pointA.z)
  }
}
