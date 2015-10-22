package com.epam.twitterlike

import java.io.{PrintWriter, FileWriter}

class MessageRepository {

  def add(message: Message) {
    val path = message.getUser.getName + "Wall.txt"
    val messageFile = new FileWriter(path, true)
    val writer = new PrintWriter(messageFile)

    writer.println(message.getUser.getName.toString)
    writer.println(message.getTittle)
    writer.println(message.getText + "\n")
    writer.flush()
  }
}
