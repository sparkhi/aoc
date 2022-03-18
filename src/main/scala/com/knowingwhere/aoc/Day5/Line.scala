package com.knowingwhere.aoc.Day5

class Line (lineDef: String){
  private val _startingX = lineDef.split("->").head.trim.split(",").head.toInt
  private val _startingY = lineDef.split("->").head.trim.split(",").tail.head.toInt

  private val _endingX = lineDef.split("->").tail.head.trim.split(",").head.toInt
  private val _endingY = lineDef.split("->").tail.head.trim.split(",").tail.head.toInt

  val getMaxX: Int = {
    if (_startingX > _endingX)
      _startingX
    else
      _endingX
  }

  val getMaxY: Int = {
    if (_startingY > _endingY)
      _startingY
    else
      _endingY
  }

  def isVerticalOrHorizontal: Boolean = {
    val direction = getLineDirection
    direction == LineDirections.SOUTH || direction == LineDirections.NORTH || direction == LineDirections.EAST || direction == LineDirections.WEST
  }

  def getLineDirection: LineDirections.Value = {
    if (_startingX == _endingX) {
      if (_startingY < _endingY) {
        LineDirections.SOUTH
      } else {
        LineDirections.NORTH
      }
    } else if (_startingY == _endingY) {
      if (_startingX < _endingX) {
        LineDirections.EAST
      } else {
        LineDirections.WEST
      }
    } else {
      if (_startingX < _endingX) {
        if (_startingY < _endingY) {
          LineDirections.SOUTHEAST
        } else {
          LineDirections.NORTHEAST
        }
      } else {
        if (_startingY < _endingY) {
          LineDirections.SOUTHWEST
        } else {
          LineDirections.NORTHWEST
        }
      }
    }
  }

  val getPoints: List[(Int, Int)] = {
    val diffX = Math.abs(_startingX - _endingX)
    val direction = getLineDirection
    var points: List[(Int, Int)] = List.empty
    direction match {
      case LineDirections.SOUTH =>
        points = Range.inclusive(_startingY, _endingY, 1).map(_startingX -> _).toList
      case LineDirections.NORTH =>
        points =Range.inclusive(_startingY, _endingY, -1).map(_startingX -> _).toList
      case LineDirections.EAST =>
        points = Range.inclusive(_startingX, _endingX, 1).map(_ -> _startingY).toList
      case LineDirections.WEST =>
        points = Range.inclusive(_startingX, _endingX, -1).map(_ -> _startingY).toList
      case LineDirections.SOUTHEAST =>
        for (index <- 0 to diffX) {
          points = points :+ ((_startingX + index) -> (_startingY + index))
        }
      case LineDirections.NORTHWEST =>
        for (index <- 0 to diffX) {
          points = points :+ ((_startingX - index) -> (_startingY - index))
        }
      case LineDirections.SOUTHWEST =>
        for (index <- 0 to diffX) {
          points = points :+ ((_startingX - index) -> (_startingY + index))
        }
      case LineDirections.NORTHEAST =>
        for (index <- 0 to diffX) {
          points = points :+ ((_startingX + index) -> (_startingY - index))
        }
      case _ =>
        throw new Exception("how on earth (pun intended) can we have another direction")

    }
    points
  }
}
object LineDirections extends Enumeration {
  type LineDirection = Value
  val NORTH, SOUTH, EAST, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST = Value
}
