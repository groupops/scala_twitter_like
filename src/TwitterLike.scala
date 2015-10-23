import java.io.PrintWriter
import java.nio.file.{Files, Paths}

class TwitterLike {

  val ROOT_DIR = "users\\"
  var username = ""
  val followed = scala.collection.mutable.Set[User]()

  def run(): Unit = {
    if (!Files.isDirectory(Paths.get(ROOT_DIR)))
      Files.createDirectory(Paths.get(ROOT_DIR))
    var username = getUsername()
    joinAs(username)
    println("Actions:")
    println("[F] follow user")
    println("[P] publish message")
    println("[R] read all messages")
    while(true) {
      val key = io.StdIn.readLine()
      doAction(key)
    }
  }

  def doAction(key: String): Unit = {
    key match {
      case "F" => follow()
      case "P" => publish()
      case "R" => readAll()
      case _  => incorrectAction()
    }
  }

  def getUsername(): String = {
    println()
    print("Login as: ")
    io.StdIn.readLine()
  }

  def joinAs(username: String): Unit = {
    if (!Files.isDirectory(Paths.get(ROOT_DIR + username))){
      Files.createDirectory(Paths.get(ROOT_DIR + username))
      print("User account created")
    }
    this.username = username
    println("Logged as: " + this.username)
    new User(username)
  }

  def follow(): Unit = {
    print("Specify user: ")
    var user = io.StdIn.readLine()
    followed += new User(user)
  }

  def publish(): Unit = {
    print("title: ")
    val title = io.StdIn.readLine()
    print("message: ")
    val content = io.StdIn.readLine()
    val message = new Message(title, content)
    new PrintWriter(ROOT_DIR + this.username + "\\" + message.title + ".txt") {
      write(message.getMessage());
      close
    }
    println
    println(message.getMessage())
    println
  }

  def readAll(): Unit = {
    for (username <- followed) println(username.toString)
  }

  def incorrectAction(): Unit = {
    println("Incorrect action")
  }

}
