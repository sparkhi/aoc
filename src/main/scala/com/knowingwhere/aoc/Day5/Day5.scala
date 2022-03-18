package com.knowingwhere.aoc.Day5

import scala.io.Source

object Day5 {
  def populateBoard(maxX: Int, maxY: Int, lines: List[Line]): Array[Array[Int]] = {
    val board = Array.fill[Int](maxX + 1, maxY + 1) {0}
    for (line <- lines) {
      val points: List[(Int, Int)] = line.getPoints
      for (point <- points) {
        board(point._1)(point._2) += 1
      }
    }
    board
  }

  def main(args: Array[String]): Unit = {
    val lines: List[Line] = Source.fromResource("day5-input.txt").getLines.map(new Line(_)).filter(_.isVerticalOrHorizontal).toList
    val filtered = doStuff(lines).map(eachRow => eachRow.count(_ > 1)).toList
    println(filtered.sum)

    val lines2: List[Line] = Source.fromResource("day5-input.txt").getLines.map(new Line(_)).toList
    val filtered2 = doStuff(lines2).map(eachRow => eachRow.count(_ > 1)).toList
    println(filtered2.sum)


  }

  def doStuff(lines: List[Line]): Array[Array[Int]] = {
    val maxX: Int = lines.map(_.getMaxX).max
    val maxY = lines.map(_.getMaxY).max

    val board = populateBoard(maxX, maxY, lines)
    board
  }
}
