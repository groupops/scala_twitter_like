package twitter

import java.io.{InputStream, PrintStream}
import java.util.Scanner
import twitter.ConsoleCommand._

import scala.collection.mutable

class ConsoleHandler(private val username: String, private val output: PrintStream, private val inputStream: InputStream) {
  var inputScanner: Scanner = new Scanner(inputStream)

  def printAllowedCommands = {
    ConsoleCommand.values.foreach{ (cmd: ConsoleCommand) =>
      output.println("\t- " + cmd.message)
    }
    output.println("Hi " + username)
    output.print("Please select one of these commands by writing the 2 letters short cut of the command and pressing Enter/Return: ")
  }

  def readComand: Boolean = {
    val commandShortCut = inputScanner.next()
    val cmd: ConsoleCommand = ConsoleCommand.findByShortcut(commandShortCut)
    if (cmd != None) {
      output.println("Executing ...... " + cmd.shortcut)
      val paramsValues: mutable.Map[String, String] = new mutable.HashMap[String, String]()
      cmd.params.foreach { (param: (String, String)) =>
        output.print(param._2 + " : ")
        paramsValues.put(param._1, inputScanner.next())
      }
      output.println("...............................................")
      return cmd.commandHandler.handleCommand(username, output, paramsValues.toMap)
    }
    output.println("Please try again.")
    return true
  }
}

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object ConsoleHandler{

  def apply(username: String, printStream: PrintStream, inputStream: InputStream) : ConsoleHandler = {
    return new ConsoleHandler(username: String, printStream, inputStream)
  }

}
