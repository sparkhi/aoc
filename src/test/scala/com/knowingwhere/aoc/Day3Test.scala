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
      Day3.getCommonDigit(lines, 0) shouldBe "1"
      Day3.getCommonDigit(lines, 1) shouldBe "0"
      Day3.getCommonDigit(lines, 2) shouldBe "1"
      Day3.getCommonDigit(lines, 3) shouldBe "1"
      Day3.getCommonDigit(lines, 4) shouldBe "0"
    }

    "get gamma rate " in {
      Day3.getGammaRate(lines) shouldBe 22
    }

    "get epsilon rate " in {
      Day3.getEpsilonRate(lines) shouldBe 9
    }
  }
}
