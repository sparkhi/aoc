package com.knowingwhere.aoc

import scala.io.Source

object Day3 {
  def getEpsilonRate(lines: List[String]): Int = {
    val epsilonStringFull = (~getGammaRate(lines)).toBinaryString
    Integer.parseInt(epsilonStringFull.substring(epsilonStringFull.length - 12), 2)
  }


  def getGammaRate(lines: List[String]): Int = {
    val gammaString = getCommonDigit(lines, 0) + getCommonDigit(lines, 1) + getCommonDigit(lines, 2) +
      getCommonDigit(lines, 3) + getCommonDigit(lines, 4) + getCommonDigit(lines, 5) +
      getCommonDigit(lines, 6) + getCommonDigit(lines, 7) + getCommonDigit(lines, 8) +
      getCommonDigit(lines, 9) + getCommonDigit(lines, 10) + getCommonDigit(lines, 11)
    Integer.parseInt(gammaString, 2)
  }

  def getCommonDigit(lines: List[String], index: Int): String = {
    val lineSize = lines.size
    val sum = lines.map(line => line.substring(index, index + 1).toInt).sum
    if (sum >= lineSize / 2) {
      "1"
    } else {
      "0"
    }
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("day3-input.txt")
    val lines = resource.getLines.toList

    println(getGammaRate(lines) * getEpsilonRate(lines))

  }
}
