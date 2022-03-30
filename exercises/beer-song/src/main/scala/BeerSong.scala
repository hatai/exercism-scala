object BeerSong {
  def recite(b: Int, v: Int): String = {
    b to (b - v + 1) by -1 map songVerse mkString "\n"
  }

  private def songVerse(b: Int): String = {
    val secondBeer = if (b == 2) "1 bottle" else s"${b - 1} bottles"

    if (b == 0) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    else if (b == 1) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    else s"$b bottles of beer on the wall, $b bottles of beer.\nTake one down and pass it around, $secondBeer of beer on the wall.\n"
  }
}