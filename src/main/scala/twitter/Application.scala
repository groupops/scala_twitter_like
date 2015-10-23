package twitter

import java.io.{InputStream, PrintStream}
import java.util.Scanner

import twitter.messaging.{FileUserService, UsersService}

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object Application {

  def main(args: Array[String]) {
    val output: PrintStream = System.out
    val input: InputStream = System.in
    val scanner: Scanner = new Scanner(input)

    // get the username
    output.print("\n\nPlease write your username and press enter/return: ")
    val username = scanner.next()
    val usersService: UsersService = FileUserService
    usersService.registerAndLoginUser(username)

    val console: ConsoleHandler = ConsoleHandler(username, output, input)
    var running = true
    while (running) {
      console.printAllowedCommands
      running = console.readComand
    }
    output.println("------------------------------ Finished ------------------------------")
  }
}
