package com.knowingwhere.aoc.Day10

import org.scalatest.Matchers._
import org.scalatest._

class NavigationLineTest extends WordSpec with BeforeAndAfterEach {

    "Navigation Line " should {
      "should identify the incomplete line  " in {
        val lines = List(
          "[({(<(())[]>[[{[]{<()<>>",
          "[(()[<>])]({[<{<<[]>>(",
          "{([(<{}[<>[]}>{[]{[(<()>",
          "(((({<>}<{<{<>}{[]{[]{}",
          "[[<[([]))<([[{}[[()]]]",
          "[{[{({}]{}}([{[{{{}}([]",
          "{<[[]]>}<{[{[{[]{()[[[]",
          "[<(<(<(<{}))><([]([]()",
          "<{([([[(<>()){}]>(<<{{",
          "<{([{{}}[<[[[<>{}]]]>[]]"
        )
        val navLine1 = new NavigationLine(lines.head)
        navLine1.isIncomplete shouldBe true
        navLine1.isCorrupt shouldBe false
        navLine1.getSyntaxErrorScore shouldBe -1

        val navLine2 = new NavigationLine(lines(2))
        navLine2.isIncomplete shouldBe false
        navLine2.isCorrupt shouldBe true
        navLine2.getSyntaxErrorScore shouldBe 1197
      }
    }
}
