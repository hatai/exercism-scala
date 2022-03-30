class Clock {
  var minutes = 0

  def this(mins: Int) = {
    this()

    this.minutes = if (mins < 0) {
      (24 * 60) + (mins % (24 * 60))
    } else {
      mins % (24 * 60)
    }
  }

  def this(hrs: Int, mins: Int) = {
    this(
      if (hrs < 0) {
        (24 + hrs % 24) * 60 + mins
      } else {
        (hrs % 24) * 60 + mins
      }
    )
  }

  override def equals(obj: Any): Boolean = obj match {
    case x: Clock => this.minutes == x.minutes
    case _ => false
  }

  def +(that: Clock) = Clock(0, this.minutes + that.minutes)

  def -(that: Clock) = Clock(0, this.minutes - that.minutes)

}

object Clock {
  def apply(minute: Int): Clock = new Clock(0, minute)

  def apply(hour: Int, minute: Int): Clock = new Clock(hour, minute)
}