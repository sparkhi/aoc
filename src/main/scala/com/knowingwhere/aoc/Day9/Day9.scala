package com.knowingwhere.aoc.Day9

import scala.io.Source

object Day9 {

  def expandBasinLeft(x: Int, y: Int, currentValue: Int, stringLines: List[List[String]], points: List[(Int, Int)]): List[(Int, Int)] = {
    if (y == 0) {
      points
    } else {
      val newCurrent = stringLines(x)(y - 1).toInt
      if ((newCurrent > currentValue) && (newCurrent < 9)) {
        expandBasin(x, y - 1, newCurrent, stringLines, points)
      } else {
        points
      }
    }
  }

  def expandBasinTop(x: Int, y: Int, currentValue: Int, stringLines: List[List[String]], points: List[(Int, Int)]): List[(Int, Int)] = {
    if (x == 0) {
      points
    } else {
      val newCurrent = stringLines(x - 1)(y).toInt
      if ((newCurrent > currentValue) && (newCurrent < 9)) {
        expandBasin(x - 1, y, newCurrent, stringLines, points)
      } else {
        points
      }
    }
  }

  def expandBasinRight(x: Int, y: Int, currentValue: Int, stringLines: List[List[String]], points: List[(Int, Int)]): List[(Int, Int)] = {
    if (y == stringLines(x).size - 1) {
      points
    } else {
      val newCurrent = stringLines(x)(y + 1).toInt
      if ((newCurrent > currentValue)  && (newCurrent < 9)){
        expandBasin(x, y + 1, newCurrent, stringLines, points)
      } else {
        points
      }
    }
  }

  def expandBasinBottom(x: Int, y: Int, currentValue: Int, stringLines: List[List[String]], points: List[(Int, Int)]): List[(Int, Int)] = {
    if (x == stringLines.size - 1) {
      points
    } else {
      val newCurrent = stringLines(x + 1)(y).toInt
      if ((newCurrent > currentValue)  && (newCurrent < 9)){
        expandBasin(x + 1, y, newCurrent, stringLines, points)
      } else {
        points
      }
    }
  }

  def expandBasin(x: Int, y: Int, currentValue: Int, stringLines: List[List[String]], currentPoints: List[(Int, Int)]): List[(Int, Int)] = {
    var points: List[(Int, Int)] = currentPoints
    points = expandBasinLeft(x, y, currentValue, stringLines, points)
    points = expandBasinTop(x, y, currentValue, stringLines, points)
    points = expandBasinRight(x, y, currentValue, stringLines, points)
    points = expandBasinBottom(x, y, currentValue, stringLines, points)
    if (!points.contains(x -> y)) { //some points could get traversed from multiple locations
      points = points :+ (x -> y)
    }
    points
  }

  def getBasinSize(x: Int, y: Int, stringLines: List[List[String]]): Int = {
    val currentValue = stringLines(x)(y).toInt
    var points: List[(Int, Int)] = List.empty
    points = expandBasin(x, y, currentValue, stringLines, points)
    points.size
  }


  private def lowerThanTop(x: Int, y: Int, lines: List[List[String]]): Boolean = {
    if (x == 0) {
      true
    } else {
      lines(x)(y).toInt < lines(x -1)(y).toInt
    }
  }

  private def lowerThanRight(x: Int, y: Int, lines: List[List[String]]): Boolean = {
    if (y == lines(x).size - 1) {
      true
    } else {
      lines(x)(y).toInt < lines(x)(y + 1).toInt
    }
  }

  private def lowerThanBottom(x: Int, y: Int, lines: List[List[String]]): Boolean = {
    if (x == lines.size - 1) {
      true
    } else {
      lines(x)(y).toInt < lines(x + 1)(y).toInt
    }
  }

  private def lowerThanLeft(x: Int, y: Int, lines: List[List[String]]): Boolean = {
    if (y == 0) { //nothing on the left
      true
    } else {
      lines(x)(y).toInt < lines(x)(y -1).toInt
    }
  }

  def isLow(x: Int, y: Int, lines: List[List[String]]): Boolean = {
    if (lowerThanTop(x, y, lines) && lowerThanRight(x, y, lines) && lowerThanBottom(x, y, lines) && lowerThanLeft(x, y, lines))
      true
    else
      false
  }

  def getLowPoints(lines: List[List[String]]): List[(Int, Int)] = {
    var lowPoints: List[(Int, Int)] = List.empty
    for (x <- lines.indices) {
      for (y <- lines(x).indices) {
        if (isLow(x, y, lines)) {
          lowPoints = lowPoints :+ (x -> y)
        }
      }
    }
    lowPoints
  }

  def main(args: Array[String]): Unit = {
    val lines: List[List[String]] = Source.fromResource("day9-input.txt").getLines().map(_.split("").toList).toList
    val result = getLowPoints(lines)
    println(result.map(pt => lines(pt._1)(pt._2).toInt + 1).sum)

    val sizes = result.map(point => getBasinSize(point._1, point._2, lines)).sorted(Ordering.Int.reverse)
    println(sizes.splitAt(3)._1.product)
  }
}
