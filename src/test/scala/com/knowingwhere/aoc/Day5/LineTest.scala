package com.knowingwhere.aoc.Day5

import org.scalatest.Matchers._
import org.scalatest._

class LineTest extends WordSpec with BeforeAndAfterEach {
  "Line " should {
    "create valid horizontal line " in {
      val line = new Line("0,9 -> 5,9")
      line.getLineDirection shouldBe LineDirections.EAST
      line.getPoints.size shouldBe 6
    }
    "create valid vertical line " in {
      val line = new Line("7,0 -> 7,4")
      line.getLineDirection shouldBe LineDirections.SOUTH
      line.getPoints.size shouldBe 5
    }
    "create valid vertical line in other direction" in {
      val line = new Line("7,0 -> 7,4")
      line.getLineDirection shouldBe LineDirections.SOUTH
      line.getPoints.size shouldBe 5
      line.getPoints.head._1 shouldBe 7
      line.getPoints.head._2 shouldBe 0
    }
    "create points for a line that is at 45 degrees angle direction south-east" in {
      val line = List(new Line("1,1 -> 5,5"), new Line("1,3 -> 4,6"))
      line.head.getLineDirection shouldBe LineDirections.SOUTHEAST
      line.head.getPoints.size shouldBe 5
      line.head.getPoints.map(_._1).mkString shouldBe "12345"
      line.head.getPoints.map(_._2).mkString shouldBe "12345"

      line.tail.head.getLineDirection shouldBe LineDirections.SOUTHEAST
      line.tail.head.getPoints.size shouldBe 4
      line.tail.head.getPoints.map(_._1).mkString shouldBe "1234"
      line.tail.head.getPoints.map(_._2).mkString shouldBe "3456"
    }

    "create points for a line that is at 45 degrees angle direction north-west" in {
      val line = List(new Line("5,5 -> 1,1"), new Line("4,6 -> 1,3"))
      line.head.getLineDirection shouldBe LineDirections.NORTHWEST
      line.head.getPoints.size shouldBe 5
      line.head.getPoints.map(_._1).mkString shouldBe "54321"
      line.head.getPoints.map(_._2).mkString shouldBe "54321"

      line.tail.head.getLineDirection shouldBe LineDirections.NORTHWEST
      line.tail.head.getPoints.size shouldBe 4
      line.tail.head.getPoints.map(_._1).mkString shouldBe "4321"
      line.tail.head.getPoints.map(_._2).mkString shouldBe "6543"
    }

    "create points for a line that is at 45 degrees angle direction south-west" in {
      val line = List(new Line("5,5 -> 1,9"), new Line("4,6 -> 1,9"))
      line.head.getLineDirection shouldBe LineDirections.SOUTHWEST
      line.head.getPoints.size shouldBe 5
      line.head.getPoints.map(_._1).mkString shouldBe "54321"
      line.head.getPoints.map(_._2).mkString shouldBe "56789"

      line.tail.head.getLineDirection shouldBe LineDirections.SOUTHWEST
      line.tail.head.getPoints.size shouldBe 4
      line.tail.head.getPoints.map(_._1).mkString shouldBe "4321"
      line.tail.head.getPoints.map(_._2).mkString shouldBe "6789"
    }

    "create points for a line that is at 45 degrees angle direction north-east" in {
      val line = List(new Line("1,9 -> 5,5"), new Line("1,9 -> 4,6"))
      line.head.getLineDirection shouldBe LineDirections.NORTHEAST
      line.head.getPoints.size shouldBe 5
      line.head.getPoints.map(_._1).mkString shouldBe "12345"
      line.head.getPoints.map(_._2).mkString shouldBe "98765"

      line.tail.head.getLineDirection shouldBe LineDirections.NORTHEAST
      line.tail.head.getPoints.size shouldBe 4
      line.tail.head.getPoints.map(_._1).mkString shouldBe "1234"
      line.tail.head.getPoints.map(_._2).mkString shouldBe "9876"
    }
  }
}
