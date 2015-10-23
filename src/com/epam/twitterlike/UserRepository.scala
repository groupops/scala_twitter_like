package com.epam.twitterlike

import scala.collection.mutable.ListBuffer

class UserRepository {

  var users: Map[String, User] = Map()

  def save(name: String): User = {
    val blog = new Blog(ListBuffer[Message]())
    val user = new User(name, blog)
    users = users.++(Map(name -> user))
    user
  }

  def getOne (key: String) = users.apply(key)
  def getAll = users
}
