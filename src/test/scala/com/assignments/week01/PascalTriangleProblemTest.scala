package com.assignments.week01

import org.scalatest.FunSuite

import com.assignments.week01.PascalTriangleProblem.generateNumber


class PascalTriangleProblemTest extends FunSuite {

  test("pascal: col=0,row=2") {
    assert(generateNumber(0, 2) == 1)
  }

  test("pascal: col=1,row=2") {
    assert(generateNumber(1, 2) == 2)
  }

  test("pascal: col=1,row=3") {
    assert(generateNumber(1, 3) == 3)
  }

}