package com.epam.twitterlike

import scala.collection.mutable.ListBuffer

class Blog(var messages: ListBuffer[Message]) {

  def addMessage(message: Message) {
    messages += message
  }

  def get() = messages

  override def toString: String = {
    val builder = new StringBuilder("User: " + messages.head.getUser.getName + "\n")
    for (message <- messages) {
      builder.append("Title: " + message.getTittle + "\n")
      builder.append("Message: " + message.getText + "\n\n")
    }
    builder.toString()
  }
}
