package twitter.CommandHandlers

import java.io.PrintStream

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
trait CommandHandler {
  // handles a command and returns true if it wants to allow other
  // commands to be entered and false if we want to exit the application
  def handleCommand(username: String, output: PrintStream, params: Map[String, String]): Boolean
}
