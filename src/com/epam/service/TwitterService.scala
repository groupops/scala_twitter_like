package com.epam.service

import com.epam.io.FileOperation

class TwitterService {
    val MY_USERNAME = "Alex"
    
    def getAllUsers(): List[String] = List("Dima", "Mateusz", "Adam", "Yaroslav")
    
    def followUser(userName:String) {
        val fileOperation = new FileOperation()
        var relations = fileOperation.readRelations()
        
        relations = relations.::(MY_USERNAME + " -> " + userName + "\n")
        
        fileOperation.writeRelations(relations)
    }
}