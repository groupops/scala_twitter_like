package com.epam.service

import com.epam.io.FileOperation
import com.epam.model.User

class TwitterService (val messageProcessor: MessageProcessor) extends Service {
    val MY_USERNAME = "Alex"
    val RELATIONS_FILE_NAME = "relations.txt"
    val MY_WALL_NAME = "myWall.txt"
    
    override def getAllUsers(): List[String] = List("Dima", "Mateusz", "Adam", "Yaroslav")
    
    override def getSubscribers(userName:String): List[User] = {
        var mySubscribers = List[User]()
        val relations = messageProcessor.fileOperation.readLinesFromFile(RELATIONS_FILE_NAME)
        // TODO: finish this
        /*relations.foreach { subscriber =>
            val user = new User(subscriber, userName)
            mySubscribers.::(user)
        }*/
        return mySubscribers
    }
    
    override def followUser(userName:String) {
    	//TODO: check in the relationship already exist
        var relations = messageProcessor.fileOperation.readLinesFromFile(RELATIONS_FILE_NAME)
        relations = relations.::(MY_USERNAME + " -> " + userName)
        messageProcessor.fileOperation.writeLinesToFile(RELATIONS_FILE_NAME, relations)
    }
    
    override def postMessage(message:String) {
        messageProcessor.addMessageToWall(MY_WALL_NAME, message)
        var mySubscribers = getSubscribers(MY_USERNAME)
        // TODO: finish this
        /*mySubscribers.foreach { subscriber =>
            messageProcessor.addMessageToWall(subscriber.getWallFileName(), message) 
        }*/
        
    }
}