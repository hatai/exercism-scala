object ArmstrongNumbers {
  def isArmstrongNumber(n: Int): Boolean = {
    val strNum = String.valueOf(n)
    val len = strNum.length

    strNum.map(e => Math.pow(e - '0', len)).sum == n
  }
}