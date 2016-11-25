## Encoder implementations for primitives

To get started with generic derivation we need to define our "standard" encoders.

    implicit val booleanEncoder: JsonEncoder[Boolean] = new JsonEncoder[Boolean] {
        override type Result = JsBoolean
        override def encode(value: Boolean): Result = JsBoolean(value)
    }
    
    implicit val stringEncoder: JsonEncoder[String] = new JsonEncoder[String] {
        override type Result = JsString
        override def encode(value: String): Result = JsString(value)
    }
    
    implicit val intEncoder: JsonEncoder[Int] = new JsonEncoder[Int] {
        override type Result = JsNumber
        override def encode(value: Int): JsNumber = JsNumber(value)
    }