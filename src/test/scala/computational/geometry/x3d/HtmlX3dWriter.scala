package computational.geometry.x3d

import java.io.{File, FileWriter, BufferedWriter}
import java.text.{DecimalFormatSymbols, DecimalFormat}

import computational.geometry.primitives.{Segment, Point, Vector}
import org.slf4j.LoggerFactory

import computational.geometry.operators.RichDouble.DoubleEqualWithPrecisionError

import XhtmlX3dWriter.logger

import scala.math.atan2

/**
 * @author Nuno Oliveira
 */
class XhtmlX3dWriter(outputFilePath: String) {

  val outputFile = new File(System.getProperty("java.io.tmpdir") + "/" + outputFilePath)

  val writer = new BufferedWriter(new FileWriter(outputFile))

  val doubleFormatter = {
    val symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator('.')
    new DecimalFormat("#.########", symbols)
  }

  def start(viewPoint: String = "0 0 0") {
    logger.info(s"Start writing file: ${outputFile.getPath}.")
    writer.write("<!DOCTYPE html><html><head><title>X3DOM styling tutorial 4</title>")
    writer.write("<link rel=\"stylesheet\" href=\"http://www.x3dom.org/x3dom/example/x3dom.css\"/>")
    writer.write("<script src=\"http://www.x3dom.org/x3dom/example/x3dom.js\"></script>")
    writer.write("<style> html {width:100%;height:100%;margin:0;padding:0;} ")
    writer.write("body {margin:0;padding:0px;width:100%;height:95%;} #x3dNavigation {text-align: center;}")
    writer.write("#x3dElement {width: 100%; height: 95%; border: none; display: block; position:relative;}")
    writer.write("</style></head><body id=\"body\"> <p id=\"x3dNavigation\">")
    writer.write("<a href=\"#\" onClick=\"$x3dElement.runtime.showAll('posX');return false;\">[Positive X]</a>  ")
    writer.write("<a href=\"#\" onClick=\"$x3dElement.runtime.showAll('negX');return false;\">[Negative -X]</a>  ")
    writer.write("<a href=\"#\" onClick=\"$x3dElement.runtime.showAll('posY');return false;\">[Positive Y]</a>  ")
    writer.write("<a href=\"#\" onClick=\"$x3dElement.runtime.showAll('negY');return false;\">[Negative -Y]</a>  ")
    writer.write("<a href=\"#\" onClick=\"$x3dElement.runtime.showAll('posZ');return false;\">[Positive Z]</a>  ")
    writer.write("<a href=\"#\" onClick=\"$x3dElement.runtime.showAll('negZ');return false;\">[Negative -Z]</a>")
    writer.write("</p><x3d id=\"x3dElement\" showlog=\"false\" showstat=\"false\" width=\"100%\" height=\"100%\"><scene>")
  }

  def end() {
    writer.write("</scene></x3d></body><script>var $x3dElement = document.getElementById('x3dElement');")
    writer.write("</script></html>")
    writer.close()
    logger.info(s"End writing file: ${outputFile.getPath}.")
  }

  def addPoint(point: Point, color: String = "1 0 0", scale: Double = 1.0) = {
    val x3d =
      <Transform translation={s"${format(point.x)} ${format(point.y)} ${format(point.z)}"}>
        <Shape>
          <Appearance>
            <Material diffuseColor={color}/>
          </Appearance>
          <Sphere radius={format(0.1 * scale)}/>
        </Shape>
      </Transform>
    writer.write(scala.xml.Utility.trim(x3d).toString())
  }

  def addSegment(segment: Segment, color: String = "0 1 0", scale: Double = 1.0) = {
    val cylinderTranslationPoint = segment.pointAlong(0.50)
    val cylinderQuaternion = segment.vector.quaternion(Vector(0, 1, 0))
    val x3dCylinder =
      <Transform translation={s"${format(cylinderTranslationPoint.x)} ${format(cylinderTranslationPoint.y)} ${format(cylinderTranslationPoint.z)}"}>
        <Transform rotation={s"${cylinderQuaternion._1} ${cylinderQuaternion._2} ${cylinderQuaternion._3} ${cylinderQuaternion._4}"}>
          <Shape>
            <Appearance>
              <Material diffuseColor={color}/>
            </Appearance>
            <Cylinder radius={format(0.1 * scale)} height={format(segment.length)}/>
          </Shape>
        </Transform>
      </Transform>
    writer.write(scala.xml.Utility.trim(x3dCylinder).toString())
  }

  private def format(double: Double): String = {
    return doubleFormatter.format(double)
  }
}

object XhtmlX3dWriter {
  val logger = LoggerFactory.getLogger(this.getClass)
}






































