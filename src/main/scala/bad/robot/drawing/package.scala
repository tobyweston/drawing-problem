package bad.robot

package object drawing {

  object Int {
    def unapply(options: String): Option[(Int)] = {
      options match {
        case number if isNumber(number) => Some(number.toInt)
        case _ => None
      }
    }
    def isNumber(value: String) = if (!value.isEmpty) value.forall(_.isDigit) else false
  }

  object Char {
    def unapply(options: String): Option[(Char)] = {
      options match {
        case string if isChar(string) => Some(string.charAt(0))
        case _ => None
      }
    }
    def isChar(value: String) = value.length == 1
  }

}
