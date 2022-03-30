object Darts {
  def score(x: Double, y: Double): Int = {
    Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) match {
      case n if n > 10 => 0
      case n if n <= 10 && n > 5 => 1
      case n if n <= 5 && n > 1 => 5
      case _ => 10
    }
  }
}
