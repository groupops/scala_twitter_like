import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Message(val title: String, content: String, dateTime: LocalDateTime) {

  def this(title: String, content: String) = this(title, content, LocalDateTime.now())

  val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm"
  var formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
  def getMessage(): String = dateTime.format(formatter) + "\r\n" + title + "\r\n" + content

}
