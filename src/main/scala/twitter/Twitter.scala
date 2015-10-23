package twitter

object Twitter {


  def main(args: Array[String]) ={
    val dima = new User("Dmitriy")
    val alex = new User("Alex")
    var adam = new User("Adam")
    val ahmed = new User("Ahmed")
    val mateusz = new User("Mateusz")

    dima.followFor(alex)
    dima.followFor(ahmed)
    dima.followFor(mateusz)

    alex.postMessage("I've just run my first Scala app!")
    ahmed.postMessage("Incredible! How you did this?")
    alex.postMessage("It was hello word))")
    mateusz.postMessage("Congrats!")

    dima.readFeeds().foreach(message => println(message))
  }

}
