package com.knowingwhere.aoc.Day1

import scala.io.Source

object Day1 {
  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("day1-input.txt")
    val lines = resource.getLines().map(entry => entry.toInt).toList

    val trueFalse = getIncreases(lines)
    println(trueFalse.count(entry => entry))

    val part2List = lines.sliding(3).map(triplet => triplet.head + triplet(1) + triplet(2)).toList
    val part2TrueFalse = getIncreases(part2List)
    println(part2TrueFalse.count(entry => entry))
  }

  private def getIncreases(lines: List[Int]) = {
    lines.sliding(2).map(pair => pair(1) > pair.head).toList
  }
}
