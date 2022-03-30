object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    var result = Set.empty[Int]

    for (x <- factors) {
      for (
        i <- x until limit
        if i % x == 0
        if !(result contains i)
      ) {
        result += i
      }
    }

    result.sum
  }
}

