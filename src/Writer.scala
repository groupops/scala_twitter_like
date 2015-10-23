import java.io.{FileWriter, PrintWriter}
import java.nio.file.{Paths, Files}

object Writer {

  val ROOT_DIR = "users\\"

  def directoryExists(path: String) = Files.isDirectory(Paths.get(path))

  def createUsersDirectory(path: String) = Files.createDirectory(Paths.get(path))

  def createUsersList(path: String) = new PrintWriter(path) {
    close()
  }

  def save(user: User) = new FileWriter(ROOT_DIR + "users.properties", true) {
    write(user.username + System.lineSeparator())
    close()
  }

  def saveFollowed(username: String, followed: String) = new FileWriter(ROOT_DIR + username + "\\" + "followed.properties", true) {
    write(followed + System.lineSeparator())
    close()
  }

  def writeMessage(message: Message, username: String) = {
    new PrintWriter(ROOT_DIR + username + "\\" + message.title + ".txt") {
      write(message.getMessage())
      close()
    }
  }

}
