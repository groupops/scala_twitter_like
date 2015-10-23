package twitter.CommandHandlers

import java.io.PrintStream

import twitter.messaging.{FileUserService, FileFollowersService, FollowersService}

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object ListFollowingCommandHandler extends CommandHandler {

  override def handleCommand(username: String, output: PrintStream, params: Map[String, String]): Boolean = {
    val followers: FollowersService = FileFollowersService;
    FileUserService.isUsernameValid(username, true)
    output.println("Users that you are following:")
    output.println(followers.getFollowing(username))
    return true
  }
}
