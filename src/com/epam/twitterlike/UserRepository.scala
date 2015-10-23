package com.epam.twitterlike

import java.io.{File, FileWriter, PrintWriter}

class UserRepository {

  var file = new FileWriter("Users.txt", true)
  val writer = new PrintWriter(file)

  /*
  * Used for manually adding bunch of users
  * */
  @Deprecated
  def save(users: List[User]) {
    for (user <- users) {
      save(user)
      createWall(user.getName)
    }
  }

  def save(user: User) {
    writer.println(user.getId.toString)
    writer.println(user.getName.toString)
    writer.flush()
    createWall(user.getName)
  }

  private def createWall(prefix: String) {
    new File(prefix + "Wall.txt").createNewFile()
  }
}
