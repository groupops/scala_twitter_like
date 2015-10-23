package twitter.CommandHandlers

import java.io.PrintStream

import twitter.messaging.{FileUserService, FileFollowersService, FollowersService}

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object UnFollowUserCommandHandler extends CommandHandler {

  override def handleCommand(username: String, output: PrintStream, params: Map[String, String]): Boolean = {
    val followers: FollowersService = FileFollowersService;
    val toBeUnFollowedUsername: String = params.getOrElse("username", "")
    FileUserService.isUsernameValid(username, true)
    FileUserService.isUsernameValid(toBeUnFollowedUsername, true)
    followers.unfollow(username, toBeUnFollowedUsername)
    output.println("You have unfollowed : " + toBeUnFollowedUsername)
    return true
  }
}
