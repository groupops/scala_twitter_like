package com.epam.training.scala

import scala.collection.mutable.ListBuffer


class User(name: String, followers: ListBuffer[User]) {
  var postedMessages = new ListBuffer[Message]()

  def this(name: String) {
    this(name, List[String])
  }

  def postMessage(message: Message): Unit = {
    postedMessages += message
  }

  private def notifyFollowers(): Unit ={

  }

  def followFor(user: User): Unit = {
    followers.+=(user)
  }
}

object User {

}
