package com.epam.io

import java.io.File
import java.io.PrintWriter

import scala.io.Source

class FileOperation {
    
    val RELATIONS_FILE_NAME = "relations.txt";
    
    def readRelations(): List[String] = {
        var relations = List[String]()

        Source.fromFile(RELATIONS_FILE_NAME).getLines().foreach { line =>
            if (!line.isEmpty()) {
                val trimedLine = line.toString().trim()
                relations = relations.::(trimedLine)
            }
        }
        return relations
    }

    def writeRelations(relations: List[String]) {
        val writer = new PrintWriter(new File(RELATIONS_FILE_NAME))
        relations.foreach { line => writer.write(line) }
        writer.close()
    }
}