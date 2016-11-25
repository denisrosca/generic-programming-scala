## Generic encodings

Imagine being able to define our types like this:

    type Rectangle = (String, Double) :: (String, Double) :: HNil​  // HList

    type Circle = (String, Double) :: HNil​  // HList

    type Ellipse = (String, Double) :: (String, Double) :: HNil​  // HList

    type Shape = Rectangle :+: Circle :+: Ellipse :+: CNil
    
where 

    :: = and = product = HList
    :+: = or = coproduct = Coproduct


The important part to note is that by using this notation *Rectangle* and *Ellipse* became equivalent.
This means we should be able to write only one encoder implementation.