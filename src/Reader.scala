import scala.io.Source

object Reader {

  val ROOT_DIR = "users\\"

  def readAllMessagesFor(username: String) = {
    val followed = io.Source.fromFile(ROOT_DIR + username + "\\" + username + ".properties").getLines().toList
    followed.foreach(showMessages)
  }

  def showMessages(username: String) = {
    val files = new java.io.File(ROOT_DIR + username + "\\").listFiles
    files.toIterator
      .flatMap(Source fromFile _ getLines())
      .foreach(println)
  }

}
