package twitter.CommandHandlers

import java.io.PrintStream

import twitter.messaging.FileUserService

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object ListUsersCommandHandler extends CommandHandler {

  override def handleCommand(username: String, output: PrintStream, params: Map[String, String]): Boolean = {
    FileUserService.getUsers.foreach{ (user: String) =>
      output.println("\t# " + user)
    }
    return true
  }
}
