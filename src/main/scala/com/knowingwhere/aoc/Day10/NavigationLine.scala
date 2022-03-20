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

  def getClosingSequence: String = {
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
      _closingSequence = getClosingSequence
    }
  }

  def isIncomplete: Boolean = {
    _isIncomplete
  }

  def isCorrupt: Boolean = {
    _isCorrupt
  }

  def getCompletionScore: BigInt = {
    var score:BigInt = 0
    for (char <- _closingSequence) {
      score *= 5
      char match {
        case ')' => score += 1
        case ']' => score += 2
        case '}' => score += 3
        case '>' => score += 4
      }
    }
    score
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
