package computational.geometry.x3d

import computational.geometry.primitives.{Point, Segment}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.Stack

/**
 * @author Nuno Oliveira
 */
class HtmlX3dWriterTest extends FlatSpec with Matchers {

  "The HtmlX3dWriter" should "create or replace the file CartesianPlane.html in user temporary directory that contains a scene representing the cartesian plane" in {
    val xhtmlX3dWriter = new XhtmlX3dWriter("CartesianPlane.html")
    xhtmlX3dWriter.start()
    xhtmlX3dWriter.addSegment(Segment(-5.0, 0.0, 5.0, 0.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(0.0, -5.0, 0.0, 5.0), color = "0 0 1")
    xhtmlX3dWriter.addSegment(Segment(0.0, 0.0, -5.0, 0.0, 0.0, 5.0), color = "0 1 1")
    xhtmlX3dWriter.addPoint(Point(0.0, 0.0), scale = 3.0, color = "0 1 0")
    xhtmlX3dWriter.end()
  }

  it should "create or replace the file Box.html in user temporary directory that contains a scene representing a box with all the vertex and diagonals" in {
    val xhtmlX3dWriter = new XhtmlX3dWriter("Box.html")
    xhtmlX3dWriter.start()
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, 5.0, 5.0, -5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, -5.0, 5.0, 5.0, 5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, 5.0, 5.0, -5.0, 5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, 5.0, -5.0, -5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, 5.0, 5.0, 5.0, 5.0, -5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, 5.0, -5.0, 5.0, -5.0, -5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, -5.0, -5.0, 5.0, -5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, -5.0, -5.0, -5.0, -5.0, -5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, -5.0, -5.0, 5.0, -5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, -5.0, 5.0, 5.0, -5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, -5.0, -5.0, 5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, -5.0, -5.0, -5.0, 5.0), color = "1 0 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, 5.0, 5.0, 5.0, -5.0), color = "0 0 1")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, -5.0, 5.0, -5.0, 5.0), color = "0 0 1")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, -5.0, 5.0, 5.0, 5.0), color = "0 0 1")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, 5.0, 5.0, -5.0, -5.0), color = "0 0 1")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, 5.0, 5.0, 5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, 5.0, 5.0, -5.0, 5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, 5.0, 5.0, -5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, -5.0, 5.0, -5.0, -5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, 5.0, 5.0, -5.0, 5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, 5.0, 5.0, 5.0, 5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, -5.0, 5.0, -5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, -5.0, 5.0, 5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, 5.0, 5.0, -5.0, -5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(-5.0, -5.0, 5.0, -5.0, 5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, 5.0, 5.0, 5.0, -5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addSegment(Segment(5.0, -5.0, 5.0, 5.0, 5.0, -5.0), color = "0 1 0")
    xhtmlX3dWriter.addPoint(Point(0.0, 0.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(-5.0, 5.0, 5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(-5.0, -5.0, 5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(5.0, -5.0, 5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(5.0, 5.0, 5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(5.0, 5.0, -5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(5.0, -5.0, -5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(-5.0, -5.0, -5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.addPoint(Point(-5.0, 5.0, -5.0), scale = 4.0, color = "1 1 1")
    xhtmlX3dWriter.end()
  }
}
