package com.knowingwhere.aoc.Day9

import org.scalatest.Matchers._
import org.scalatest._

class Day9Test extends WordSpec with BeforeAndAfterEach {


  "day 9 " should {
    val stringLines = List(
      "2199943210",
      "3987894921",
      "9856789892",
      "8767896789",
      "9899965678").map(_.split("").toList)
    "should correctly identify the low number " in {
      Day9.isLow(0, 0, stringLines) shouldBe false
      Day9.isLow(0, 9, stringLines) shouldBe true
      Day9.isLow(0, 1, stringLines) shouldBe true
    }
    "should identify the smallest places in the vicinity " in {

      val result = Day9.getLowPoints(stringLines)

      result.head._1 shouldBe 0
      result.head._2 shouldBe 1
    }
    "should calculate basin size for a given low point " in {
      val basinSize = Day9.getBasinSize(0, 1, stringLines)
      basinSize shouldBe 3

      Day9.getBasinSize(0, 9, stringLines) shouldBe 9

      Day9.getBasinSize(2,2, stringLines) shouldBe 14

      Day9.getBasinSize(4,6, stringLines) shouldBe 9
    }
  }
}
