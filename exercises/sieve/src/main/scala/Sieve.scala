object Sieve {
  def primes(limit: Int): List[Int] = {
    sieve((2 to limit).toList)
  }

  private def sieve(ls: List[Int]): List[Int] = ls.headOption match {
    case None => ls
    case Some(head) => head :: sieve(ls.tail.filter(_ % head != 0))
  }
}
