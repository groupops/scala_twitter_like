package com.epam.twitterlike

import java.io.{File, PrintWriter, FileWriter}

class UserRepository {

  var file = new FileWriter("Users.txt", true)
  val writer = new PrintWriter(file)

  def save(user: User) {
    writer.println(user.getName.toString)
    writer.flush()
    createWall(user.getName)
  }

  def addFollower(leader: User, follower: User) {
    writer.println("User " + leader.getName + " started to followe:" + follower.getName)
    writer.flush()
  }

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

  private def createWall(prefix: String) {
    new File(prefix + "Wall.txt").createNewFile()
  }
}
