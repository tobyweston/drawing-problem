package bad.robot.drawing

import org.specs2.mutable.Specification


class BorderTest extends Specification {

  "draw a border" >> {
    val array: Array[Array[Char]] = Array.ofDim(3, 3)
    val expected = Array(
      Array('=', '=', '='),
      Array('*', ' ', '*'),
      Array('=', '=', '=')
    )
    Border('=', '*').applyTo(array)
    array must_== expected
  }

  "fail if array is not of a uniform size" >> {
    val array = Array(
      Array('x', 'x', 'x'),
      Array('x', 'x', 'x', 'x'),
      Array('x', 'x', 'x')
    )
    Border('=', '*').applyTo(array) must throwA(new CannotApplyBorder)
  }
  
  "draw a border for a tiny array" >> {
    val array = Array(Array('?'))
    val expected = Array(Array('*'))
    Border('*', '*').applyTo(array)
    array must_== expected
  }

  "draw a border for a small array" >> {
    val array = Array(
      Array('?', '?'),
      Array('?', '?')
    )
    val expected = Array(
      Array('*', '*'),
      Array('*', '*')
    )
    Border('*', '*').applyTo(array)
    array must_== expected
  }

  "empty array is untouched" >> {
    val array: Array[Array[Char]] = Array(Array())
    val expected: Array[Array[Char]] = Array(Array())
    Border('=', '*').applyTo(array)
    array must_== expected
  }
}
