package twitter

import twitter.CommandHandlers._

class ConsoleCommand(val shortcut: String, val message: String, val params: Array[(String, String)], val commandHandler: CommandHandler) {}

/**
  * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object ConsoleCommand {

  def apply(shortcut: String, message: String, params: Array[(String, String)], commandHandler: CommandHandler): ConsoleCommand = {
    new ConsoleCommand(shortcut, message, params, commandHandler)
  }

  //type ConsoleCommand = Value

  val Quit = ConsoleCommand(
      "qt",
      "qt: Quit the application",
      Array(),
      QuitCommandHandler
  )

  val ReadNewsFeed = ConsoleCommand(
      "rd",
      "rd: Read messages targeted to me",
      Array(),
      ReadNewsFeedCommandHandler
  )

  val WriteMessage = ConsoleCommand(
      "wt",
      "wt: Write a tweet on your timeline/wall, which will be sent to all your followers",
      Array(("tweet", "Please write your tweet")),
      WriteMessageCommandHandler
  )

  val ListUsers = ConsoleCommand(
      "lu",
      "lu: List all users on the system",
      Array(),
      ListUsersCommandHandler
  )

  val FollowUser = ConsoleCommand(
      "fl",
      "fl: Follow a user by his username",
      Array(("username", "Please write the username of the person you want to follow")),
      FollowUserCommandHandler
  )

  val UnFollowUser = ConsoleCommand(
      "uf",
      "uf: Unfollow a user that I am already following",
      Array(("username", "Please write your username of the person you want to unfollow")),
      UnFollowUserCommandHandler
  )

  val ListFollowers = ConsoleCommand(
      "fr",
      "fr: List users who are following me",
      Array(),
      ListFollowersCommandHandler
  )

  val ListFollowing = ConsoleCommand(
      "fg",
      "fg: List users that I am following ",
      Array(),
      ListFollowingCommandHandler
  )


  val values = Seq(Quit, ReadNewsFeed, WriteMessage, ListUsers, FollowUser, UnFollowUser, ListFollowers, ListFollowing)

//  def name(command:ConsoleCommand) = command match {
//    case ConsoleCommand.Quit => "Quit"
//    case ConsoleCommand.ReadNewsFeed => "Read your News Feed"
//    case ConsoleCommand.WriteMessage => "Write Message"
//    case ConsoleCommand.ListUsers => "List Users"
//    case ConsoleCommand.FollowUser => "Follow User"
//    case ConsoleCommand.UnFollowUser => "Unfollow User"
//    case ConsoleCommand.ListFollowers => "List Followers"
//    case ConsoleCommand.ListFollowing => "List Following"
//  }

  def findByShortcut(shortcut: String): ConsoleCommand = {
    val valueSet = ConsoleCommand.values.filter(
      (cmd: ConsoleCommand) => (cmd.shortcut == shortcut)
    )
    if (!valueSet.isEmpty) {

      return valueSet.toList(0)
    } else {
      throw new IllegalArgumentException("Invalid Command shortcut: " + shortcut)
    }
  }

}
