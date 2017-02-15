package generic.shapes

sealed trait Shape

case class Circle(radius: Double) extends Shape

case class Rectangle(width: Double, height: Double) extends Shape

case class Ellipse(width: Double, height: Double) extends Shape