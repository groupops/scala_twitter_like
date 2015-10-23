import scala.io.Source

object Reader {

  val ROOT_DIR = "users\\"
  var usersAsString = Set[String]()
  var users = Set[User]()

  def readFollowed(): Set[User] = {
    usersAsString = io.Source.fromFile(ROOT_DIR + "users.properties").getLines().toSet
    users = (usersAsString map (new User(_)))
    users
  }

  def readAllMessagesFor(username: String) = {
    val followed = io.Source.fromFile(ROOT_DIR + username + "\\" + "followed.properties").getLines().toList
    followed.foreach(showMessages)
  }

  def showMessages(username: String) = {
    val files = new java.io.File(ROOT_DIR + username + "\\").listFiles
    files.toIterator
      .flatMap(Source fromFile _ getLines())
      .foreach(println)
  }

}
