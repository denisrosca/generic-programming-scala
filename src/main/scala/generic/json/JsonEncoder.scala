package generic.json

trait JsonEncoder[A] {

  type Result <: JsValue

  def encode(value: A): Result

}

object JsonEncoder {
  def apply[T](implicit jsonEncoder: JsonEncoder[T]): JsonEncoder[T] = jsonEncoder

  type JsonObjectEncoder[T1] = JsonEncoder[T1] {type Result = JsObject}

}