case class Triangle(a: Double, b: Double, c: Double) {
  private val sides = List(a, b, c).sorted
  private val isValid = sides.head + sides(1) > sides(2) && a != 0 && b != 0 && c != 0

  def equilateral: Boolean = if (isValid) sides.max == sides.min else false

  def isosceles: Boolean = if (isValid) sides.head == sides(1) || sides(1) == sides(2) else false

  def scalene: Boolean = if (isValid) !isosceles else false
}