## What is a type class

Type classes in Scala are represented by a trait with at least one type 
parameter and one or more abstract methods.

    trait JsonEncoder[A] {
    
      type Result <: JsValue
    
      def encode(value: A): Result
    
    }

We provide instances for this type classes by associating a definition with a concrete data type.

Note:
A `java.util.Comparator` can be thought of as a type class.

Type classes allow extending our data types without touching them.