package com.knowingwhere.aoc.Day4

import com.knowingwhere.aoc
import org.scalatest.Matchers._
import org.scalatest._

class BingoCardTest extends WordSpec with BeforeAndAfterEach {
  "Bingo Card " should {
    "return correct value " in {
      val bingoCard = new BingoCard(List(List(1,2,3), List(11,12,13), List(21,22,23)))
      bingoCard.cardValues(1)(1).getValue shouldBe 12
      bingoCard.cardValues(1)(1).isMarked shouldBe false
    }

    "mark a particular number as marked once it is called " in {
      val bingoCard = new BingoCard(List(List(1,2,3), List(11,12,13), List(21,22,23)))
      bingoCard.cardValues(1)(2).isMarked shouldBe false
      bingoCard.mark(13)
      bingoCard.cardValues(1)(2).isMarked shouldBe true
    }

    "should report Bingo when an entire row is marked" in {
      val bingoCard = new BingoCard(List(List(1,2,3), List(11,12,13), List(21,22,23)))
      bingoCard.mark(1)
      bingoCard.isBingo shouldBe false
      bingoCard.mark(11)
      bingoCard.isBingo shouldBe false
      bingoCard.mark(13)
      bingoCard.isBingo shouldBe false
      bingoCard.mark(12)
      bingoCard.isBingo shouldBe true
    }

    "should report Bingo when an entire column is marked" in {
      val bingoCard = new BingoCard(List(List(1,2,3), List(11,12,13), List(21,22,23)))
      bingoCard.mark(1)
      bingoCard.isBingo shouldBe false
      bingoCard.mark(11)
      bingoCard.isBingo shouldBe false
      bingoCard.mark(13)
      bingoCard.isBingo shouldBe false
      bingoCard.mark(21)
      bingoCard.isBingo shouldBe true
    }

    "should calculate score " in {
      val bingoCard = new BingoCard(List(List(1,2,3), List(11,12,13), List(21,22,23)))
      bingoCard.mark(1)
      bingoCard.mark(11)
      bingoCard.mark(23)
      bingoCard.mark(13)
      bingoCard.mark(21)
      bingoCard.getScore(21) shouldBe 819
    }
  }
}
