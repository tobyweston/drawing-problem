# Springer Coding Exercise

## Coordinate System

The coordinate system starts at 1 for `x` and `y` axis. Ordinating the top left corner. So `Coordinate(1, 1)` is the first drawable position (it correlates to the Java convention of `(0, 0)`).

## Use of Exceptions

I'm in two minds about using exceptions. I started by preventing an invalid coordinate being created by throwing an exception but switched to just ignoring out of range coordinates when applied to the canvas. I decided that coordinates are coordinates, so even (-34, -23) are "valid", it's only the context of applying them to the canvas that gives us enough to reason if they are really valid.

## Shape Types & Immutability

I used sub-types of `Shape` to represent lines and rectangles that can draw themselves. THe rectangle implementation was fairly quick as it builds the rectangle in terms of four lines which are applied to the canvas in turn. It got me thinking about what would happen if any one of the four failed for some reason.

This lack of atomicity made me think about using a more immutable style canvas where potential updates (like applying a shape to a canvas) result in `Either` an update or nothing. You could then replace the entire (old) canvas with a newly updated one on success.