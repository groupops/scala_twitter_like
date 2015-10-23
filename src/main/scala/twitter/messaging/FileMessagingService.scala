package twitter.messaging

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object FileMessagingService extends MessagingService {
  override def writeMessage(username: String, message: String, receivers: Set[String]): Unit = ???

  override def readMessage(username: String, messageId: String): Unit = ???

  override def getMessagesByUser: List[(String, String)] = ???

  override def getMessageReceivedById(id: String): (String, String) = ???

  override def getMessagesForUser(): List[(String, String, String)] = ???
}
