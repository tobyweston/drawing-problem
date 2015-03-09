package com.springer.drawing

import org.specs2.mutable.Specification

class CoordinateTest extends Specification {

  "coordinate above" >> {
    Coordinate(0, 0).above === ((0, -1))
    Coordinate(1, 1).above === ((1, 0))
  }

  "coordinate to the right" >> {
    Coordinate(0, 0).rightOf === ((1, 0))
    Coordinate(1, 1).rightOf === ((2, 1))
  }

  "coordinate below" >> {
    Coordinate(0, 0).below === ((0, 1))
    Coordinate(1, 1).below === ((1, 2))
  }

  "coordinate left" >> {
    Coordinate(0, 0).leftOf === ((-1, 0))
    Coordinate(1, 1).leftOf === ((0, 1))
  }

  "less than" >> {
    Coordinate(0, 1) < Coordinate(1, 1) must_== true
    Coordinate(1, 0) < Coordinate(1, 1) must_== true
    Coordinate(0, 0) < Coordinate(1, 1) must_== true
    Coordinate(1, 1) < Coordinate(0, 1) must_== false
    Coordinate(1, 1) < Coordinate(1, 0) must_== false
    Coordinate(1, 1) < Coordinate(1, 1) must_== false
  }

  "greater than" >> {
    Coordinate(0, 1) > Coordinate(1, 1) must_== false
    Coordinate(1, 0) > Coordinate(1, 1) must_== false
    Coordinate(0, 0) > Coordinate(1, 1) must_== false
    Coordinate(1, 1) > Coordinate(0, 1) must_== true
    Coordinate(1, 1) > Coordinate(1, 0) must_== true
  }

  "coordinate is outside a bounded box" >> {
    "for x and y less than the rectangle boundary" >> {
      Coordinate(-1, 0).outSide(RectangleBounds((0, 0), (2, 2))) must_== true
      Coordinate(0, -1).outSide(RectangleBounds((0, 0), (2, 2))) must_== true
    }
    "for x and y greater than the rectangle boundary" >> {
      Coordinate(3, 1).outSide(RectangleBounds((0, 0), (2, 2))) must_== true
      Coordinate(1, 3).outSide(RectangleBounds((0, 0), (2, 2))) must_== true
    }
    "where x and y are exactly on the boundary" >> {
      Coordinate(0, 1).outSide(RectangleBounds((0, 0), (2, 2))) must_== false
      Coordinate(1, 0).outSide(RectangleBounds((0, 0), (2, 2))) must_== false
      Coordinate(0, 2).outSide(RectangleBounds((0, 0), (2, 2))) must_== false
      Coordinate(2, 0).outSide(RectangleBounds((0, 0), (2, 2))) must_== false
    }
  }

}
