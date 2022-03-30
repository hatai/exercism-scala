object NthPrime {
  private val primes: Stream[Int] = Stream.cons[Int](2, getNextPrimes(1))

  private def isPrime(n: Int) =
    primes.takeWhile(_ <= math.sqrt(n)).forall(n % _ != 0)

  private def getNextPrimes(prime: Int): Stream[Int] =
    Stream.iterate(prime + 2)(_ + 2).filter(isPrime)

  def prime(n: Int): Option[Int] = n match {
    case 0 => None
    case 1 => Some(2)
    case _ => primes.drop(n - 1).headOption
  }
}