package com.knowingwhere.aoc

import org.scalatest._
import org.scalatest.Matchers._

class Day3Test extends WordSpec with BeforeAndAfterEach {
  "Day3" should {
    val lines = List(
      "00100",
      "11110",
      "10110",
      "10111",
      "10101",
      "01111",
      "00111",
      "11100",
      "10000",
      "11001",
      "00010",
      "01010"
    )

    "get individual common digits " in {
      Day3.getCommonDigit(lines, 0, "0") shouldBe "1"
      Day3.getCommonDigit(lines, 1, "0") shouldBe "0"
      Day3.getCommonDigit(lines, 2, "0") shouldBe "1"
      Day3.getCommonDigit(lines, 3, "0") shouldBe "1"
      Day3.getCommonDigit(lines, 4, "0") shouldBe "0"
    }

    "get common digit " in {
      val newLines = List(
        "11110",
        "10110",
        "10111",
        "10101",
        "11100",
        "10000",
        "11001"
      )
      Day3.getCommonDigit(newLines, 1, "1") shouldBe "0"
    }

    "get individual when preferred is used " in {
      val newLines = List(
        "010",
        "011",
        "010",
        "011"
      )
      Day3.getCommonDigit(newLines, 2, "0") shouldBe "0"
      Day3.getCommonDigit(newLines, 2, "1") shouldBe "1"
    }

    "get gamma rate " in {
      Day3.getGammaRate(lines) shouldBe 22
    }

    "get epsilon rate " in {
      Day3.getEpsilonRate(lines) shouldBe 9
    }

    "get oxygen rate " in {
      Day3.getOxygenRating(lines, 0) shouldBe 23
    }

    "get co2 rate " in {
      Day3.getCo2Rating(lines, 0) shouldBe 10
    }
  }
}
