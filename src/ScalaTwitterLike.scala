import java.nio.file.{Files, Paths}

class ScalaTwitterLike {

  val ROOT_DIR = "users\\"
  var username = ""
  val followed = scala.collection.mutable.Set[User]()

  def run(): Unit = {
    initApp()
    joinAs(getUsername)
    showCommands()
    handleCommands()
  }

  def joinAs(username: String): Unit = {
    if (!Files.isDirectory(Paths.get(ROOT_DIR + username))) {
      Files.createDirectory(Paths.get(ROOT_DIR + username))
      println("User account created")
    }
    this.username = username
    println("Logged as: " + this.username)
    new User(username)
  }

  def showCommands(): Unit = {
    println("Commands:")
    println("[F] follow user")
    println("[P] publish message")
    println("[R] read all messages")
    println("[Q] quit application")
  }

  def follow(): Unit = {
    print("Specify user: ")
    val user = new User(getUserInput)
    Writer.writeFollowed(username, user.toString())
    println("User " + user + " added to followed")
  }

  def publish(): Unit = {
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

  def readAll(): Unit = {
    Reader.readAllMessagesFor(username)
  }

  def getUserInput: String = {
    io.StdIn.readLine()
  }

  def initApp(): Unit = {
    print("Welcome to SCALA TWITTER LIKE")
    if (!Files.isDirectory(Paths.get(ROOT_DIR)))
      Files.createDirectory(Paths.get(ROOT_DIR))
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

  def getUsername: String = {
    println()
    print("Login as: ")
    getUserInput
  }

  def quitApp(): Unit = {
    System.exit(0)
  }

  def incorrectCommand(): Unit = {
    println("Incorrect command")
  }

}