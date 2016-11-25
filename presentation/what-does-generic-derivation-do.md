## What is generic derivation?

What we want is, when the compiler encounters this:

    JsonEncoder[Rectangle].encode(Rectangle(4.65, 3.45))

it should:
- identify the type to be encoded (in this case `Rectangle`)
- inspect its structure and convert it to a (co)product
- recursively find `JsonEncoder` instances for the members
- create a `JsonEncoder` instance for the original type

Note:
To make this useful, for step 3 we need to provide default instances for standard types.