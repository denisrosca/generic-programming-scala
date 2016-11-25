## Generic encodings

Remember the encoders for rectangle and ellipse?

It would be nice if we could write the implementation only once and use it to encode both rectangles and ellipses.

It would be even better if we could write one implementation that would work for all ADTs that have a certain (generic) structure.
​
Note:
Turns out we can, but have to go through some theory first.

We need a way to convert our ADTs to a generic representation that can then be encoded into a JSON.