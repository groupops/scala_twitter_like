package twitter.messaging

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
trait FollowersService {
  def getFollowers(username: String): collection.Set[String]
  def getFollowing(username: String): collection.Set[String]
  def follow(username: String, toBeFollowedUser: String)
  def unfollow(username: String, toBeUnfollowedUser: String)
}
