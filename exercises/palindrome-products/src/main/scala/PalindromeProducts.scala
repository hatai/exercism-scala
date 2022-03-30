import scala.annotation.tailrec

case class PalindromeProducts(start: Int, end: Int) {
  @tailrec
  val palindromeProducts: Set[Int] = {
    if (start >= end) {
      Set.empty[Int]
    } else {
      (start to end).flatMap(e => (start to e).map(e * _).filter(e => isPalindrome(e.toString))).toSet
    }
  }

  def smallest(): Option[(Int, Set[(Int, Int)])] = {
    if (palindromeProducts.isEmpty) {
      None
    } else {
      val min = palindromeProducts.min
      val factors = getFactor(min)
      Option(min, factors)
    }
  }

  def largest(): Option[(Int, Set[(Int, Int)])] = {
    if (palindromeProducts.isEmpty) {
      None
    } else {
      val max = palindromeProducts.max
      val factors = getFactor(max)
      Option(max, factors)
    }
  }

  private def getFactor(n: Int): Set[(Int, Int)] = n match {
    case 1 => Set((1, 1))
    case x if x == start => Set.empty[(Int, Int)]
    case _ => (start until n)
      .filter(e => n % e == 0 && e.toString.length == (n / e).toString.length)
      .map(e => {
        val e1 = e
        val e2 = n / e
        if (e1 <= e2) (e1, e2) else (e2, e1)
      })
      .toSet
  }

  private def isPalindrome(n: String):Boolean = n == n.reverse
}
