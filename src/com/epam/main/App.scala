import scala.io.Source
import com.epam.service.TwitterService

import com.epam.io.FileOperation
import com.epam.service.MessageProcessor

object App {
    def main(args: Array[String]) {
        val fileOperation = new FileOperation()
        val messageProcessor = new MessageProcessor(fileOperation)
        
        val service = new TwitterService(messageProcessor)
        val users = service.followUser(service.getAllUsers()(0))
        
        //TODO: implement other operations
    }
}