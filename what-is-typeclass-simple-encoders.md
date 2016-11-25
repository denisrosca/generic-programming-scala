## Json Encoder

Now let's write two implementations, one for Rectangle:

    val rectangleEncoder = new JsonEncoder[Rectangle] {
    
        override def encode(value: Rectangle): JsObject = JsObject(Map(
          JsString("type") -> JsString("Rectangle"),
          JsString("width") -> JsNumber(value.width),
          JsString("height") -> JsNumber(value.height)
        ))
    }

and the second for Ellipse:

    val ellipseEncoder = new JsonEncoder[Ellipse] {
    
        override def encode(value: Ellipse): JsObject = JsObject(Map(
          JsString("type") -> JsString("Ellipse"),
          JsString("width") -> JsNumber(value.width),
          JsString("height") -> JsNumber(value.height)
        ))
    }
    
Note:
Looking at the code it turns out the implementations are almost identical.

It is 100% mechanical code.

It uses encoders for primitives e.g. JsString, JsNumber etc.