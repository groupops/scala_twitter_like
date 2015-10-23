package twitter.CommandHandlers

import java.io.PrintStream

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object QuitCommandHandler extends CommandHandler {

  override def handleCommand(username: String, output: PrintStream, params: Map[String, String]): Boolean = {
    output.println("Good bye " + username)
    return false
  }
}
