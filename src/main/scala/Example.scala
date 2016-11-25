import generic.json._
import generic.json.derivative.DerivativeEncoders._
import generic.shapes._
import generic.show.Show
import generic.show.Show._

object Example {

  case class ComplexShape(rectangle: Rectangle, circle: Circle)

  def main(args: Array[String]): Unit = {
    val circle = Circle(5.43)
    val rectangle = Rectangle(4.65, 3.45)
    val ellipse = Ellipse(5.3, 10.4)
    val shape: Shape = rectangle

    show(JsonEncoder[Circle].encode(circle))
    show(JsonEncoder[Rectangle].encode(rectangle))
    show(JsonEncoder[Ellipse].encode(ellipse))
    show(JsonEncoder[Shape].encode(shape))
    show(JsonEncoder[Shape].encode(rectangle))

    show(JsonEncoder[ComplexShape].encode(ComplexShape(rectangle, circle)))
  }

  def show(value: JsValue): Unit = {
    println(value.twoSpaces)
  }
}
