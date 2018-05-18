package bad.robot.drawing

import org.specs2.mutable.Specification

class TilesTest extends Specification {

  "remove single coordinate from tiles" >> {
    val tiles = new Tiles(Seq(
      Coordinate(0, 0) -> 'x', Coordinate(1, 0) -> 'x',
      Coordinate(0, 1) -> 'x', Coordinate(1, 1) -> 'x'
    ):_*)
    val expected = new Tiles(Seq(
      Coordinate(0, 0) -> 'x', Coordinate(1, 0) -> 'x',
      Coordinate(0, 1) -> 'x'
    ):_*)
    tiles - Coordinate(1, 1) must_== expected
  }

  "remove multiple coordinates from tiles" >> {
    val tiles = new Tiles(Seq(
      Coordinate(0, 0) -> 'x', Coordinate(1, 0) -> 'x',
      Coordinate(0, 1) -> 'x', Coordinate(1, 1) -> 'x'
    ):_*)
    val expected = new Tiles(Seq(
      Coordinate(0, 1) -> 'x', Coordinate(1, 1) -> 'x'
    ):_*)
    tiles - Seq(Coordinate(0, 0), Coordinate(1, 0)) must_== expected
  }

}
