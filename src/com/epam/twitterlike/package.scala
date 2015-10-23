package com.epam

import java.io.{PrintWriter, FileWriter}


import scala.io.Source

/*
* 1 Create User
* 2 User must have Wall
* 3 Users can follow each other
* 4 User should receive messages of followed users
* */

package object twitterlike {
  
  val users = List[User] (
      new User("Goose"),
      new User("Duck"),
      new User("Fox"))

  val messages = List[Message] (
      new Message(users.head, "Greeting", "Hello"),
      new Message(users.head, "Greeting", "I'm going to work"),
      new Message(users.head, "Greeting", "I wona rock after the work")
  )

  val userRepository = new UserRepository
  val messageRepository = new MessageRepository

  def main (args: Array[String]) {

    //Source.fromFile("User.txt")

    userRepository.save(users)

    for (message <- messages) {
      messageRepository.add(message)
    }
  }
}
