package twitter.messaging

import java.io._

import scala.collection.immutable.{HashMap, HashSet}

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object FileUserService extends UsersService {
  private var users: Set[String] = new HashSet[String]()
  private val USERS_FILE_PATH: String = "data/users.csv"
  private var loggedInUsername: String = null
  private var fileLoaded: Boolean = false
  loadUserFile // load user file on startup

  private def loadUserFile = {
    if (!fileLoaded) {
      fileLoaded = true
      import scala.io.Source
      for(line <- Source.fromFile(new File(USERS_FILE_PATH)).getLines()) {
        if (line != "") users += line;
      }
    }
  }

  override def getUsers: Set[String] = {
    users
  }

  override def registerAndLoginUser(username: String) = {
    users += username.toLowerCase()
    loggedInUsername = username

    val printWriter: PrintWriter = new PrintWriter(USERS_FILE_PATH)
    try {
      users.foreach { (user: String) => printWriter.write(user + "\n") }
    } finally {
      printWriter.close
    }
  }

  override def userExists(username: String) = {
    users.contains(username.toLowerCase())
  }

  override def getLoggedInUsername: Option[String] = {
    if (loggedInUsername == null)
      None
    else
      Some(loggedInUsername)
  }


  override def isUsernameValid(username: String, throwException: Boolean=false): Boolean = {
    var result: Boolean = false
    if (username != None && username != "")
    result = true
    if (!result && throwInvalidUsername)
    throwInvalidUsername
    return result
  }

  private def throwInvalidUsername = {
    throw new IllegalArgumentException("Invalid username, the username of the user is either invalid or not in DB.")
  }

}
