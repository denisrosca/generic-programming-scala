package generic.json.derivative

import generic.json.{JsObject, JsString, JsValue, JsonEncoder}
import generic.json.JsonEncoder.JsonObjectEncoder
import generic.json.primitive.PrimitiveEncoders
import shapeless._
import shapeless.labelled.FieldType

object DerivativeEncoders extends PrimitiveEncoders with LowerLevelImplicits

trait LowerLevelImplicits {
  implicit def genericDerivedEncoder[A, Repr](
     implicit
     generic: LabelledGeneric.Aux[A, Repr],
     encoder: Lazy[JsonObjectEncoder[Repr]],
     typeToEncode: Typeable[A]
   ): JsonObjectEncoder[A] = new JsonEncoder[A] {
    override type Result = JsObject
    override def encode(value: A): Result =
      JsObject(
        JsString("type") -> JsString(typeToEncode.describe)
      ) ++ encoder.value.encode(generic.to(value))
  }

  implicit def labeledProductEncoder[Key <: Symbol, Value, Tail <: HList](
     implicit
     key: Witness.Aux[Key],
     valueEncoder: JsonEncoder[Value],
     tailEncoder: JsonObjectEncoder[Tail]
   ): JsonObjectEncoder[FieldType[Key, Value] :: Tail] = new JsonEncoder[FieldType[Key, Value] :: Tail] {
    override type Result = JsObject
    override def encode(value: FieldType[Key, Value] :: Tail): JsObject = {
      JsObject(
        JsString(key.value.name) -> valueEncoder.encode(value.head)
      ) ++ tailEncoder.encode(value.tail)
    }
  }

  implicit def hnilEncoder: JsonObjectEncoder[HNil] = new JsonEncoder[HNil] {
    override type Result = JsObject
    override def encode(value: HNil): JsObject = JsObject(Map.empty[JsString, JsValue])
  }

  implicit def coproductEncoder[Key<:Symbol, H, T<:Coproduct](
     implicit
     key: Witness.Aux[Key],
     headEncoder: Lazy[JsonObjectEncoder[H]],
     tailEncoder: Lazy[JsonObjectEncoder[T]]
   ): JsonObjectEncoder[FieldType[Key, H] :+: T] = new JsonEncoder[FieldType[Key, H] :+: T] {
    override type Result = JsObject
    override def encode(value: FieldType[Key, H] :+: T): JsObject = value match {
      case Inl(xh) => headEncoder.value.encode(xh)
      case Inr(xt) => tailEncoder.value.encode(xt)
    }
  }

  implicit def cnilEncoder: JsonObjectEncoder[CNil] = new JsonEncoder[CNil] {
    override type Result = JsObject
    override def encode(value: CNil): JsObject = throw new UnsupportedOperationException("This is not the encoder you're looking for")
  }
}