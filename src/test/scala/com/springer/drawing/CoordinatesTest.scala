package com.springer.drawing

import org.specs2.mutable.Specification
import Coordinate.tupleToCoordinate

class CoordinatesTest extends Specification {

  "Coordinates all on the same x plan" >> {
    Coordinates((1, 1), (1, 2), (1, 4)).onSingleAxis must_== true
  }

  "Coordinates all on the same y plan" >> {
    Coordinates((1, 1), (2, 1), (4, 1)).onSingleAxis must_== true
  }

  "Coordinates that cross axis (a diagonal)" >> {
    Coordinates((1, 1), (2, 2), (3, 3)).onSingleAxis must_== false
  }

  "Coordinates that cross axis (a square)" >> {
    Coordinates((1, 1), (1, 2), (2, 1), (2, 2)).onSingleAxis must_== false
  }

  "Single coordinate" >> {
    Coordinates((1, 1)).onSingleAxis must_== true
  }

}