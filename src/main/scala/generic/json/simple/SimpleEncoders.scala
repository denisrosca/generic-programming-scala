package generic.json.simple

import generic.json.{JsNumber, JsObject, JsString, JsonEncoder}
import generic.shapes.{Circle, Ellipse, Rectangle}

object SimpleEncoders {

  val rectangleEncoder = new JsonEncoder[Rectangle] {
    override type Result = JsObject

    override def encode(value: Rectangle): JsObject = JsObject(Map(
      JsString("type") -> JsString("Rectangle"),
      JsString("width") -> JsNumber(value.width),
      JsString("height") -> JsNumber(value.height)
    ))
  }

  val ellipseEncoder = new JsonEncoder[Ellipse] {
    override type Result = JsObject

    override def encode(value: Ellipse): JsObject = JsObject(Map(
      JsString("type") -> JsString("Ellipse"),
      JsString("width") -> JsNumber(value.width),
      JsString("height") -> JsNumber(value.height)
    ))
  }

  val circleEncoder = new JsonEncoder[Circle] {
    override type Result = JsObject

    override def encode(value: Circle): JsObject = JsObject(Map(
      JsString("type") -> JsString("Circle"),
      JsString("radius") -> JsNumber(value.radius)
    ))
  }

}