import scala.collection.SortedMap

class School() {
  type DB = Map[Int, Seq[String]]

  var data: DB = Map()

  def add(name: String, g: Int): Unit = {
    this.data += (g -> (this.grade(g) :+ name))
  }

  def db: DB = this.data

  def grade(g: Int): Seq[String] = this.data getOrElse(g, Seq())

  def sorted: DB = SortedMap(this.data.mapValues(e => e.sorted).toSeq: _*).toMap
}