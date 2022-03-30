object Isogram {
  def isIsogram(str: String): Boolean = {
    val chars = str.filter(_.isLetter).map(_.toLower)
    chars.toSet.size == chars.length
  }
}