package generic.show

import generic.json._
import generic.show.Show.PrintParams
import shapeless.ops.coproduct.IsCCons
import shapeless.{:+:, CNil, Coproduct, Generic, Inl, Inr, Lazy}

trait Show[T] {
  def show(t: T)(implicit printParams: PrintParams): String
}

object Show extends ShowInstances {

  case class PrintParams(indent: String)

  implicit def showOps[A:Show](a: A): ShowOps[A] = new ShowOps(a)

  class ShowOps[A](a: A)(implicit showInstance: Show[A]) {
    def twoSpaces: String = {
      showInstance.show(a)(PrintParams("  "))
    }
  }

  implicit def genericShow[A, Repr](
    implicit
    generic: Generic.Aux[A, Repr],
    showInstance: Lazy[Show[Repr]]
  ): Show[A] = new Show[A] {
    override def show(t: A)(implicit printParams: PrintParams) = showInstance.value.show(generic.to(t))
  }

  implicit def genericCoproductShow[CP <: Coproduct, H, T <: Coproduct](
     implicit
     isCCons: IsCCons.Aux[CP, H, T],
     headShow: Show[H],
     tailShow: Lazy[Show[T]]
   ): Show[H :+: T] = new Show[H :+: T] {
    override def show(t: H :+: T)(implicit printParams: PrintParams) = t match {
      case Inl(xh) => headShow.show(xh)
      case Inr(xt) => tailShow.value.show(xt)
    }
  }

  implicit val emptyCoproduct: Show[CNil] = new Show[CNil] {
    override def show(i: CNil)(implicit printParams: PrintParams): String = throw new UnsupportedOperationException("This is here only to please the compiler")
  }

}

trait ShowInstances {

  implicit val jsStringShowInstance: Show[JsString] = new Show[JsString] {
    override def show(t: JsString)(implicit printParams: PrintParams) = "\"" + t.value + "\""
  }

  implicit val jsNumberShowInstance: Show[JsNumber] = new Show[JsNumber] {
    override def show(t: JsNumber)(implicit printParams: PrintParams) = t.value.toString
  }

  implicit val jsBooleanShowInstance: Show[JsBoolean] = new Show[JsBoolean] {
    override def show(t: JsBoolean)(implicit printParams: PrintParams) = t.value.toString
  }

  implicit def jsObjectShowInstance(implicit showInstance: Show[JsValue]): Show[JsObject] = new Show[JsObject] {
    override def show(t: JsObject)(implicit printParams: PrintParams) = {
      s"${printParams.indent}{\r\n" +
        mkString(t) +
      s"\r\n${printParams.indent}}"
    }

    private def mkString(t: JsObject)(implicit printParams: PrintParams) = {
      val indent = printParams.indent
      t.fields.map { case (f, v) => indent + indent + f.value + ": " + showInstance.show(v)(PrintParams(indent + indent)) }.mkString(",\r\n")
    }
  }

}