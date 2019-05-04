package funsets

import org.scalatest.FunSuite

import FunSets._


class FunSetSuite extends FunSuite {

  test("contains: testing postivie numbers that shouldn't be contained in the set") {
    assert(!contains(n => n < 0, 100))
  }

  test("contains: testing negative numbers that should be contained in the set") {
    assert(contains(n => n < 0, -100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(2)
  }

  test("singletonSet: test with singletonSet(1) and it should contain 1") {
    new TestSets {
      assert(contains(s1, 1))
    }
  }

  test("union: contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1))
      assert(contains(s, 2))
      assert(!contains(s, 3))
    }
  }

  test("intersect: contains the instersection of 2 sets") {
    new TestSets {
      val s = intersect(s2, s4)
      assert(contains(s, 2))
      assert(!contains(s, 3))
    }
  }

  test("diff: contains elements in 1st set that don't exist in the other set") {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1))
      assert(!contains(s, 2))
    }
  }

  test("filter: contains subset of a certain set which matches a certain predicate") {
    new TestSets {
      val s = filter(s2, n => n == 2)
      assert(contains(s, 2))
      assert(!contains(s, 3))
    }
  }

  test("forall: bounded values don't match the predicate") {
    assert(!forall(n => n < 0, n => n > 0))
  }

  test("forall: bounded values do match the predicate") {
    assert(forall(n => n < 0, n => n < 0))
  }

  test("exists: an element exists in a set that a matches a certain predicate") {
    assert(exists(n => n < 0, n => n < 0))
  }

  test("exists: an element doesn't exist in a set because it doesn't matches a certain predicate") {
    assert(!exists(n => n < 0, n => n > 0))
  }

  test("map: an element belongs to a set after transformation") {
    assert(map(n => n < 0, n => n).apply(-5))
  }

  test("map: an element doesn't belong to a set after transformation") {
    assert(map(n => n < 0, n => n).apply(5))
  }
  
}
