package com.epam.service

import com.epam.model.User

trait Service {
    def getAllUsers(): List[String] {}
    def getSubscribers(userName: String): List[User] {}
    def followUser(userName:String) {}
    def postMessage(message:String) {}
}