## Other use cases

Generate arbitrary instances using scalacheck-shapeless

    case class Foo(i: Int)
    case class Bar(i: Int, d: Double)
    
    import import org.scalacheck.Shapeless._
    
    val arbitraryFoo = implicitly[Arbitrary[Foo]]
    val arbitraryBar = implicitly[Arbitrary[Bar]]
