package twitter.messaging

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
trait UsersService {
  def getUsers: Set[String]
  def registerAndLoginUser(username: String)
  def isUsernameValid(username: String, throwException: Boolean=false): Boolean
  def userExists(username: String)
  def getLoggedInUsername: Option[String]
}
