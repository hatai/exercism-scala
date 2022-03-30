object CollatzConjecture {
  def steps(num: Int, count: Int = 0): Option[Int] = num match {
    case x if x < 1 => None
    case x if x == 1 => Some(count)
    case x if x % 2 == 0 => steps(x >> 1, count + 1)
    case x => steps(x * 3 + 1, count + 1)
  }
}
