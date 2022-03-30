object Pangrams {
  private final val alphabets = ('a' to 'z').length

  def isPangram(input: String): Boolean = {
    input.filter(_.isLetter).map(_.toLower).toSet.size == alphabets
  }
}

