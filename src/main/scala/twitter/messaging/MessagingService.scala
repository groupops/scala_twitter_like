package twitter.messaging

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
trait MessagingService {
  def writeMessage(username: String, message: String, receivers: Set[String])
  def readMessage(username: String, messageId: String)
  def getMessagesForUser(): List[(String, String, String)]
  def getMessagesByUser: List[(String, String)]
  def getMessageReceivedById(id: String): (String, String)
}
