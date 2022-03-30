import java.time.temporal.TemporalAdjusters.{dayOfWeekInMonth, lastInMonth, nextOrSame}
import java.time.{DayOfWeek, LocalDate}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {
  private val startOfMonth = LocalDate.of(year, month, 1)

  def day(dayOfWeek: DayOfWeek, schedule: Schedule): LocalDate =
    schedule match {
      case Schedule.Teenth => startOfMonth.withDayOfMonth(13).`with`(nextOrSame(dayOfWeek))
      case Schedule.Last => startOfMonth.`with`(lastInMonth(dayOfWeek))
      case _ => startOfMonth.`with`(dayOfWeekInMonth(schedule.id, dayOfWeek))
    }

}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon: DayOfWeek = DayOfWeek.MONDAY
  val Tue: DayOfWeek = DayOfWeek.TUESDAY
  val Wed: DayOfWeek = DayOfWeek.WEDNESDAY
  val Thu: DayOfWeek = DayOfWeek.THURSDAY
  val Fri: DayOfWeek = DayOfWeek.FRIDAY
  val Sat: DayOfWeek = DayOfWeek.SATURDAY
  val Sun: DayOfWeek = DayOfWeek.SUNDAY
}
