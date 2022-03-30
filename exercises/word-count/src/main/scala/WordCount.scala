case class WordCount(var word: String) {
  type Counter = Map[String, Int]


  def countWords: Counter = {
    var counter: Counter = Map()
    this.word
      .toLowerCase
      .replaceAll("[^\\w']", " ")
      .split(" ")
      .filter(e => !e.isBlank)
      .foreach(e => {
        val el = e.replaceFirst("^'", "").replaceFirst("'$", "")
        counter get el match {
          case Some(x) => counter += (el -> (x + 1))
          case None => counter += (el -> 1)
        }
      })

    counter
  }
}