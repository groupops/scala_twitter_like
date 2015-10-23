package twitter

class Message(author: User, text: String) {

  override def toString = {
    author.name + " posted a message :\n" + text +"\n"
  }
}

