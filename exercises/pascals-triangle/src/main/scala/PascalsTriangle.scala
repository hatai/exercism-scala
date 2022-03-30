object PascalsTriangle {
  private val triangles = Stream.iterate(Vector(1))(next).map(_.toList)

  private def next(prev: Vector[Int]): Vector[Int] = {
    (0 +: prev) zip (prev :+ 0) map { case (l, r) => l + r }
  }

  def rows(n: Int): List[List[Int]] = (triangles take n).toList
}