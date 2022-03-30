object FoodChain {
  def recite(start: Int, end: Int): String = {
    (start to end).map(e => {
      List(
        s"I know an old lady who swallowed a ${swallowed(e)}.",
        secondLine(e),
        otherLine(e),
        lastLine(e)
      ).filter(_ != "").mkString("\n")
    }).mkString("\n\n") + "\n\n"
  }

  private def swallowed(n: Int): String = n match {
    case 1 => "fly"
    case 2 => "spider"
    case 3 => "bird"
    case 4 => "cat"
    case 5 => "dog"
    case 6 => "goat"
    case 7 => "cow"
    case 8 => "horse"
    case _ => ""
  }

  private def secondLine(n: Int): String = n match {
    case 2 => s"It wriggled and jiggled and tickled inside her."
    case 3 => s"How absurd to swallow a ${swallowed(n)}!"
    case 4 => s"Imagine that, to swallow a ${swallowed(n)}!"
    case 5 => s"What a hog, to swallow a ${swallowed(n)}!"
    case 6 => s"Just opened her throat and swallowed a ${swallowed(n)}!"
    case 7 => s"I don't know how she swallowed a ${swallowed(n)}!"
    case _ => s""
  }

  private def lastLine(n: Int): String = n match {
    case 8 => "She's dead, of course!"
    case _ => "I don't know why she swallowed the fly. Perhaps she'll die."
  }

  private def otherLine(n: Int): String = n match {
    case 1 => ""
    case 8 => ""
    case _ => (n to 2 by -1).map(e => {
      var str = s"She swallowed the ${swallowed(e)} to catch the ${swallowed(e - 1)}"
      if (e - 1 == 2) {
        str += " that wriggled and jiggled and tickled inside her"
      }
      s"$str."
    }).mkString("\n")
  }
}