object Bob {
  def response(statement: String): String = statement.trim match {
    case x if x.isEmpty =>
      "Fine. Be that way!"

    case x if x == x.toUpperCase && x != x.toLowerCase =>
      if (x.endsWith("?")) "Calm down, I know what I'm doing!"
      else "Whoa, chill out!"

    case x if x.endsWith("?") =>
      "Sure."

    case _ =>
      "Whatever."
  }
}
