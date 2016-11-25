## Json Encoder

The encoder interface would look similar to this:

    trait JsonEncoder[A] {
    
      type Result <: JsValue
    
      def encode(value: A): Result
    
    }