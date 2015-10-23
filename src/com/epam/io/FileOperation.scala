package com.epam.io

import java.io.File
import java.io.PrintWriter

import scala.io.Source

class FileOperation {
    def readLinesFromFile(fileName:String): List[String] = {
        var lines = List[String]()

        Source.fromFile(fileName).getLines().foreach { line =>
            if (!line.isEmpty()) {
                val trimedLine = line.toString().trim()
                lines = lines.::(trimedLine)
            }
        }
        return lines
    }

    def writeLinesToFile(fileName:String, lines: List[String]) {
        val writer = new PrintWriter(new File(fileName))
        lines.foreach { line => writer.write(line + "\n")}
        writer.close()
    }
}