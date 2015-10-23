package twitter.messaging

import java.io.{PrintWriter, File}
import scala.collection
import scala.collection.mutable

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 22.10.15.
 */
object FileFollowersService extends FollowersService {

  // Key = followed username, Value = set of followers usernames
  private val followers: mutable.Map[String, mutable.Set[String]] = new mutable.HashMap[String, mutable.Set[String]]()

  // Key = username, Value = set of usernames whom he is following
  private val following: mutable.Map[String, mutable.Set[String]] = new mutable.HashMap[String, mutable.Set[String]]()

  private val FOLLOWERS_FILE_PATH: String = "data/followers.csv"
  private var fileLoaded: Boolean = false
  loadFollowersFile // load the file on startup

  private def loadFollowersFile = {
    if (!fileLoaded) {
      fileLoaded = true
      import scala.io.Source
      for(line <- Source.fromFile(new File(FOLLOWERS_FILE_PATH)).getLines()) {
        if (line != "") {
          val userAndFollowers: Array[String] = line.split("=")
          userAndFollowers(1).split(",").foreach{ (followedUser: String) =>
            populateFollowersAndFollowing(userAndFollowers(0), followedUser)
          }
        }

      }
    }
  }




  override def follow(username: String, toBeFollowedUser: String): Unit = {
    populateFollowersAndFollowing(username, toBeFollowedUser)
    // update file
    updateFollowersFile
  }

  private def populateFollowersAndFollowing(username: String, followedUser: String) = {
    // populate followers
    var userFollower: mutable.Set[String] = null
    userFollower = followers.get(followedUser).getOrElse{
      userFollower = new mutable.HashSet[String]()
      followers.put(followedUser, userFollower)
      userFollower
    }
    userFollower += username

    // populate following
    var userFollowing: mutable.Set[String] = null
    userFollowing = following.get(username).getOrElse{
      userFollowing = new mutable.HashSet[String]()
      following.put(username, userFollowing)
      userFollowing
    }
    userFollowing += followedUser
  }


  override def unfollow(username: String, toBeUnfollowedUser: String): Unit = {
    // check if username is already following toBeUnfollowedUser
    // if not then just do nothing (idempotent)
    if (followers.contains(toBeUnfollowedUser) && followers.get(toBeUnfollowedUser).contains(username)) {
      // populate followers
      var userFollower: mutable.Set[String] = null
      userFollower = followers.get(toBeUnfollowedUser).getOrElse {
        throw new IllegalStateException("It seems that there is an error in the the followers data please reload the application")
      }
      userFollower -= username

      // populate following
      var userFollowing: mutable.Set[String] = null
      userFollowing = following.get(username).getOrElse {
        throw new IllegalStateException("It seems that there is an error in the the followers data please reload the application")
      }
      userFollowing -= toBeUnfollowedUser

      // update file
      updateFollowersFile
    }
  }

  private def updateFollowersFile = {
    val printWriter: PrintWriter = new PrintWriter(FOLLOWERS_FILE_PATH)
    try {
      val followingAccumulator: StringBuilder = new StringBuilder()
      following.foreach {
        (entry: (String, mutable.Set[String])) => {
          val user: String = entry._1
          val followingUsers: mutable.Set[String] = entry._2
          followingAccumulator ++= user
          followingAccumulator ++= "="
          followingAccumulator ++= followingUsers.mkString(",")
          followingAccumulator ++= "\n"
          printWriter.write(followingAccumulator.toString())
          followingAccumulator.clear()
        }
      }
    } finally {
      printWriter.close
    }
  }

  override def getFollowers(username: String): collection.Set[String] = {
    return followers.getOrElse(username, Set.empty)
  }

  override def getFollowing(username: String): collection.Set[String] = {
    return following.getOrElse(username, Set.empty)
  }
}
