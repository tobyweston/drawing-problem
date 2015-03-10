package com.springer.drawing

import org.specs2.mutable.Specification

class NewCanvasTest extends Specification {

  "extractor" >> {
    "wont 'extract' given invalid options" >> {
      NewCanvas.unapply(List("")) must_== None
      NewCanvas.unapply(List("C", "one", "2")) must_== None
      NewCanvas.unapply(List("C", "1", "two")) must_== None
      NewCanvas.unapply(List("x", "1", "2")) must_== None
      NewCanvas.unapply(List("C", "1", "2", "extra")) must_== None
    }
    "extracts parameters" >> {
      NewCanvas.unapply(List("C", "1", "2")) must_== Some((1, 2))
    }
  }

}
