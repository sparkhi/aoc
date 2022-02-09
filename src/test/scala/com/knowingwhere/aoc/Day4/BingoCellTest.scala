package com.knowingwhere.aoc.Day4

import com.knowingwhere.aoc
import org.scalatest.Matchers._
import org.scalatest._

class BingoCellTest extends WordSpec with BeforeAndAfterEach {
  "Bingo Cell " should {
    "return correct value " in {
      new BingoCell(25).getValue shouldBe 25
    }

    "default marking of cell should be false " in {
      new BingoCell(12).isMarked shouldBe false
    }

    "mark the value in the cell " in {
      val cell = new BingoCell(10)
      cell.Mark(false)
      cell.isMarked shouldBe false

      cell.Mark(true)
      cell.isMarked shouldBe true
    }
  }
}
