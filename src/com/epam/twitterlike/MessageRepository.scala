package com.epam.twitterlike

import scala.collection.mutable.ListBuffer

class MessageRepository {

  var messages = new ListBuffer[Message]

  def add(user: User, tittle: String, test: String)  {
    val message = new Message(user, tittle, test)
    user.getBlog.addMessage(message)
    messages += message
  }

  def getOne(tittle: Int) = messages.apply(tittle)
  def getAll = messages
}
