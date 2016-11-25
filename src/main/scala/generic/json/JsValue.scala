package generic.json

sealed trait JsValue

case class JsString(value: String) extends JsValue

case class JsBoolean(value: Boolean) extends JsValue

case class JsNumber(value: Double) extends JsValue {
  def this(value: Int) = this(value.toDouble)
}

case class JsObject(fields: Map[JsString, JsValue]) extends JsValue {
  def ++(other: JsObject): JsObject = JsObject(fields ++ other.fields)
}

object JsObject {
  def apply(mappings: (JsString, JsValue)*): JsObject = new JsObject(Map(mappings:_*))
}