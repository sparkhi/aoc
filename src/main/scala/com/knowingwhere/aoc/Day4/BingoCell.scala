package com.knowingwhere.aoc.Day4

class BingoCell (cellValue: Int){
  var _isMarked = false

  def Mark(newValue: Boolean): Boolean = {
    _isMarked = newValue
    _isMarked
  }

  def isMarked = {
    _isMarked
  }

  def getValue: Int = {
    cellValue
  }
}
