# Springer Coding Exercise

## Coordinate System

The coordinate system starts at 1 for `x` and `y` axis. Ordinating the top left corner. So `Coordinate(1, 1)` is the first drawable position (it correlates to the Java convention of `(0, 0)`).

## Use of Exceptions

I'm in two minds about using exceptions. I prevent an invalid coordinate being created by throwing an exception but am thinking I'll ignore out of range coordinates when applied to the canvas.