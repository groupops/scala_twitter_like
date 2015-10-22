import scala.io.Source
import com.epam.service.TwitterService

object App {
    def main(args: Array[String]) {
        val service = new TwitterService()
        val users = service.followUser(service.getAllUsers()(0))
    }
}