package com.knowingwhere.aoc.Day5

import org.scalatest.Matchers._
import org.scalatest._

class Day5Test extends WordSpec with BeforeAndAfterEach {
  "Line " should {
    "create valid horizontal line " in {
      val stringLines = List(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2")
      val result = Day5.doStuff(stringLines.map(new Line(_)))
      result(0).mkString shouldBe "0000000100"
      result(4).mkString shouldBe "0112313211"
    }
  }
}
