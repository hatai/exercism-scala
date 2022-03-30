import scala.annotation.tailrec

object PrimeFactors {
  private val primes: Stream[Long] = Stream.cons[Long](2, getNextPrimes(1))

  private def isPrime(n: Long) =
    primes.takeWhile(_ <= math.sqrt(n)).forall(n % _ != 0)

  private def getNextPrimes(prime: Long): Stream[Long] =
    Stream.iterate(prime + 2)(_ + 2).filter(isPrime)

  @tailrec def factors(num: Long, accu: List[Long] = Nil): List[Long] = num match {
    case 1 => accu.reverse
    case n =>
      val factor = primes.dropWhile(n % _ != 0).head
      factors(n / factor, factor :: accu)
  }
}