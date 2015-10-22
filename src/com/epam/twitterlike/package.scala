package com.epam

import scala.io.Source

/*
* 1 Create User
* 2 User must have Wall
* 3 Users can follow each other
* 4 User should receive messages of followed users
* */

package object twitterlike {


  val users = List[User](
                          new User(1, "Goose", List.empty),
                          new User(2, "Duck", List.empty),
                          new User(3, "Fox", List.empty))
  val userRepository = new UserRepository

  def main (args: Array[String]) {

    //Source.fromFile("Language.java")

    userRepository.save(users)
  }

  def add(message: Message) {

  }
}
