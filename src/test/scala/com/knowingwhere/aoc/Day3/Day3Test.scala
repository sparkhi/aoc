package com.knowingwhere.aoc.Day3

import com.knowingwhere.aoc
import org.scalatest.Matchers._
import org.scalatest._

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
      aoc.Day3.Day3.getCommonDigit(lines, 0, "0") shouldBe "1"
      aoc.Day3.Day3.getCommonDigit(lines, 1, "0") shouldBe "0"
      aoc.Day3.Day3.getCommonDigit(lines, 2, "0") shouldBe "1"
      aoc.Day3.Day3.getCommonDigit(lines, 3, "0") shouldBe "1"
      aoc.Day3.Day3.getCommonDigit(lines, 4, "0") shouldBe "0"
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
      aoc.Day3.Day3.getCommonDigit(newLines, 1, "1") shouldBe "0"
    }

    "get individual when preferred is used " in {
      val newLines = List(
        "010",
        "011",
        "010",
        "011"
      )
      aoc.Day3.Day3.getCommonDigit(newLines, 2, "0") shouldBe "0"
      aoc.Day3.Day3.getCommonDigit(newLines, 2, "1") shouldBe "1"
    }

    "get gamma rate " in {
      aoc.Day3.Day3.getGammaRate(lines) shouldBe 22
    }

    "get epsilon rate " in {
      aoc.Day3.Day3.getEpsilonRate(lines) shouldBe 9
    }

    "get oxygen rate " in {
      aoc.Day3.Day3.getOxygenRating(lines, 0) shouldBe 23
    }

    "get co2 rate " in {
      aoc.Day3.Day3.getCo2Rating(lines, 0) shouldBe 10
    }
  }
}
