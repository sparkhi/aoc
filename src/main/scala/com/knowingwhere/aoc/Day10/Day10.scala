package com.knowingwhere.aoc.Day10

import scala.io.Source

object Day10 {
  def main(args: Array[String]): Unit = {
    val lines: List[String] = Source.fromResource("day10-input.txt").getLines().toList
    println(lines.map(new NavigationLine(_)).filter(!_.isIncomplete).filter(_.isCorrupt).map(_.getSyntaxErrorScore).sum)
  }

}
