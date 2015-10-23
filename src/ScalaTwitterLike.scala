import java.nio.file.{Files, Paths}

class ScalaTwitterLike {

  val ROOT_DIR = "users\\"
  var username = ""
  var users = new UserRepository

  def run(): Unit = {
    initApp()
    joinAs(getUsername)
    showCommands()
    handleCommands()
  }

  def initApp(): Unit = {
    print("Welcome to SCALA TWITTER LIKE")
    prepareFileStorage()
    users.initRepository()
  }

  def joinAs(username: String): Unit = {
    if (!Files.isDirectory(Paths.get(ROOT_DIR + username))) {
      Files.createDirectory(Paths.get(ROOT_DIR + username))
      println("User account created")
    }
    this.username = username
    println("Logged as: " + this.username)
    users.addUser(new User(username))
  }

  def showCommands(): Unit = {
    println("Commands:")
    println("[F] follow user")
    println("[P] publish message")
    println("[R] read all messages")
    println("[Q] quit application")
  }

  def handleCommands(): Unit = {
    while (true) {
      val key = getUserInput
      key match {
        case "F" => follow()
        case "P" => publish()
        case "R" => readAll()
        case "Q" => quitApp()
        case _ => incorrectCommand()
      }
    }
  }

  private def prepareFileStorage() = {
    if (!Writer.directoryExists(ROOT_DIR)) {
      Writer.createUsersDirectory(ROOT_DIR)
      Writer.createUsersList(ROOT_DIR + "users.properties")
    }
  }

  private def follow(): Unit = {
    print("Specify user: ")
    val user = new User(getUserInput)
    if (users.findUser(user.username)) {
      Writer.saveFollowed(username, user.username)
      println("User " + user.username + " added to followed")
    } else {
      println("Unknown user")
    }
  }

  private def publish(): Unit = {
    print("title: ")
    val title = getUserInput
    print("message: ")
    val content = getUserInput
    val message = new Message(title, content)
    Writer.writeMessage(message, username)
    println()
    println(message.getMessage())
    println()
  }

  private def readAll(): Unit = {
    Reader.readAllMessagesFor(username)
  }

  private def quitApp(): Unit = {
    System.exit(0)
  }

  private def incorrectCommand(): Unit = {
    println("Incorrect command")
  }

  private def getUsername: String = {
    println()
    print("Login as: ")
    getUserInput
  }

  private def getUserInput: String = {
    io.StdIn.readLine()
  }

}