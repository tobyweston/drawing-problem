package com.springer.drawing

object Validation {
  def numbers(values: String*) = values.forall(_.forall(_.isDigit))
  def char(value: String) = value.length == 1
}
