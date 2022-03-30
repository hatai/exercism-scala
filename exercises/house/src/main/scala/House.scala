object House {
  def recite(start: Int, end: Int): String = {
    (start to end).map(phrase).mkString + "\n"
  }

  private def phrase(start: Int): String = {
    s"This ${(start to 1 by -1).map(x => s"${verb(x, start)} ${subject(x)}").mkString(" that ")}.\n"
  }

  private def verb(n: Int, start: Int): String = n match {
    case x if x == start => "is"
    case 1 => "lay in"
    case 2 => "ate"
    case 3 => "killed"
    case 4 => "worried"
    case 5 => "tossed"
    case 6 => "milked"
    case 7 => "kissed"
    case 8 => "married"
    case 9 => "woke"
    case 10 => "kept"
    case 11 => "belonged to"
    case _ => ""
  }

  private def subject(n: Int): String = n match {
    case 1 => "the house that Jack built"
    case 2 => "the malt"
    case 3 => "the rat"
    case 4 => "the cat"
    case 5 => "the dog"
    case 6 => "the cow with the crumpled horn"
    case 7 => "the maiden all forlorn"
    case 8 => "the man all tattered and torn"
    case 9 => "the priest all shaven and shorn"
    case 10 => "the rooster that crowed in the morn"
    case 11 => "the farmer sowing his corn"
    case 12 => "the horse and the hound and the horn"
    case _ => ""
  }
}