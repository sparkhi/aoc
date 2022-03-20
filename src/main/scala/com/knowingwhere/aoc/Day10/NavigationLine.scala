package com.knowingwhere.aoc.Day10

import scala.collection.mutable

class NavigationLine (line: String){
  private val charStack = mutable.Stack[String]()
  val charList: List[String] = line.split("").toList
  private var _isCorrupt = false
  private var _isIncomplete = false
  private var _offendingChar = ""
  private var _closingSequence = ""
  for (oneChar <- charList) {
    if (!_isCorrupt) {
      oneChar match {
        case x if x == "{" || x == "<" || x == "(" || x == "[" =>
          charStack.push(x)
        case ">" =>
          if (charStack.head == "<") {
            charStack.pop()
          } else {
            _offendingChar = ">"
            _isCorrupt = true
          }
        case "}" =>
          if (charStack.head == "{") {
            charStack.pop()
          } else {
            _offendingChar = "}"
            _isCorrupt = true
          }
        case "]" =>
          if (charStack.head == "[") {
            charStack.pop()
          } else {
            _offendingChar = "]"
            _isCorrupt = true
          }
        case ")" =>
          if (charStack.head == "(") {
            charStack.pop()
          } else {
            _offendingChar = ")"
            _isCorrupt = true
          }
      }
    }
  }

  def generateClosingSequence: String = {
    val closingChars: mutable.StringBuilder = new StringBuilder()
    while (charStack.nonEmpty) {
      val s = charStack.pop()
      s match {
        case "(" => closingChars.append(")")
        case "[" => closingChars.append("]")
        case "{" => closingChars.append("}")
        case "<" => closingChars.append(">")
      }
    }
    closingChars.mkString
  }

  if (!_isCorrupt) {
    if (charStack.nonEmpty) {
      _isIncomplete = true
      _closingSequence = generateClosingSequence
    }
  }

  def isIncomplete: Boolean = {
    _isIncomplete
  }

  def isCorrupt: Boolean = {
    _isCorrupt
  }

  def getSyntaxErrorScore: Int = {
    if (isCorrupt) {
      _offendingChar match {
        case ")" => 3
        case "]" => 57
        case "}" => 1197
        case ">" => 25137
      }
    } else {
      -1
    }
  }
}
