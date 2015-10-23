package com.epam.service

import com.epam.io.FileOperation

class MessageProcessor (val fileOperation: FileOperation) extends Processor {
    override def addMessageToWall(wallName: String, message: String) {
        // we assume that one message takes only one line
        var messages = fileOperation.readLinesFromFile(wallName)
        messages = messages.::(message)
        fileOperation.writeLinesToFile(wallName, messages)
    }
}