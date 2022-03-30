import java.time.LocalDate
import java.time.LocalDateTime

object Gigasecond {
  private final val gigaSeconds: Long = 1000000000

  def add(startDate: LocalDate): LocalDateTime = {
    startDate.atTime(0, 0, 0).plusSeconds(gigaSeconds)
  }

  def add(startDateTime: LocalDateTime): LocalDateTime = {
    startDateTime.plusSeconds(gigaSeconds)
  }
}
