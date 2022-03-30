import scala.collection.mutable
import scala.util.{Random => RandomSystem}
import java.util.Calendar

class Robot {
  var name: String = RobotNames.names.next()

  def reset(): Unit = name = RobotNames.names.next()
}

class NameHistory {
  private val hash = new mutable.HashSet[String]

  def contains(elem: String): Boolean = hash.contains(elem)

  def remember(name: String): String = {
    hash.add(name)
    name
  }
}

object Random {
  private val rand = new RandomSystem(Calendar.getInstance().getTimeInMillis)

  def choice(collection: Seq[Char]): Char = collection(
    rand.nextInt(collection.length)
  )
}

object RobotNames {
  private val digit = ('0' to '9').toArray
  private val letter = ('A' to 'Z').toArray
  private val spec = List(letter, letter, digit, digit, digit)

  private val history = new NameHistory

  def generateName: String = spec.map(Random.choice(_)).mkString

  val names: Iterator[String] = Iterator
    .continually(generateName)
    .filterNot(history.contains)
    .map(history.remember)
}
