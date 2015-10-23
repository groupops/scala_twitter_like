package twitter

import scala.collection.mutable.ListBuffer

class User(val name: String, val followers: ListBuffer[User]) {
  var postedMessages = new ListBuffer[Message]()
  var feeds = new ListBuffer[Message]()

  def this(name: String) {
    this(name, new ListBuffer[User]())
  }

  def postMessage(twit: String): Unit = {
    def message = new Message(this, twit)
    postedMessages += message
    notifyFollowers(message)
  }

  private def notifyFollowers(message: Message): Unit = {
    followers.foreach(follower =>
      follower.feeds += message
    )
  }

  def addFollower(follower: User): Unit = {
    followers += follower
  }

  def followFor(user: User): Unit = {
    user.addFollower(this)
  }

  def stopFollowing(user: User): Unit = {
    user.removeFollower(this)
  }

  def removeFollower(follower: User): Unit = {
    followers -= follower
  }

  def readFeeds(): List[Message] = {
    feeds.toList
  }
}
