## What is generic derivation?

A solution based on generic derivation should let us write this:

    JsonEncoder[Rectangle].encode(Rectangle(4.65, 3.45))

to get this:

    JsObject(
        Map(
            JsString("type") -> JsString("Rectangle"),
            JsString("width") -> JsNumber(4.65), 
            JsString("height") -> JsNumber(3.45)
        )
    )
    