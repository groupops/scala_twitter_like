package twitter.CommandHandlers

import java.io.PrintStream

import twitter.messaging.{FileUserService, FileFollowersService, FollowersService}

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object FollowUserCommandHandler extends CommandHandler {

  override def handleCommand(username: String, output: PrintStream, params: Map[String, String]): Boolean = {
    val followers: FollowersService = FileFollowersService;
    val toBeFollowedUsername: String = params.getOrElse("username", "")
    FileUserService.isUsernameValid(username, true)
    FileUserService.isUsernameValid(toBeFollowedUsername, true)
    followers.follow(username, toBeFollowedUsername)
    output.println("You have followed : " + toBeFollowedUsername)
    return true
  }
}
