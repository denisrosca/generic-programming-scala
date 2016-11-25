## What is an ADT?

An algebraic data type (ADT) is a kind of composite type formed by combining
other types. Two common classes of ADTs are:
- **product types** (e.g. tuples, records)
    * a rectangle has a width **and** a height
    
- **coproduct types** (alternatively called sum types or variant types)
    * a shape is a rectangle **or** a circle


Note:

They are an idiomatic way of representing data using "or" & "and", for example:

The values of a product type typically contain several values, called fields. All 
values of that type have the same combination of field types.

The values of a sum type are typically grouped into several classes (sometimes called variants).
