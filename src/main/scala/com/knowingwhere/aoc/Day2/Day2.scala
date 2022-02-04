package com.knowingwhere.aoc.Day2

import scala.io.Source

object Day2 {

  def recurseAdd(lines: List[(String, Int)], forward: Int, deep: Int): (Int, Int) = {
    if (lines.isEmpty) {
      (forward, deep)
    } else {
      val line = lines.head
      val (f: Int, d: Int) = line._1 match {
        case "forward" => recurseAdd(lines.tail, forward + line._2, deep)
        case "up" => recurseAdd(lines.tail, forward, deep - line._2)
        case "down" => recurseAdd(lines.tail, forward, deep + line._2)
      }
      (f, d)
    }
  }

  def recurseAddPart2(lines: List[(String, Int)], forward: Int, deep: Int, aim: Int): (Int, Int) = {
    if (lines.isEmpty) {
      (forward, deep)
    } else {
      val line = lines.head
      val (f: Int, d: Int) = line._1 match {
        case "up" => recurseAddPart2(lines.tail, forward, deep, aim - line._2)
        case "down" => recurseAddPart2(lines.tail, forward, deep, aim + line._2)
        case "forward" => recurseAddPart2(lines.tail, forward + line._2, deep + (aim * line._2), aim)
      }
      (f, d)
    }
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("day2-input.txt")
    val lines = resource.getLines().map(entry => (entry.split(" ")(0), entry.split(" ")(1).toInt)).toList

    val (forward, deep) = recurseAdd(lines, 0: Int, 0: Int)
    println(forward * deep)

    val (f, d) = recurseAddPart2(lines, 0: Int, 0: Int, 0: Int)
    println(f * d)
  }
}
