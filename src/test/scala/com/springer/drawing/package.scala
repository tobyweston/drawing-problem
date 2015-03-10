package com.springer

package object drawing {

  /**
   * work around for [[https://issues.scala-lang.org/browse/SI-9203]]
   **/
  implicit class PlatformLineSeparatorBugFix(string: String) {
    def stripMargin2(marginChar: Char): String = {
      string.stripMargin(marginChar).replaceAll("\r\n", sys.props("line.separator"))
    }
  }

}
