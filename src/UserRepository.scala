class UserRepository() {

  var users : Set[User] = Set()

  def initRepository() = {
    users = Reader.readFollowed()
  }

  def getUsers: Set[User] = {
    users
  }

  def addUser(user: User) = {
    users += user
    Writer.save(user)
  }

  def findUser(username: String): Boolean = {
    users.exists(user => user.username == username)
  }

}
