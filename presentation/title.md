## Generic Programming in Scala

### Type Class Derivation

Note: 
Type class derivation is an advanced programming technique that facilitates
safe processing of Scala's case classes and sealed traits in generic 
ways while decreasing code duplication and boilerplate.

Traditionally, generic programs tasked with handling of arbitrary ADTs (e.g. 
serialization libraries) have made heavy use of runtime reflection APIs while 
sacrificing safety. Typically those libraries provide default instances for 
"standard" types and various ways of combining them. Library users must write 
instances for their own data types in terms of those. This is usually a time 
consuming and laborious process, but it is nevertheless completely 
mechanical, based entirely on the structure of the types involved. 

So wouldn't it be nice if we could persuade the Scala compiler to use the 
structure of those types and do the work for us? Building on [shapeless's](https://github.com/milessabin/shapeless/)
core generic programming primitives and support for automatic type class 
derivation we can! 

In this talk we'll see how taking advantage of automatic derivation 
reduces boilerplate & mechanical code. Along the way we'll discover the 
surprisingly simple underlying mechanism that allows us to do that.