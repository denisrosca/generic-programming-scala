## Generic Json Encoder

    implicit def productEncoder[Key <: Symbol, Value, Tail <: HList](
        implicit
        key: Witness.Aux[Key],
        valueEncoder: JsonEncoder[Value],
        tailEncoder: JsonObjectEncoder[Tail]
    ): JsonEncoder[FieldType[Key, Value] :: Tail] = 
        
        new JsonEncoder[FieldType[Key, Value] :: Tail] {
            
            override def encode(value: FieldType[Key, Value] :: Tail) = {
                JsObject(
                    JsString(key.value.name) -> valueEncoder.encode(value.head)
                ) ++ tailEncoder.encode(value.tail)
            }
        }