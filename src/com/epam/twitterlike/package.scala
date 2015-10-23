package com.epam

package object twitterlike {

  val userRepository = new UserRepository
  val messageRepository = new MessageRepository

  // TODO: Implement followers, console or web interface
  def main (args: Array[String]) {

    val user = userRepository.save("Goose")
    messageRepository.add(user, "Greeting", "Hello")
    messageRepository.add(user, "Greeting", "I'm going to work")
    messageRepository.add(user, "Greeting", "I wona rock after the work")

/*    userRepository.getAll.foreach { println(_) }
    messageRepository.getAll.foreach { println(_) }*/

    println(userRepository.getOne(user.getName).getBlog)
  }
}
