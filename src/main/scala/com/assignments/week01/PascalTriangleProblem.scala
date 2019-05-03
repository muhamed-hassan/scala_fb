package com.assignments.week01


object PascalTriangleProblem {

  def generateNumber(column: Int, row: Int): Int = {

    if (column == 0 || column == row)
      1
    else
      generateNumber(column - 1, row - 1) + generateNumber(column, row - 1)
  }

}