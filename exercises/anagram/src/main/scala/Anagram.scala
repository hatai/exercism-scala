object Anagram {
  def findAnagrams(word: String, words: List[String]): List[String] = {
    val sorted = sortString(word)
    words.filter((p) => p != word && sortString(p) == sorted)
  }

  private def sortString(str: String): String =
    if (str.toUpperCase == str) {
      // when str is capital word
      str.sorted
    } else {
      str.toLowerCase.sorted
    }
}