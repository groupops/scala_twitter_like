package com.epam.service

trait Processor {
    def addMessageToWall(subscriberWallName: String, message: String) {}
}