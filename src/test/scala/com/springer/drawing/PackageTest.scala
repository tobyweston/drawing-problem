package com.springer.drawing

import org.specs2.mutable.Specification

class PackageTest extends Specification {

  "multi-line string literal should use platform line separator (stripMargin would fail on mac but pass on windows)" >> {
    """
      |""".stripMargin2('|') must_== sys.props("line.separator")
  }
}