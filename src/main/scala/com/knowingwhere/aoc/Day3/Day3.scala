package com.knowingwhere.aoc.Day3

import scala.io.Source

object Day3 {
  def getEpsilonRate(lines: List[String]): Int = {
    val epsilonStringFull = generateGammaRateString(lines, "").replace('0', 'X').replace('1', '0').replace('X', '1')
    Integer.parseInt(epsilonStringFull, 2)
  }

  def getGammaRate(lines: List[String]): Int = {
    Integer.parseInt(generateGammaRateString(lines, ""), 2)
  }


  def generateGammaRateString(lines: List[String], prefix: String): String = {
    val index = prefix.length
    val commonDigit = getCommonDigit(lines, index, "0")
    val retVal = prefix + commonDigit
    if (retVal.length == lines.head.length) {
      retVal
    } else {
      generateGammaRateString(lines, retVal)
    }
  }

  def getCommonDigit(lines: List[String], index: Int, preferred: String): String = {
    val lineSize = lines.size
    val count1 = lines.count(line => line.substring(index, index + 1).equals("1"))
    count1 match {
      case x if x > (lineSize / 2f) => "1"
      case x if x < (lineSize / 2f) => "0"
      case _ => preferred
    }
  }

  def getOxygenRating(lines: List[String], index: Int): Int = {
    val common = getCommonDigit(lines, index, "1")
    val remaining = lines.filter(line => line.substring(index, index + 1).equals(common))
    if (remaining.size > 1) {
      getOxygenRating(remaining, index + 1)
    } else {
      Integer.parseInt(remaining.head, 2)
    }
  }

  def getCo2Rating(lines: List[String], index: Int): Int = {
    val common = getCommonDigit(lines, index, "1")
    val remaining = lines.filter(line => !line.substring(index, index + 1).equals(common))
    if (remaining.size > 1) {
      getCo2Rating(remaining, index + 1)
    } else {
      Integer.parseInt(remaining.head, 2)
    }
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("day3-input.txt")
    val lines = resource.getLines.toList

    println(getGammaRate(lines) * getEpsilonRate(lines))

    println(getOxygenRating(lines, 0) * getCo2Rating(lines, 0))

  }
}
