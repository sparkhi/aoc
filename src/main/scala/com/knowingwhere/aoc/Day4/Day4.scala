package com.knowingwhere.aoc.Day4

import scala.annotation.tailrec
import scala.io.Source

object Day4 {

  def createCards(cardLines: List[String]): List[BingoCard] = {
    val validCardLines = cardLines.filter(_.nonEmpty)
    val cardGroups: List[List[String]] = validCardLines.sliding(5, 5).toList
    val groups: List[List[List[Int]]] = cardGroups.map(groups => groups.map(eachString => eachString.trim.replace("  ", " ").split(" ").map(_.toInt).toList))
    groups.map(new BingoCard(_))

  }

  @tailrec
  def getBingoAnswer(number: Int, bingoCards: List[BingoCard]): Int = {
    if (bingoCards.isEmpty) {
      -1
    } else {
      val card = bingoCards.head

      card.mark(number)
      if (card.isBingo) {
        card.getScore(number)
      } else {
        getBingoAnswer(number, bingoCards.tail)
      }
    }
  }

  //recurse into collection and return the score for first card that bingo
  @tailrec
  def calculatePart1(numbersToCall: Array[Int], bingoCards: List[BingoCard]): Int = {
    val number = numbersToCall.head
    val answer = getBingoAnswer(number, bingoCards)
    if (answer == -1) {
      calculatePart1(numbersToCall.tail, bingoCards)
    } else {
      answer
    }
  }

  var finalScore = 0

  //nested loop over entire collection and get the score of last card that turned bingo
  def calculatePart2(numbersToCall: Array[Int], bingoCards: List[BingoCard]): Int = {
    for (num <- numbersToCall) {
      for (card <- bingoCards) {
        if (!card.isBingo) {
          card.mark(num)
          if (card.isBingo) {
            finalScore = card.getScore(num)
          }
        }
      }
    }
    finalScore
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("day4-input.txt")
    val lines = resource.getLines.toList

    val numbersToCall = lines.head.split(",").map(_.toInt)
    val bingoCards = createCards(lines.tail)

    val answer = calculatePart1(numbersToCall, bingoCards)
    println(answer)

    val answer2 = calculatePart2(numbersToCall, bingoCards)
    println(answer2)
  }
}