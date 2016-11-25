## ADTs in Scala?

In ADT terminology, types such as *Rectangle* are called **products** while types such as *Shape* are called **coproducts**.

In Scala we typically represent products using case classes and coproducts using sealed traits:

    sealed trait Shape
    
    case class Circle(radius: Double) extends Shape
    
    case class Rectangle(width: Double, height: Double) extends Shape
    
    case class Ellipse(width: Double, height: Double) extends Shape