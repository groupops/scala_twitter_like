import java.io.{PrintWriter, FileWriter}

object Writer {

  val ROOT_DIR = "users\\"

  def writeMessage(message: Message, username: String) = {
    new PrintWriter(ROOT_DIR + username + "\\" + message.title + ".txt") {
      write(message.getMessage())
      close()
    }
  }

  def writeFollowed(username: String, followed: String) = new FileWriter(ROOT_DIR + username + "\\" + username + ".properties", true) {
    write(followed + System.lineSeparator())
    close()
  }
}
