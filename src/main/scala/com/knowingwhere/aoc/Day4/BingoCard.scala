package com.knowingwhere.aoc.Day4

class BingoCard (cardNums: List[List[Int]]) {

  def markElement(eachElement: BingoCell, i: Int): AnyVal = {
    if (eachElement.getValue == i) {
      eachElement.Mark(true)
    }
  }

  def mark(i: Int): List[List[AnyVal]] = {
    _cardValues.map(eachRow => eachRow.map(eachElement => markElement(eachElement, i)))
  }

  val _cardValues: List[List[BingoCell]] = cardNums.map(eachRow => eachRow.map(eachElement => new BingoCell(eachElement)))

  def cardValues: List[List[BingoCell]] = {
    _cardValues
  }

  def isBingoByRow:Boolean = {
    val rowMarkings = _cardValues.map(eachRow => eachRow.count(eachElement => !eachElement.isMarked))
    rowMarkings.contains(0)
  }

  def isBingoByColumn: Boolean = {
    val transposed = _cardValues.transpose
    val colMarkings = transposed.map(eachRow => eachRow.count(eachElement => !eachElement.isMarked))
    colMarkings.contains(0)
  }

  def isBingo: Boolean = {
    isBingoByRow || isBingoByColumn
  }

  def getScore(lastCalledNumber : Int): Int = {
    val unmarkedCards = _cardValues.map(row => row.filter(element => !element.isMarked))
    val total = unmarkedCards.map(row => row.map(element => element.getValue).sum).sum
    total * lastCalledNumber
  }
}
